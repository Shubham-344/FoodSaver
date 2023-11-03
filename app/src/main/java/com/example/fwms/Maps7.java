package com.example.fwms;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
public class Maps7 extends FragmentActivity implements OnMapReadyCallback {
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps1);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLocation();
    }
    private void fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(), "You are Here", Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    assert supportMapFragment != null;
                    supportMapFragment.getMapAsync(Maps7.this);
                }
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Your Location");
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,12 ));
        googleMap.addMarker(markerOptions);
        LatLng bnglatLng1 = new LatLng(12.906543, 77.575111);
        MarkerOptions markerOptions1 = new MarkerOptions().position(bnglatLng1).title("HAYAT NURSERY");
        googleMap.addMarker(markerOptions1);
        LatLng bnglatLng2 = new LatLng(12.908134,77.577627);
        MarkerOptions markerOptions2 = new MarkerOptions().position(bnglatLng2).title("WASHI NURSERY GARDEN");
        googleMap.addMarker(markerOptions2);
        LatLng bnglatLng3 = new LatLng(12.917806, 77.569210);
        MarkerOptions markerOptions3 = new MarkerOptions().position(bnglatLng3).title("KRUPATNIDI NURSERY");
        googleMap.addMarker(markerOptions3);
        LatLng bnglatLng4 = new LatLng(12.914915, 77.563531);
        MarkerOptions markerOptions4 = new MarkerOptions().position(bnglatLng4).title("INDIAN FOREST AND SOCIAL NURSERY");
        googleMap.addMarker(markerOptions4);
        LatLng bnglatLng5 = new LatLng(12.903538, 77.579227);
        MarkerOptions markerOptions5 = new MarkerOptions().position(bnglatLng5).title("GREENHOUSE GALLERY");
        googleMap.addMarker(markerOptions5);
        LatLng bnglatLng6 = new LatLng(12.902186, 77.582906);
        MarkerOptions markerOptions6 = new MarkerOptions().position(bnglatLng6).title("Sri Manjunatha Nursery");
        googleMap.addMarker(markerOptions6);
        LatLng bnglatLng7 = new LatLng(12.891219, 77.575960);
        MarkerOptions markerOptions7 = new MarkerOptions().position(bnglatLng7).title("Pradeep Nursery");
        googleMap.addMarker(markerOptions7);
        LatLng bnglatLng8 = new LatLng(12.885356, 77.575657);
        MarkerOptions markerOptions8 = new MarkerOptions().position(bnglatLng8).title("Lakshmi Nursery");
        googleMap.addMarker(markerOptions8);
        LatLng bnglatLng9 = new LatLng(12.88538,77.575633);
        MarkerOptions markerOptions9 = new MarkerOptions().position(bnglatLng9).title("Dilip Nursery garden");
        googleMap.addMarker(markerOptions9);
        googleMap.addCircle(new CircleOptions()
                .center(latLng)
                .radius(1000)
                .fillColor(R.color.lightgreen)
                .strokeColor(R.color.darkgreen));
        googleMap.addCircle(new CircleOptions()
                .center(latLng)
                .radius(5000)
                .fillColor(R.color.red)
                .strokeColor(R.color.darkred));
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation();
                }
                break;
        }
    }
}