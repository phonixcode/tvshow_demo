package com.alanson.tvshowsdemo.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.alanson.tvshowsdemo.repositories.MostPopularTVShowsRepository;
import com.alanson.tvshowsdemo.responses.TVShowsResponse;

public class MostPopularTVShowsViewModel extends ViewModel {

    private MostPopularTVShowsRepository mostPopularTVShowsRepository;

    public MostPopularTVShowsViewModel(){
        mostPopularTVShowsRepository = new MostPopularTVShowsRepository();
    }

    public LiveData<TVShowsResponse> getMostPopularTVShow(int page){
        return mostPopularTVShowsRepository.getMostPopularTVShows(page);
    }
}
