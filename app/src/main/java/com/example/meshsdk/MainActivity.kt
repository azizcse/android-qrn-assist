package com.example.meshsdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val CHAPTER_COUNT = 114
    val JUZ2_COUNT = 30
    val TAG = "Test_case"
    val numberOfPages = DataSource.numberOfPages
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var next = 1
        var chap = 1
        for (juz in  1..JUZ2_COUNT) {
            Log.e(TAG,"Par  = $juz")
            next = if (juz == JUZ2_COUNT)
                numberOfPages + 1
            else
                DataSource.getStartingPageForJuz(juz + 1)

            while ((chap <= CHAPTER_COUNT) && (DataSource.getPageNumberForSura(chap) < next)){
              Log.e(TAG,"Chapter  = $chap  Page number ="+DataSource.getPageNumberForSura(chap))
                chap++
            }
        }
    }
}
