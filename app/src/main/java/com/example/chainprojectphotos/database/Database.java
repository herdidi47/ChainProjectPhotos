package com.example.chainprojectphotos.database;

import com.example.chainprojectphotos.R;
import com.example.chainprojectphotos.models.Photos;

import java.util.Vector;

public class Database {

    private Vector<Photos> listofPhotos;

    public Database() {
        listofPhotos = new Vector<>();
        listofPhotos.add(new Photos("Hallstatt Lake Scenery", "The View Hallstat Lake",
                R.drawable.hallstattlakescenery));
        listofPhotos.add(new Photos("Little Island in Seas", "Island in the middle of the sea",
                R.drawable.littleislandinseas));
        listofPhotos.add(new Photos("Sunset Scenery", "The View of Sunset",
                R.drawable.sunsetscenery));
    }

    public Vector<Photos> getListofPhotos() {
        return listofPhotos;
    }

    public void setListofPhotos(Vector<Photos> listofPhotos) {
        this.listofPhotos = listofPhotos;
    }
}
