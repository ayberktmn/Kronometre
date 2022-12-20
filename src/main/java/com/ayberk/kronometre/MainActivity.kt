package com.ayberk.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.ViewAnimator
import com.ayberk.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var zamaniDurdur: Long = 0
        binding.btnStart.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime() + zamaniDurdur
            binding.kronometre.start()
            binding.btnStart.visibility = ViewAnimator.GONE
            binding.btnPause.visibility = ViewAnimator.VISIBLE
            binding.btnDevam.visibility = ViewAnimator.GONE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))


        }
        binding.btnPause.setOnClickListener {
            zamaniDurdur = binding.kronometre.base - SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnPause.visibility = ViewAnimator.GONE
            binding.btnStart.visibility = ViewAnimator.GONE
            binding.btnDevam.visibility = ViewAnimator.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

        }
        binding.btnReset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniDurdur=0
            binding.btnPause.visibility = ViewAnimator.GONE
            binding.btnStart.visibility = ViewAnimator.VISIBLE
            binding.btnDevam.visibility = ViewAnimator.GONE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.reset))

        }

        binding.btnDevam.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime() +zamaniDurdur
            binding.kronometre.start()
            binding.btnPause.visibility = ViewAnimator.VISIBLE
            binding.btnStart.visibility = ViewAnimator.GONE
            binding.btnDevam.visibility = ViewAnimator.GONE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))

        }
    }
}