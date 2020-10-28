package com.example.animationdemo

import android.animation.Animator
import android.animation.AnimatorInflater
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.widget.ImageView
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var targetImage: ImageView
    lateinit var gpsAnimation: AnimationDrawable;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        targetImage = image

        targetImage.setOnClickListener {
            stopDrawableAnimation()
            engorge()
        }

    }

    override fun onStart() {

        super.onStart()
        animateDrawable()

    }

    fun animateDrawable() {

        targetImage.setBackgroundResource(R.drawable.gps_animation)
        gpsAnimation = targetImage.background as AnimationDrawable
        gpsAnimation.start()

    }

    fun stopDrawableAnimation() {

        if (gpsAnimation.isRunning) {

            gpsAnimation.stop()

        }

    }

    fun engorge() {

        val engorgeAnimator: Animator = AnimatorInflater.loadAnimator(this, R.animator.engorge).apply {

            setTarget(targetImage)
            start()

        }

        animateDrawable()

    }
}