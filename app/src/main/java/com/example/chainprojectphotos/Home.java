package com.example.chainprojectphotos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.chainprojectphotos.adapter.PhotoAdapter;
import com.example.chainprojectphotos.database.Database;

public class Home extends AppCompatActivity {

    RecyclerView rvPhotos;
    Database database;
    PhotoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

        rvPhotos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvPhotos.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menuManage:

                Intent intent = new Intent(Home.this,ManagePhoto.class);
                startActivity(intent);

                break;
        }

        switch (item.getItemId()){


            case R.id.menuLogout:
                Intent keLogin = new Intent(Home.this,MainActivity.class);
                startActivity(keLogin);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init(){

        rvPhotos = findViewById(R.id.mainPhoto);
        database = new Database();
        adapter = new PhotoAdapter(database.getListofPhotos());
    }
}