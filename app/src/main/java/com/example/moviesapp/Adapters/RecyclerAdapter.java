package com.example.moviesapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.Listeners.OnMovieClickListener;
import com.example.moviesapp.Models.SearchArrayObject;
import com.example.moviesapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends  RecyclerView.Adapter<ViewHolder>{
    Context context;
    List<SearchArrayObject> searchArrayObjectList;
    OnMovieClickListener MovieClicklistener;

    public RecyclerAdapter(Context context, List<SearchArrayObject> searchArrayObjectList, OnMovieClickListener onMovieClicklistener) {
        this.context = context;
        this.searchArrayObjectList = searchArrayObjectList;
        this.MovieClicklistener = onMovieClicklistener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_movies_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView.setText(searchArrayObjectList.get(position).getTitle());
        holder.movie_actors.setText(searchArrayObjectList.get(position).getActors());
        holder.movie_rank.setText("IMDB Rank: " + searchArrayObjectList.get(position).getRank());
        holder.movie_year.setText("Year: " +searchArrayObjectList.get(position).getYear());
        Picasso.get().load(searchArrayObjectList.get(position).getImage()).into(holder.imageView_poster);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieClicklistener.onMovieClick(searchArrayObjectList.get(position).getTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchArrayObjectList.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView_poster;
    TextView textView, movie_year, movie_rank, movie_actors;
    CardView cardView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView_poster = itemView.findViewById(R.id.movie_poster);
        textView = itemView.findViewById(R.id.movie_title);
        movie_year = itemView.findViewById(R.id.movie_year);
        movie_rank = itemView.findViewById(R.id.movie_rank);
        movie_actors = itemView.findViewById(R.id.movie_actors);
        cardView = itemView.findViewById(R.id.movie_container);
    }
}
