package br.com.spacedev.spacedev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Deixando o conteúdo da Activity
        window.setFlags(

            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN

        )

        setContentView(R.layout.activity_launch)

        //Contando 3 segundos e passando para a próxima janela (fila paralela de processos)
        Handler().postDelayed({

            val intentMain = Intent(this, MainActivity::class.java)

            startActivity(intentMain)
            finish()

        },2000)

    }
}
