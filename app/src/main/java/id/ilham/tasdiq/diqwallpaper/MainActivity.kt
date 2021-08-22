package id.ilham.tasdiq.diqwallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ilham.tasdiq.diqwallpaper.adapter.MainAdapter
import id.ilham.tasdiq.diqwallpaper.databinding.ActivityMainBinding
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
            mainRvPicture.apply {
                setHasFixedSize(true)
                layoutManager=LinearLayoutManager(context)
                adapter=mainAdapter
            }
            mainSv.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    if (p0 != null)
                    showData(p0)
                    mainSv.clearFocus()
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                return false
                }

            })
        }

    }

    private fun showData(query: String)= runBlocking {
        launch {
            viewModel.setImage(query)
            delay(500)
            viewModel.getDataImage().observe(this@MainActivity,{
                items ->
                    mainAdapter.updateData(items)

            })
        }
    }
}