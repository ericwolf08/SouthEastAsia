package ericwolf.southeastasia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    private Marker myMarker;
    private Map<Marker,String> markerUrl = new LinkedHashMap<>();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void createMarker(double lat, double lng, String title, String image, String url) {
        LatLng latlng = new LatLng(lat, lng);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latlng);
        markerOptions.title(title);

        InfoWindowData info = new InfoWindowData();
        info.setImage(image);

        myMarker = mMap.addMarker(markerOptions);
        myMarker.setTag(info);
        markerUrl.put(myMarker, url);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        CustomInfoWindowGoogleMaps customInfoWindow = new CustomInfoWindowGoogleMaps(this);
        mMap.setInfoWindowAdapter(customInfoWindow);

        createMarker(16.798307, 96.149612, "Shwedagon Paya", "shwedagon_paya", "https://www.lonelyplanet.com/myanmar-burma/yangon/attractions/shwedagon-paya/a/poi-sig/1092872/1002117");

        try {
            if (new Date().after(sdf.parse("2019-04-01"))) {
                createMarker(13.441257, 103.858759, "Bayon", "bayon", "https://www.lonelyplanet.com/cambodia/attractions/bayon/a/poi-sig/500534/1002117");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Map.Entry<Marker,String>> entryList = new ArrayList<>(markerUrl.entrySet());
        Map.Entry<Marker,String> lastEntry = entryList.get(entryList.size()-1);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(lastEntry.getKey().getPosition()));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(final Marker marker) {

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 17), 4000, null);

                    }
                }, 300);


                if (!marker.isInfoWindowShown()) {
                    marker.showInfoWindow();
                } else {
                    marker.hideInfoWindow();
                }

                mMap.getUiSettings().setMapToolbarEnabled(true);
                mMap.getUiSettings().setAllGesturesEnabled(true);

                return false;
            }
        });



        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker marker) {

                Uri uriUrl = Uri.parse(markerUrl.get(marker));
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);

            }

        });

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
