package uz.unzosoft.unzomovie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.unzosoft.unzomovie.remote.MovieInterface
import uz.unzosoft.unzomovie.ui.movie.MoviePaging
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(private val movieInterface: MovieInterface) : ViewModel() {

    private val queryMutableLiveData = MutableLiveData("")

    val listPager = queryMutableLiveData.switchMap {
        Pager(PagingConfig(pageSize = 10)) {
            MoviePaging("", movieInterface)
        }.liveData.cachedIn(viewModelScope)
    }

    fun setQuery(s: String) {
        queryMutableLiveData.postValue(s)
    }

}