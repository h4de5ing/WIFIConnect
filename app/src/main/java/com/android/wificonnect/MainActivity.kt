package com.android.wificonnect

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

/**
 * http://www.aospxref.com/android-10.0.0_r47/xref/packages/apps/Settings/src/com/android/settings/wifi/dpp/WifiDppEnrolleeActivity.java
 */
@RequiresApi(Build.VERSION_CODES.Q)
class MainActivity : AppCompatActivity() {
    private lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        findViewById<Button>(R.id.start).setOnClickListener {
            easy()
        }
    }

    private fun easy() {
        try {
            val INTENT_ACTION_WIFI_QR_SCANNER = "android.settings.WIFI_DPP_ENROLLEE_QR_CODE_SCANNER"
            if (wifiManager.isEasyConnectSupported) {
                val intent = Intent(INTENT_ACTION_WIFI_QR_SCANNER)
                startActivityForResult(intent, 5000)
            }
        } catch (e: Exception) {
        }
    }
}