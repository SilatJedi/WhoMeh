package com.silatsaktistudios.whomeh.Models;

import java.util.ArrayList;
import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by SilatJedi on 9/29/17.
 */

public class Deal extends RealmObject {
    @PrimaryKey
    private String id;
    private String features;
    private String title;
    private String specifications;
    private Date soldOutDate;
    private RealmList<Photo> photos;
    private Video video;

    public Deal() {}
    public Deal(String id, String features, String title, String specifications, Date soldOutDate, RealmList<Photo> photos, Video video) {
        setId(id);
        setFeatures(features);
        setTitle(title);
        setSpecifications(specifications);
        setSoldOutDate(soldOutDate);
        setPhotos(photos);
        setVideo(video);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFeatures() {
        return features;
    }

    private void setFeatures(String features) {
        this.features = features;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getSpecifications() {
        return specifications;
    }

    private void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Date getSoldOutDate() {
        return soldOutDate;
    }

    private void setSoldOutDate(Date soldOutDate) {
        this.soldOutDate = soldOutDate;
    }

    public RealmList<Photo> getPhotos() {
        return photos;
    }

    private void setPhotos(RealmList<Photo> photos) {
        this.photos = photos;
    }

    public Video getVideo() {
        return video;
    }

    private void setVideo(Video video) {
        this.video = video;
    }
}
