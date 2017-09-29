package com.silatsaktistudios.whomeh.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by SilatJedi on 9/29/17.
 */

public class Photo extends RealmObject {
    @PrimaryKey
    private String url;

    public Photo() {}
    public Photo(String url) {
        setUrl(url);
    }

    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }
}
