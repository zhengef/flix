package com.example.flixster

import org.json.JSONArray

// one movie object that we display in UI
// add attributes we actually want to display
data class Movie(
    val movieId: Int,
    private val posterPath: String, //client doesn't need this
    val title: String,
    val overview: String,
) { //companion object that allows us to call methods on movie class witout having instance
    val posterImageUrl = "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"), //refer to name of attributes in JSON
                        movieJson.getString("poster_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }

}