package com.info.movieappmvvm.data.api

import com.info.movieappmvvm.data.vo.MovieDetails
import com.info.movieappmvvm.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface TheMovieDBInterface {

   // https://api.themoviedb.org/3/movie/popular?api_key=2ee8413d62af30323963e01278e0edd3&page=1
   // https://api.themoviedb.org/3/movie/616037?api_key=2ee8413d62af30323963e01278e0edd3
   // https://api.themoviedb.org/3/

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page : Int) : Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id : Int): Single<MovieDetails>


}