package id.ilham.tasdiq.diqwallpaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ilham.tasdiq.diqwallpaper.adapter.MainAdapter
import id.ilham.tasdiq.diqwallpaper.databinding.ActivityMainBinding
import id.ilham.tasdiq.diqwallpaper.model.Detail
import id.ilham.tasdiq.diqwallpaper.view_model.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel
    private val mainAdapter=MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel=ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        with(binding){
            //untuk mengatur recyleview
            mainRvPicture.apply {
                setHasFixedSize(true)
                layoutManager=LinearLayoutManager(context)
                adapter=mainAdapter
            }
            //untuk menampilkan gambar ketika buka aplikasi
            if (viewModel.getDataImage().value == null){
                showData("cat")
            }
            //untuk mengatur search view
            mainSv.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                //berjalan ketika tombol sumbit di search/pencarian
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    if (p0 != null) {
                        showData(p0)
                        mainSv.clearFocus()
                    }
                    return true
                }
                //ketika text berubah maka tampilan juga akan berubah
                override fun onQueryTextChange(p0: String?): Boolean {
                    if (p0 != null) {
                        showData(p0)
                    }
                return false
                }

            })
        }
        //berfungsi untuk search item clik
        mainAdapter.setOnItemClickCallback(object : MainAdapter.OnItemClickCallback{
            override fun onItemClicked(detail: Detail) {
                //intent berfungsi untuk memindahkan activity
                val intent=Intent(this@MainActivity,DetailImageActivty::class.java)
                //untuk mengirim data melalui intent
                intent.putExtra(DetailImageActivty.EXTRA_DOWNLOAD,detail.downloads)
                intent.putExtra(DetailImageActivty.EXTRA_IMAGEHEIGHT,detail.imageHeight)
                intent.putExtra(DetailImageActivty.EXTRA_IMAGESIZE,detail.imageSize)
                intent.putExtra(DetailImageActivty.EXTRA_IMAGEWIDTH,detail.imageWidth)
                intent.putExtra(DetailImageActivty.EXTRA_LARGEIMAGE,detail.largeImageURL)
                intent.putExtra(DetailImageActivty.EXTRA_LIKES,detail.likes)
                intent.putExtra(DetailImageActivty.EXTRA_TAGS,detail.tags)
                intent.putExtra(DetailImageActivty.EXTRA_USER,detail.user)
                intent.putExtra(DetailImageActivty.EXTRA_VIEWS,detail.views)
                intent.putExtra(DetailImageActivty.EXTRA_USERIMAGEURL,detail.userImageURL)
                startActivity(intent)
            }
        })
    }

    private fun showData(query: String)= runBlocking {
        launch {
            //untuk mengambil data dari query search
            viewModel.setImage(query)
            delay(300)
            //mengambil data dari detail
            viewModel.getDataImage().observe(this@MainActivity,{ items ->
                if (items != null){
                    mainAdapter.updateData(items)
                }
            })
        }
    }
}