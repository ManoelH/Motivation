package com.manoelh.motivation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.manoelh.motivation.R
import com.manoelh.motivation.mock.Mock
import com.manoelh.motivation.util.Constants
import com.manoelh.motivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mFilter = Constants.PHRASE_CATEGORY.ALL
    private val mock: Mock = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSecurityPreferences = SecurityPreferences(applicationContext)
        setListeners()
        filter(R.id.imageViewInfinity)
        insertUserNameToTextViewUser()
    }

    private fun setListeners(){
        imageViewInfinity.setOnClickListener(this)
        imageViewGoodMorning.setOnClickListener(this)
        imageViewHappy.setOnClickListener(this)
        buttonSavePhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        var listIdsFilter = listOf(R.id.imageViewInfinity, R.id.imageViewGoodMorning, R.id.imageViewHappy)
        if (id in listIdsFilter)
            filter(id)
        else if (id == R.id.buttonSavePhrase)
            refreshPhrases()
    }

    private fun filter(id: Int){

        imageViewGoodMorning.setImageResource(R.drawable.ic_sun_unselected)
        imageViewHappy.setImageResource(R.drawable.ic_happy_unselected)
        imageViewInfinity.setImageResource(R.drawable.ic_infinity_unselected)

        if (id == R.id.imageViewInfinity){
            mFilter = Constants.PHRASE_CATEGORY.ALL
            imageViewInfinity.setImageResource(R.drawable.ic_infinity_selected)
        }
        else if (id == R.id.imageViewGoodMorning){
            mFilter = Constants.PHRASE_CATEGORY.GOOD_MORNING
            imageViewGoodMorning.setImageResource(R.drawable.ic_sun_selected)
        }
        else{
            mFilter = Constants.PHRASE_CATEGORY.HAPPY
            imageViewHappy.setImageResource(R.drawable.ic_happy_selected)
        }
        textViewPhrase.text = mock.getPhrase(mFilter)
    }

    private fun refreshPhrases(){
        textViewPhrase.text = mock.getPhrase(mFilter)
    }

    private fun insertUserNameToTextViewUser(){
        textViewUser.text = "Hello, ${mSecurityPreferences.getStoreString(Constants.KEY.USER_NAME_KEY)}!"
    }
}
