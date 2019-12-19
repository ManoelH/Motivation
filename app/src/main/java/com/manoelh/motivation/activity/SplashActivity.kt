package com.manoelh.motivation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.manoelh.motivation.R
import com.manoelh.motivation.util.Constants
import com.manoelh.motivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        securityPreferences = SecurityPreferences(applicationContext)
        setContentView(R.layout.activity_splash)
        buttonSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave)
            saveUserName()
    }

    private fun saveUserName(){
        val userName = editTextName.text.toString()
        if (userName == "")
            Toast.makeText(applicationContext, getString(R.string.ENTER_A_NAME), Toast.LENGTH_LONG).show()
        else{
            securityPreferences.storeString(Constants.KEY.USER_NAME_KEY, userName)
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
