package es.ieslavereda.componentes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private TextView textViewCB;
    private TextView textViewS;
    private RadioGroup sexoRG;
    private ArrayList<Usuario> usuarios;
    private TextInputEditText nombre;
    private TextInputEditText apellidos;
    private Button aceptar;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox01);
        textViewCB = findViewById(R.id.textViewCB);
        sexoRG = findViewById(R.id.radioGroup);
        textViewS = findViewById(R.id.textViewSeleccion);
        nombre=findViewById(R.id.nombre);
        apellidos=findViewById(R.id.apellidos);
        spinner=findViewById(R.id.spinner);
        aceptar=findViewById(R.id.buttonAdd);

        if (savedInstanceState != null){
            usuarios=(ArrayList<Usuario>) savedInstanceState.getSerializable("usuarios");
        }else {
            usuarios=new ArrayList<>();
            usuarios.add(new Usuario("Joaquin", "Alonso Saiz"));
            usuarios.add(new Usuario("Xavier","Rosillo Guerrero"));
        }

        ArrayAdapter<Usuario> miAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, usuarios);
        spinner.setAdapter(miAdaptador);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()){
                    textViewCB.setText("CheckBox activado");
                }else {
                    textViewCB.setText("CheckBox desactivado");
                }
            }
        });

        sexoRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.radioButtonHombre){
                    textViewS.setText("HOMBRE");
                } else if (i==R.id.radioButtonMujer) {
                    textViewS.setText("MUJER");
                } else if (i==R.id.radioButtonOtro) {
                    textViewS.setText("OTRO");
                }else {
                    textViewS.setText("ERROR EN LA SELECCIÓN DE SEXO");
                }
            }
        });
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("usuario", usuarios);
    }
}