package com.example.moviesapp;

import android.content.Context;
import android.widget.Toast;

import com.example.moviesapp.Listeners.OnSearchApiListener;
import com.example.moviesapp.Models.SearchApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://imdb-search2.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void SearchMovies(OnSearchApiListener listener, String movie_name){
        getMovies getMovies = retrofit.create(RequestManager.getMovies.class);
        Call<SearchApiResponse> call = getMovies.callMovies(movie_name);

        call.enqueue(new Callback<SearchApiResponse>() {
            @Override
            public void onResponse(Call<SearchApiResponse> call, Response<SearchApiResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(context, "Couldn't fetch the data ", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<SearchApiResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public interface getMovies {
        @Headers({
                "ACCEPT: application/json",
                "X-RapidAPI-Host: imdb-search2.p.rapidapi.com",
                "X-RapidAPI-Key: 8b1a08cc54msh52ce47b7a71060ap101ac7jsn2d38471dcd4f"
        })
        @GET("{movie_name}")
        Call<SearchApiResponse> callMovies(
                @Path("movie_name") String movie_name
        );
    }
}
