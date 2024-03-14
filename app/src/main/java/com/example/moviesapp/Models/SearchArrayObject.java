package com.example.moviesapp.Models;

import com.google.gson.annotations.SerializedName;

public class SearchArrayObject {

    @SerializedName("#TITLE")
    private String title;
    @SerializedName("#YEAR")
    private String year;
    @SerializedName("#IMDB_ID")
    private String id;
    @SerializedName("#IMG_POSTER")
    private String image;
    @SerializedName("#RANK")
    private String rank;
    @SerializedName("#ACTORS")
    private String actors;

    public SearchArrayObject(String title, String year, String id, String image, String rank, String actors) {
        this.title = title;
        this.year = year;
        this.id = id;
        this.image = image;
        this.rank = rank;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

}
