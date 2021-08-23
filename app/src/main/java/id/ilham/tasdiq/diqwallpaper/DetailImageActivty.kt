package id.ilham.tasdiq.diqwallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.ilham.tasdiq.diqwallpaper.databinding.ActivityDetailImageBinding

class DetailImageActivty : AppCompatActivity() {
    private lateinit var binding: ActivityDetailImageBinding
    companion object{
        const val EXTRA_IMAGEWIDTH = "imageWidth"
        const val EXTRA_LARGEIMAGE = "largeImageURL"
        const val EXTRA_IMAGEHEIGHT = "imageHeight"
        const val EXTRA_IMAGESIZE = "imageSize"
        const val EXTRA_VIEWS = "views"
        const val EXTRA_DOWNLOAD = "downloads"
        const val EXTRA_LIKES = "likes"
        const val EXTRA_USER = "user"
        const val EXTRA_USERIMAGEURL = "userImageURL"
        const val EXTRA_TAGS = "tags"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //untuk nerima data dari intent
        val widht= intent.getStringExtra(EXTRA_IMAGEWIDTH)
        val image= intent.getStringExtra(EXTRA_LARGEIMAGE)
        val height= intent.getStringExtra(EXTRA_IMAGEHEIGHT)
        val size= intent.getStringExtra(EXTRA_IMAGESIZE)
        val views= intent.getStringExtra(EXTRA_VIEWS)
        val download= intent.getStringExtra(EXTRA_DOWNLOAD)
        val likes= intent.getStringExtra(EXTRA_LIKES)
        val username= intent.getStringExtra(EXTRA_USER)
        val userimage= intent.getStringExtra(EXTRA_USERIMAGEURL)
        val tags= intent.getStringExtra(EXTRA_TAGS)
        //set view
        with(binding){
            Glide.with(this@DetailImageActivty)
                .load(image)
                .apply(RequestOptions().centerCrop())
                .into(detailImage)
            Glide.with(this@DetailImageActivty)
                .load(userimage)
                .apply(RequestOptions().centerCrop())
                .into(detailCivUser)
            detailWidth.text=widht
            detailHeigth.text=height
            detailSize.text=size
            detailView.text=views
            detailDownload.text=download
            detailLikes.text=likes
            detailUserName.text=username
            detailTags.text=tags
        }
    }
}