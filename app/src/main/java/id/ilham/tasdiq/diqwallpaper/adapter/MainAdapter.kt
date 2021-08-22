package id.ilham.tasdiq.diqwallpaper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ilham.tasdiq.diqwallpaper.databinding.LayoutItemBinding
import id.ilham.tasdiq.diqwallpaper.model.Detail

class MainAdapter:RecyclerView.Adapter<MainAdapter.ListViewHolder>() {
    private val imageList=ArrayList<Detail>()

    fun updateData(newData:ArrayList<Detail>){
        imageList.clear()
        imageList.addAll(newData)
        notifyDataSetChanged()
    }
    inner class ListViewHolder(private val binding: LayoutItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(detail: Detail) {
            with(binding){
                Glide.with(itemView.context)
                    .load(detail.previewURL)
                    .apply(RequestOptions().centerCrop())
                    .into(itemImage)
                itemDownloads.text=detail.downloads
                itemUser.text=detail.user
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ListViewHolder {
        val binding=LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.ListViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount():Int=imageList.size
}