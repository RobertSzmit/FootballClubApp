package com.example.footballclubapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.footballclubapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng ndg = new LatLng(54.2081517016708, 19.120344027121845);
        LatLng kwidzyn = new LatLng(53.72495180819785, 18.933697544806016);
        LatLng pelplin = new LatLng(53.926921811614264, 18.699394823522464);
        LatLng miloradz = new LatLng (54.01433508101419, 18.918271884598845);
        LatLng chojnice = new LatLng(53.70293516389566, 17.5674908646376);
        LatLng karsin = new LatLng(53.898292079998456, 17.923316659049913);
        LatLng lipusz = new LatLng(54.10128851959068, 17.783633736844244);
        LatLng sadlinki = new LatLng(53.668211215786485, 18.875691813841968);
        LatLng pinczyn = new LatLng(53.96149722164397, 18.346927119112934);
        LatLng prabuty = new LatLng(53.75184092883223, 19.208846002860223);
        LatLng stezyca = new LatLng(54.20648235014729, 17.955208354720263);
        LatLng starepole = new LatLng(54.05457528631961, 19.201261807880265);
        LatLng brusy = new LatLng(53.90966651715815, 17.709123140252906);
        LatLng skarszewy = new LatLng(54.065542931004615, 18.447552715860816);
        LatLng korzeniewo = new LatLng(53.753015233207435, 18.869854489560485);
        LatLng sztum = new LatLng(53.92372750927994, 19.03505903488597);
        LatLng skorzewo = new LatLng(54.18264710012946, 17.974813874731904);
        LatLng godziszewo = new LatLng(54.10001091408435, 18.554676388295494);

        mMap.addMarker(new MarkerOptions()
                .position(ndg)
                .title("LKS Żuławy"));

        mMap.addMarker(new MarkerOptions()
                .position(kwidzyn)
                .title("Supra Kwidzyn"));

        mMap.addMarker(new MarkerOptions()
                .position(pelplin)
                .title("Centrum Pelplin"));

        mMap.addMarker(new MarkerOptions()
                .position(miloradz)
                .title("Delta Miłoradz"));

        mMap.addMarker(new MarkerOptions()
                .position(chojnice)
                .title("Kolejarz Chojnice"));

        mMap.addMarker(new MarkerOptions()
                .position(karsin)
                .title("Gwiazda Karsin"));

        mMap.addMarker(new MarkerOptions()
                .position(lipusz)
                .title("Wda Lipusz"));

        mMap.addMarker(new MarkerOptions()
                .position(sadlinki)
                .title("Spójnia Sadlinki"));

        mMap.addMarker(new MarkerOptions()
                .position(pinczyn)
                .title("Meteor Pinczyn"));

        mMap.addMarker(new MarkerOptions()
                .position(prabuty)
                .title("Pogoń Prabuty"));

        mMap.addMarker(new MarkerOptions()
                .position(stezyca)
                .title("Radunia II Stężyca"));

        mMap.addMarker(new MarkerOptions()
                .position(starepole)
                .title("Błękitni Stare Pole"));

        mMap.addMarker(new MarkerOptions()
                .position(brusy)
                .title("Tęcza Brusy"));

        mMap.addMarker(new MarkerOptions()
                .position(skarszewy)
                .title("Wietcisa Skarszewy"));

        mMap.addMarker(new MarkerOptions()
                .position(korzeniewo)
                .title("Wisła Korzeniewo"));

        mMap.addMarker(new MarkerOptions()
                .position(sztum)
                .title("Olimpia Sztum"));

        mMap.addMarker(new MarkerOptions()
                .position(skorzewo)
                .title("KS Skorzewo"));

        mMap.addMarker(new MarkerOptions()
                .position(godziszewo)
                .title("Styna Godziszewo"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(ndg));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ndg,9)); // zoom
    }
}