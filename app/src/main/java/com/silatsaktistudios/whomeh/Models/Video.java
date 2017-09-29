package com.silatsaktistudios.whomeh.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by SilatJedi on 9/29/17.
 */

public class Video extends RealmObject {
    @PrimaryKey
    private String id;
    private String title;
    private String url;

    public Video() {}
    public Video(String id, String title, String url) {
        setId(id);
        setTitle(title);
        setUrl(url);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }
}
