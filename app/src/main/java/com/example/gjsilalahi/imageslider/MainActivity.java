package com.example.gjsilalahi.imageslider;

import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CustomPagerAdapter mCustomPagerAdapter;
    ViewPager mViewPager;
    CardView cardView1, cardView2;
    //MEMANGGIL LIBRARY WIDGET

    int mImage[] = {
            R.drawable.gambar1,
            R.drawable.gambar2,
    }; //ARRAY DARI GAMBAR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.pager);
        mCustomPagerAdapter = new CustomPagerAdapter(MainActivity.this, mImage);
        mViewPager.setAdapter(mCustomPagerAdapter);
        cardView1 = findViewById(R.id.cvInfo);
        cardView2 = findViewById(R.id.cvQuit);

        //MEMBUAT CARDVIEW DAPAT DI KLIK
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MEMBUAT DIALOG MESSAGE
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("INFO APLIKASI");
                builder.setMessage(R.string.app_info);
                builder.setPositiveButton("OKE BOY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Anda yakin ingin keluar ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit = builder.create();
                quit.show();

            }
        });
    }
}
