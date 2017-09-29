package com.silatsaktistudios.whomeh;

import android.support.annotation.NonNull;

import com.silatsaktistudios.whomeh.Models.Deal;
import com.silatsaktistudios.whomeh.Models.Photo;
import com.silatsaktistudios.whomeh.Models.Video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by SilatJedi on 9/29/17.
 *
 */

class API{

    private static final String HOST = "https://api.meh.com";
    private static final String ENDPOINT = "/1/current.json?apikey=";
    private static final String API_KEY = "7LeP9UHbDlMtWn3GvOI7NzZszcGcPdEy";

    static void getFeed(final GetDealListener getDealListener) {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = HttpUrl.parse(HOST + ENDPOINT + API_KEY);
        assert url != null;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                LogHelper.logDebug(e.getMessage());
            }

            @SuppressWarnings("ConstantConditions")
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try {
                    String responseBody = response.body().string();
                    LogHelper.logDebug(responseBody);
                    try {
                        JSONObject parentObject = new JSONObject(responseBody);
                        JSONObject dealObject = parentObject.getJSONObject("deal");
                        JSONArray launchArray = dealObject.getJSONArray("launches");
                        JSONObject videoObject = parentObject.getJSONObject("video");
                        JSONArray photoArray = dealObject.getJSONArray("photos");

                        String id = dealObject.getString("id");
                        String features = dealObject.getString("features");
                        String title = dealObject.getString("title");
                        String specifications = dealObject.getString("specifications");

                        String sSoldOutDate = launchArray.getJSONObject(launchArray.length() - 1).getString("soldOutAt");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
                        Date dSoldOutDate = new Date();
                        if(!sSoldOutDate.equals("null")) {
                            dSoldOutDate = sdf.parse(sSoldOutDate);
                        }

                        RealmList<Photo> photos = new RealmList<>();
                        for (int i = 0; i < photoArray.length(); i++) {
                            photos.add(new Photo(photoArray.getString(i)));
                        }

                        Video video = new Video(
                                videoObject.getString("id"),
                                videoObject.getString("title"),
                                videoObject.getString("url"));

                        final Deal deal = new Deal(
                                id,
                                features,
                                title,
                                specifications,
                                sSoldOutDate == null ? null : dSoldOutDate,
                                photos,
                                video);

                        Realm realm = Realm.getDefaultInstance();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(@NonNull Realm realm) {
                                realm.insertOrUpdate(deal);
                                getDealListener.onGetDeal();
                            }

                        });
                    }
                    catch (JSONException | ParseException e) {
                        LogHelper.logException(e);
                    }
                }
                catch(NullPointerException e) {
                    LogHelper.logException(e);
                }
            }
        });
    }
}
