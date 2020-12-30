package com.alanson.tvshowsdemo.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.alanson.tvshowsdemo.repositories.SearchTVShowRepository;
import com.alanson.tvshowsdemo.responses.TVShowsResponse;

public class SearchViewModel extends ViewModel {

    private SearchTVShowRepository searchTVShowRepository;

    public SearchViewModel(){
        searchTVShowRepository = new SearchTVShowRepository();
    }

    public LiveData<TVShowsResponse> searchTVShow(String query, int page){
        return searchTVShowRepository.SearchTVShow(query, page);
    }
}
