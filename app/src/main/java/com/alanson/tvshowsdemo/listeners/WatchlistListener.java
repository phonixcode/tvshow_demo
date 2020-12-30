package com.alanson.tvshowsdemo.listeners;

import com.alanson.tvshowsdemo.models.TVShow;

public interface WatchlistListener {
    void onTVShowClicked(TVShow tvShow);

    void removedTVShowFromWatchlist(TVShow tvShow, int position);
}
