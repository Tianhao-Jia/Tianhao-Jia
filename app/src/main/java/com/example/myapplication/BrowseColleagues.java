package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BrowseColleagues extends AppCompatActivity {


    private DatabaseReference mbase;

    private RecyclerView recyclerView;
    viewColleagueAdapter adapter; // Create Object of the Adapter class

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_user);

        // Create a instance of the database and get
        // its reference
        mbase = FirebaseDatabase.getInstance().getReference();

        recyclerView = findViewById(R.id.reviewUsersRecyclerView);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Colleague> options = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("colleagues").child(Session.getUserID());
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("number",Long.toString(snapshot.getChildrenCount()));

                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    String email = dataSnapshot.child("email").getValue().toString();
                    String name = dataSnapshot.child("name").getValue().toString();
                    Colleague colleague = new Colleague(email, name);
                    options.add(colleague);
                }

                // Connecting object of required Adapter class to
                // the Adapter class itself
                adapter = new viewColleagueAdapter(options);
                // Connecting Adapter class with the Recycler view*/
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Log.d("Length",Integer.toString(options.size()));

    }
}