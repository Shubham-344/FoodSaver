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
public class Maps8 extends FragmentActivity implements OnMapReadyCallback {
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
                    supportMapFragment.getMapAsync(Maps8.this);
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
        LatLng bnglatLng1 = new LatLng(12.990210, 77.500087);
        MarkerOptions markerOptions1 = new MarkerOptions().position(bnglatLng1).title("Halenhalli  slum");
        googleMap.addMarker(markerOptions1);
        LatLng bnglatLng2 = new LatLng(12.959548, 77.657358);
        MarkerOptions markerOptions2 = new MarkerOptions().position(bnglatLng2).title("Ragigudda slum");
        googleMap.addMarker(markerOptions2);
        LatLng bnglatLng3 = new LatLng(12.963132, 77.645235);
        MarkerOptions markerOptions3 = new MarkerOptions().position(bnglatLng3).title("Siddapura slum");
        googleMap.addMarker(markerOptions3);
        LatLng bnglatLng4 = new LatLng(12.896228, 77.652341);
        MarkerOptions markerOptions4 = new MarkerOptions().position(bnglatLng4).title("Rayapuram slum");
        googleMap.addMarker(markerOptions4);
        LatLng bnglatLng5 = new LatLng(13.011442, 77.482848);
        MarkerOptions markerOptions5 = new MarkerOptions().position(bnglatLng5).title("Risaldar slum");
        googleMap.addMarker(markerOptions5);
        LatLng bnglatLng6 = new LatLng(12.936236, 77.564828);
        MarkerOptions markerOptions6 = new MarkerOptions().position(bnglatLng6);
        googleMap.addMarker(markerOptions6);
        LatLng bnglatLng7 = new LatLng(12.924041, 77.567173);
        MarkerOptions markerOptions7 = new MarkerOptions().position(bnglatLng7);
        googleMap.addMarker(markerOptions7);
        LatLng bnglatLng8 = new LatLng(12.994444, 77.670679);
        MarkerOptions markerOptions8 = new MarkerOptions().position(bnglatLng8);
        googleMap.addMarker(markerOptions8);
        LatLng bnglatLng9 = new LatLng(12.959505, 77.592463);
        MarkerOptions markerOptions9= new MarkerOptions().position(bnglatLng9);
        googleMap.addMarker(markerOptions9);
        LatLng bnglatLng10 = new LatLng(13.022511,77.637934);
        MarkerOptions markerOptions10 = new MarkerOptions().position(bnglatLng10);
        googleMap.addMarker(markerOptions10);
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