package com.niaa.datosgsonniaa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre, txtEdad, txtCorreo, txtCurp;
    TextView lblJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = findViewById(R.id.txtNombre);
        txtEdad = findViewById(R.id.txtEdad);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtCurp = findViewById(R.id.txtCurp);
        lblJson = findViewById(R.id.lblJson);
    }
    public void convertirjson(View v){
        Datos datosobj = new Datos(txtNombre.getText().toString(),Integer.parseInt(txtEdad.getText().toString()),txtCorreo.getText().toString(),txtCurp.getText().toString());
        Gson gson = new Gson();
        String cjson = gson.toJson(datosobj);
        lblJson.setText(cjson);
        Datos datosobj1 = gson.fromJson(cjson,Datos.class);
        Log.i("JSON – –>","NOMBRE" + datosobj1.getNombre() + " , EDAD" + datosobj1.getEdad() + ", CORREO" + datosobj1.getCorreo() + ", CURP" + datosobj1.getCurp());

    }
}
