package com.example.datamigoprototype;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class cargaActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);
        imageView = findViewById(R.id.imgFactura);
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
}
