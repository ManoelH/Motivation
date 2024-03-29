package com.manoelh.motivation.util

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences (context: Context) {

    private val mSharedPreferences: SharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString (key: String, value: String){
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getStoreString(key: String) = mSharedPreferences.getString(key, "")

}