package org.me.cloudalert_test

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val requestCodecPermission = 100
    private var appKey = GlobalVariable.getAppKey()
    private var androidID = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("abc","start00")
        //sd 卡許可權檢查
        if (ContextCompat.checkSelfPermission(this@MainActivity,
                Manifest.permission.READ_SMS) == PackageManager.PERMISSION_DENIED ||
            ContextCompat.checkSelfPermission(this@MainActivity,
                Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_DENIED ||
            ContextCompat.checkSelfPermission(this@MainActivity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ||
            ContextCompat.checkSelfPermission(this@MainActivity,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
            ContextCompat.checkSelfPermission(this@MainActivity,
                Manifest.permission.FOREGROUND_SERVICE) == PackageManager.PERMISSION_DENIED) {
            askPermission()
            Log.d("abc","start11")
        } else {
//            readSMSMessage()
            Log.d("abc","start22")
        }
        appKey = GlobalVariable.getAppKey()
//        if (appKey.isEmpty() || androidID.isEmpty() || phoneModel.isEmpty()) {
//            androidID = GlobalVariable.getAndroidID()
//            appKey = GlobalVariable.getAppKey()
//            phoneModel = GlobalVariable.getPhoneModel()
//        }

        Log.d("CloudAlert", "金鑰：$appKey")
        Log.d("CloudAlert", "Android ID：$androidID")
//        Log.d("CloudAlert", "手機型號：$phoneModel")
    }
    private fun askPermission() {
        Log.d("abc","askPermission")
        ActivityCompat.requestPermissions(
            this@MainActivity, arrayOf(
                Manifest.permission.READ_SMS,
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.FOREGROUND_SERVICE
            ), requestCodecPermission
        )
    }

}