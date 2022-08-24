package com.info.movieappmvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.info.movieappmvvm.data.api.TheMovieDBInterface
import com.info.movieappmvvm.data.repository.MovieDetailsNetworkDataSource
import com.info.movieappmvvm.data.repository.NetworkState
import com.info.movieappmvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService : TheMovieDBInterface) {

    lateinit var  movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails ( compositeDisposable: CompositeDisposable, movieId : Int) : LiveData<MovieDetails>{
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)
        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }

}