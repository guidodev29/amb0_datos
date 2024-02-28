package sv.edu.ufg.fis.amb.activity_datos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityDataReception : AppCompatActivity() {

    private lateinit var Nombres: TextView
    private lateinit var Apellidos: TextView
    private lateinit var Email: TextView
    private lateinit var Salir: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_reception)

        Nombres = findViewById(R.id.lbl_nombres_res)
        Apellidos = findViewById(R.id.lbl_apellidos_res)
        Email = findViewById(R.id.lbl_email_res)
        Salir = findViewById(R.id.btnSalir)

        val intent = intent
        val nombres = intent.getStringExtra("nombres")
        val apellidos = intent.getStringExtra("apellidos")
        val email = intent.getStringExtra("email")

        Nombres.text = nombres
        Apellidos.text = apellidos
        Email.text = email

        Salir.setOnClickListener{
            finish()
        }
    }
}