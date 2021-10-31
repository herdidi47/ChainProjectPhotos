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

import com.example.chainprojectphotos.adapter.PhotoAdapter;
import com.example.chainprojectphotos.database.Database;

public class ManagePhoto extends AppCompatActivity {

    RecyclerView rvPhotos;
    Database database;
    PhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_photo);

        bind();

        rvPhotos.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvPhotos.setAdapter(adapter);
    }

    public boolean onCreateOptionsMenu(Menu menumanage) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menumanage);
        return super.onCreateOptionsMenu(menumanage);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menuHome:

                Intent intent = new Intent(ManagePhoto.this,Home.class);
                startActivity(intent);

                break;
        }

        switch (item.getItemId()){


            case R.id.menuLogout:
                Intent keLogin = new Intent(ManagePhoto.this,MainActivity.class);
                startActivity(keLogin);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void bind(){
        rvPhotos = findViewById(R.id.mainPhoto);
        database = new Database();
        adapter = new PhotoAdapter(database.getListofPhotos());
    }
}