package com.gmail.farrasabiyyu12.jakartafirefighter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    String nama, jabatan, wilayah, alamat, login, telepon;
    TextView tvDetailNama, tvDetailJabatan, tvDetailWilayah, tvDetailAlamat, tvDetailLogin;
    Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //TODO get data parse
        nama = getIntent().getStringExtra("nama");
        jabatan = getIntent().getStringExtra("jabatan");
        wilayah = getIntent().getStringExtra("wilayah");
        alamat = getIntent().getStringExtra("alamat");
        login = getIntent().getStringExtra("login");
        telepon = getIntent().getStringExtra("phone");

        //TODO bind textview
        tvDetailNama = findViewById(R.id.tvDetailNama);
        tvDetailJabatan = findViewById(R.id.tvDetailJabatan);
        tvDetailWilayah = findViewById(R.id.tvDetailWilayah);
        tvDetailAlamat = findViewById(R.id.tvDetailAlamat);
        tvDetailLogin = findViewById(R.id.tvDetailLogin);

        //TODO set textView text
        tvDetailNama.setText(nama);
        tvDetailJabatan.setText(jabatan);
        tvDetailLogin.setText(login);
        tvDetailAlamat.setText(alamat);
        tvDetailWilayah.setText(wilayah);

        //TODO bind button
        callButton = findViewById(R.id.btnCall);


        //TODO set onClick button
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPermissionGranted()) {
                    call_action();
                }
                /*
                if (callIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(callIntent);
                    }
                */
                /*
                if (ContextCompat.checkSelfPermission(DetailActivity.this,
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(DetailActivity.this,
                            Manifest.permission.CALL_PHONE)) {

                        // Show an expanation to the user *asynchronously* -- don't block
                        // this thread waiting for the user's response! After the user
                        // sees the explanation, try again to request the permission.
                        startActivity(iCall);

                    } else {

                        Toast.makeText(DetailActivity.this, "Terlemparkan", Toast.LENGTH_SHORT).show();
                        // No explanation needed, we can request the permission.

                        ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                MY_PERMISSIONS_REQUEST_READ_CONTACTS
                        );

                        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                        // app-defined int constant. The callback method gets the
                        // result of the request.
                    }
                }
                */
            }
        });

    }

    public void call_action(){
        Intent iCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telepon));
        startActivity(iCall);
    }
    //TODO Check Self Permission
    public  boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is granted");
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                    call_action();
                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
