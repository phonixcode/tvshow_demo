package com.alanson.tvshowsdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alanson.tvshowsdemo.R;
import com.alanson.tvshowsdemo.databinding.ItemTvShowsBinding;
import com.alanson.tvshowsdemo.listeners.WatchlistListener;
import com.alanson.tvshowsdemo.models.TVShow;

import java.util.List;

public class WatchlistAdapter extends RecyclerView.Adapter<WatchlistAdapter.TVShowsViewHolder>{

    private List<TVShow> tvShows;
    private LayoutInflater layoutInflater;
    private WatchlistListener watchlistListener;

    public WatchlistAdapter(List<TVShow> tvShows, WatchlistListener watchlistListener) {
        this.tvShows = tvShows;
        this.watchlistListener = watchlistListener;
    }

    @NonNull
    @Override
    public TVShowsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemTvShowsBinding tvShowsBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.item_tv_shows, parent, false
        );
        return new TVShowsViewHolder(tvShowsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowsViewHolder holder, int position) {
        holder.bindTVShow(tvShows.get(position));
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

   class TVShowsViewHolder extends RecyclerView.ViewHolder{

        private ItemTvShowsBinding itemTvShowsBinding;

        public TVShowsViewHolder(ItemTvShowsBinding itemTvShowsBinding){
            super(itemTvShowsBinding.getRoot());
            this.itemTvShowsBinding = itemTvShowsBinding;
        }

        public void bindTVShow(TVShow tvShow){
            itemTvShowsBinding.setTvShow(tvShow);
            itemTvShowsBinding.executePendingBindings();
            itemTvShowsBinding.getRoot().setOnClickListener(view ->
                    watchlistListener.onTVShowClicked(tvShow)
            );
            itemTvShowsBinding.imageDelete.setOnClickListener(view ->
                    watchlistListener.removedTVShowFromWatchlist(tvShow, getAdapterPosition())
            );
            itemTvShowsBinding.imageDelete.setVisibility(View.VISIBLE);
        }
    }
}
