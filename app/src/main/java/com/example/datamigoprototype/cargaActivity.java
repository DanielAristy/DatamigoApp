package com.example.datamigoprototype;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class  cargaActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button btnFecha;
    TextView txtPickerFecha;
    int month, day, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);
        imageView = findViewById(R.id.imgFactura);
        inicializacion();
        btnFecha.setOnClickListener(this);
    }

    private void inicializacion() {
        btnFecha = findViewById(R.id.btnFecha);
        txtPickerFecha = findViewById(R.id.txtPickerFecha);
    }

    public void loadImage(View view) {
        tomarFoto();
    }
    public void selectImage(View view) {
        cargarImagen();
    }

    private void tomarFoto(){
        Intent tomarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(tomarFoto,200);
    }
    private void cargarImagen() {
        Intent cargarFoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(cargarFoto, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            imageView.setImageURI(data.getData());
        }
        if (requestCode == 200 && resultCode == RESULT_OK) {
            imageView.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }
    }

    public void registrarFactura(View view) {
        Intent registroFactura = new Intent(this,ThreeActivity.class);
        startActivity(registroFactura);
    }

    @Override
    public void onClick(View view) {
        if (view == btnFecha) {
            Calendar calendar = Calendar.getInstance();
            day = calendar.get(Calendar.DAY_OF_MONTH);
            month = calendar.get(Calendar.MONTH);
            year = calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(cargaActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    txtPickerFecha.setText(dayOfMonth+"/"+(month + 1)+"/"+year);
                }
            }
            ,day,month,year);
            datePickerDialog.show();
        }
    }
}
