package com.example.moviesapp.Listeners;

import com.example.moviesapp.Models.SearchApiResponse;

public interface OnSearchApiListener {
    void onResponse(SearchApiResponse response);
    void onError(String message);
}
