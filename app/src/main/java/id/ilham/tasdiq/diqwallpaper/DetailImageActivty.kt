package id.ilham.tasdiq.diqwallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ilham.tasdiq.diqwallpaper.databinding.ActivityDetailImageBinding

class DetailImageActivty : AppCompatActivity() {
    private lateinit var binding: ActivityDetailImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_image)
    }
}