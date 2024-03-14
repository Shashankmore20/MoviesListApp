package com.example.moviesapp.Models;

import java.util.List;

public class SearchApiResponse {
    List<SearchArrayObject> description = null;

    public List<SearchArrayObject> getDescription() {
        return description;
    }

    public void setDescription(List<SearchArrayObject> description) {
        this.description = description;
    }
}
