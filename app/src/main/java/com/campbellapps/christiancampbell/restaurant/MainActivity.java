package com.campbellapps.christiancampbell.restaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Firebase mRootRef;
    ArrayList<String> mMessages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FirebaseStorage storage = FirebaseStorage.getInstance();
        Firebase.setAndroidContext(this);

        mRootRef = new Firebase("https://restaurantroulette-89089.firebaseio.com/");

    }

    @Override
    protected void onStart() {
        super.onStart();

        final Firebase magoffinRef = mRootRef.child("Magoffin/Mcdonalds");
        magoffinRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String list = dataSnapshot.getValue().toString();
                Log.d("please", list);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
