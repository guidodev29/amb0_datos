package sv.edu.ufg.fis.amb.activity_datos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var txtNombres: EditText
    private lateinit var txtApellidos: EditText
    private lateinit var txtEmail: EditText
    private lateinit var btnGuardar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombres = findViewById(R.id.txt_nombres)
        txtApellidos = findViewById(R.id.txt_apellidos)
        txtEmail = findViewById(R.id.txt_email)
        btnGuardar = findViewById(R.id.btn_guardar)

        btnGuardar.setOnClickListener{
            if (txtNombres.getText().toString().isNullOrEmpty() || txtApellidos.getText().toString().isNullOrEmpty() || txtEmail.getText().toString().isNullOrEmpty()){
                mensaje("Campos Vacíos.", "Se ha detectado que al menos un campo está vacío ¿Desea Continuar?")
            }else{
                val intent = Intent(this,ActivityDataReception::class.java)
                intent.putExtra("Nombres",txtNombres.getText().toString())
                intent.putExtra("Apellidos",txtApellidos.getText().toString())
                intent.putExtra("Email",txtEmail.getText().toString())
                startActivity(intent)
            }
        }


    }
    fun mensaje(titulo:String,mensaje:String){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage(mensaje)
            .setTitle(titulo)
            .setPositiveButton("Aceptar") { _, _ ->
                // Do something.
            }
        /*.setNegativeButton("Cancelar") { _, _ ->
            // Do something else.
        }*/

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}