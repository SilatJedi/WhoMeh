package com.silatsaktistudios.whomeh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.silatsaktistudios.whomeh.Models.Deal;
import com.silatsaktistudios.whomeh.R;
import com.squareup.picasso.Picasso;

import io.realm.Realm;

/**
 * Created by SilatJedi on 9/29/17.
 *
 */

public class DealDetailFragment extends Fragment {

    private Deal deal;
    private boolean isDailyDeal = false;

    @SuppressWarnings("ConstantConditions")
    public static DealDetailFragment newInstance(String id) {
        Realm realm = Realm.getDefaultInstance();
        DealDetailFragment fragment = new DealDetailFragment();
        if (id == null) {
            fragment.deal = realm.copyFromRealm(realm.where(Deal.class).findAll().last());
            fragment.isDailyDeal = true;
        }
        else {
            fragment.deal = realm.copyFromRealm(realm.where(Deal.class).equalTo("id", id).findFirst());
            fragment.isDailyDeal = false;
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_deal_detail, container, false);

        if (!isDailyDeal) {
            TextView dailyDealTitle = (TextView) v.findViewById(R.id.dailyDealTitle);
            dailyDealTitle.setVisibility(View.GONE);
        }

        TextView title = (TextView) v.findViewById(R.id.dealTitle);
        title.setText(deal.getTitle());

        LinearLayout picContainer = (LinearLayout) v.findViewById(R.id.dealPicContainer);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5,5,5,5);
        for (int i = 0; i < deal.getPhotos().size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Picasso.with(getActivity())
                    .load(deal.getPhotos().get(i).getUrl())
                    .resize(400, 400)
                    .centerInside()
                    .into(imageView);
            picContainer.addView(imageView);
        }

        TextView featureTextView = (TextView) v.findViewById(R.id.dealFeatureText);
        featureTextView.setText(deal.getFeatures());

        TextView specTextView = (TextView) v.findViewById(R.id.dealSpecText);
        specTextView.setText(deal.getSpecifications());

        TextView soldTextView = (TextView) v.findViewById(R.id.dealSoldText);
        soldTextView.setText(deal.getSoldOutDate().toString());

        return v;
    }
}
