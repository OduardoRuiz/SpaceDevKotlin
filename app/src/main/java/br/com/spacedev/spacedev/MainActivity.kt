package br.com.spacedev.spacedev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.view.KeyEvent
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wvPrincipal.settings.javaScriptEnabled = true

        wvPrincipal.webViewClient = WebViewClient()


        btnIr.setOnClickListener {
            if (edtSite.text.isNotEmpty()){

                val enderecoSite = edtSite.text.toString()
                wvPrincipal.visibility = View.VISIBLE
                wvPrincipal.loadUrl("https://"+enderecoSite)

                wvPrincipal.setOnClickListener {

                    edtSite.setText(wvPrincipal.url).toString()

                }


            }
            else{

                Toast.makeText(this, "Preencha o campo com o site =D", Toast.LENGTH_LONG).show()
            }


        }


        btnVoltar.setOnClickListener {
            if (wvPrincipal.canGoBack())
                wvPrincipal.goBack()
        }

        btnAvancar.setOnClickListener {
            if (wvPrincipal.canGoForward())
                wvPrincipal.goForward()
        }

        btnHome.setOnClickListener{

            wvPrincipal.loadUrl("https://google.com")
        }


    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check if the key event was the Back button and if there's history
        if (keyCode == KeyEvent.KEYCODE_BACK && wvPrincipal.canGoBack()) {
            wvPrincipal.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }
}
