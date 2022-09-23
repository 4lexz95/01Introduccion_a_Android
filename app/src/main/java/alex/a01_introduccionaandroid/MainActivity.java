package alex.a01_introduccionaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import alex.a01_introduccionaandroid.modelos.Usuario;

public class MainActivity extends AppCompatActivity {


    // Variables dee tipo vista con la interfaz
    private TextView lblContador;
    private Button btnClick;
    private EditText txtEmail;
    private EditText txtPass;
    private Button btnRegister;


    //Variables para la logica para decirle lo que tiene que hacer
    private int contador;

    private ArrayList<Usuario> listaUsuarios;




// inicialite components

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador =0;
listaUsuarios = new ArrayList<>();
        inicializaVistas();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Has pulsado el boton", Toast.LENGTH_SHORT).show();
                contador++;
                lblContador.setText(contador+ " veces");
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email =  txtEmail.getText().toString();
                String password = txtPass.getText().toString();
                Usuario user = new Usuario(email,password);
                listaUsuarios.add(user);
                Toast.makeText(MainActivity.this, user.toString() , Toast.LENGTH_SHORT).show();
                txtEmail.setText("");
                txtPass.setText("");
            }
        });

    }

    private void inicializaVistas() {
        lblContador = findViewById(R.id.lblContadorMain);

        btnClick = findViewById(R.id.btnClickMain);
        txtEmail = findViewById(R.id.txtEmailMain);
        txtPass = findViewById(R.id.txtPassMain);
        btnRegister = findViewById(R.id.btnRegisMain);
    }

    public void btnClickContador(View vista){
        contador++;
        lblContador.setText(contador+ " veces");
    }


}