package com.example.moviesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.moviesapp.Adapters.RecyclerAdapter;
import com.example.moviesapp.Listeners.OnMovieClickListener;
import com.example.moviesapp.Listeners.OnSearchApiListener;
import com.example.moviesapp.Models.SearchApiResponse;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener {

    SearchView search_view;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RequestManager manager;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        recyclerView = findViewById(R.id.recycler_view_home);

        dialog = new ProgressDialog(this);
        manager = new RequestManager(this);

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Please wait...");
                dialog.show();
                manager.SearchMovies(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnSearchApiListener listener = new OnSearchApiListener() {
        @Override
        public void onResponse(SearchApiResponse response) {
            dialog.dismiss();
            if(response == null){
                Toast.makeText(MainActivity.this, "No Data Available", Toast.LENGTH_SHORT).show();
                return;
            }
            showResult(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, "An Error Occurred", Toast.LENGTH_SHORT).show();
        }
    };

    private void showResult(SearchApiResponse response) {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        adapter = new RecyclerAdapter(this, response.getDescription(), this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onMovieClick(String title) {
//        Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
    }
}