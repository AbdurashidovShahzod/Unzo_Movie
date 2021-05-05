package uz.unzosoft.unzomovie.ui.movie

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.unzosoft.unzomovie.data.Search
import uz.unzosoft.unzomovie.databinding.ViewHolderMovieBinding

class MoviePagingAdapter : PagingDataAdapter<Search, MoviePagingAdapter.MyViewHolder>(DIFF_UTIl) {


    companion object {

        val DIFF_UTIl = object : DiffUtil.ItemCallback<Search>() {

            override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean =
                oldItem.imdbID == newItem.imdbID

            override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean =
                oldItem == newItem

        }


    }


    inner class MyViewHolder(private val viewDataBinding: ViewHolderMovieBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)




    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

    }

}