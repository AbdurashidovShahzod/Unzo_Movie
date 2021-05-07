package uz.unzosoft.unzomovie.ui.details

import uz.unzosoft.unzomovie.data.moviedetails.MovieDetails
import uz.unzosoft.unzomovie.remote.MovieInterface
import uz.unzosoft.unzomovie.utils.Result
import uz.unzosoft.unzomovie.utils.Status

class MovieDetailsRepository(private val movieInterface: MovieInterface) {


    suspend fun getMovieDetails(imdb: String): Result<MovieDetails> {

        try {

            val response = movieInterface.getMovieDetails(imdb)

            if (response.isSuccessful) {
                Result(Status.SUCCESS, response.body(), null)


            } else {
                Result(Status.ERROR, null, null)
            }


        } catch (e: Exception) {
            Result(Status.ERROR, null, null)
        }

    }
}