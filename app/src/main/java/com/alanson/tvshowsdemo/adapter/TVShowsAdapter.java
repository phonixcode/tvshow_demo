package com.alanson.tvshowsdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.alanson.tvshowsdemo.R;
import com.alanson.tvshowsdemo.databinding.ItemTvShowsBinding;
import com.alanson.tvshowsdemo.listeners.TVShowListener;
import com.alanson.tvshowsdemo.models.TVShow;

import java.util.List;

public class TVShowsAdapter extends RecyclerView.Adapter<TVShowsAdapter.TVShowsViewHolder>{

    private List<TVShow> tvShows;
    private LayoutInflater layoutInflater;
    private TVShowListener tvShowListener;

    public TVShowsAdapter(List<TVShow> tvShows, TVShowListener tvShowListener) {
        this.tvShows = tvShows;
        this.tvShowListener = tvShowListener;
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
            itemTvShowsBinding.getRoot().setOnClickListener(view -> tvShowListener.onTVShowClicked(tvShow));
        }
    }
}
