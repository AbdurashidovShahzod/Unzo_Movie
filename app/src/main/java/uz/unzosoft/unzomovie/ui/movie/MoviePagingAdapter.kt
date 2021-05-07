package uz.unzosoft.unzomovie.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import uz.unzosoft.unzomovie.BR
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


    inner class MyViewHolder(val viewDataBinding: ViewHolderMovieBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.setVariable(BR.movie, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ViewHolderMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

}