package com.rasheed.earthquake

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(),
    EarthQuakeFragment.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var upd : FloatingActionButton =findViewById(R.id.fab) as FloatingActionButton

        upd.setBackground(getDrawable(R.drawable.orange_circle_shape))
        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.fragmentContainer,
                    EarthQuakeFragment.newInstance()
                )
                .commit()
        }
        upd.setOnClickListener {
            val refresh = Intent(this, MainActivity::class.java)
            startActivity(refresh) //Start the same Activity
            finish()
            Log.e("hh","hi")
        }


    }

    override fun onEarthQuakeSelected(locationIntent: Intent) {
        if (locationIntent.resolveActivity(packageManager)!=null){
            startActivity(locationIntent)
        }

    }


}