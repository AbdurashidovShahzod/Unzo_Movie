package uz.unzosoft.unzomovie

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.unzosoft.unzomovie.data.moviedetails.MovieDetails
import uz.unzosoft.unzomovie.remote.MovieInterface
import uz.unzosoft.unzomovie.ui.movie.MoviePaging
import uz.unzosoft.unzomovie.utils.Events
import uz.unzosoft.unzomovie.utils.Result
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(private val movieInterface: MovieInterface) : ViewModel() {

    private val queryMutableLiveData = MutableLiveData("")

    val listPager = queryMutableLiveData.switchMap { queryMutableLiveData ->
        Pager(PagingConfig(pageSize = 10)) {
            MoviePaging(queryMutableLiveData, movieInterface)
        }.liveData.cachedIn(viewModelScope)
    }

    fun setQuery(s: String) {
        queryMutableLiveData.postValue(s)
    }


    private val _movieDetails = MutableLiveData<Events<Result<MovieDetails>>>()
    val movieDetails: LiveData<Events<Result<MovieDetails>>> = _movieDetails
    fun getMovieDetails(imbd: String) = viewModelScope.launch {


    }


}