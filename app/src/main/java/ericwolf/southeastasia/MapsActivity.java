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
            if (new Date().after(sdf.parse("2019-04-08"))) {
                createMarker(-7.751330328, 110.48833138, "Prambanan Temples", "prambanan", "https://www.lonelyplanet.com/indonesia/attractions/prambanan-temples/a/poi-sig/1189508/1002117");
            }
            if (new Date().after(sdf.parse("2019-04-15"))) {
                createMarker(-7.607355, 110.203804, "Borobudur Temple", "borobudur", "https://www.lonelyplanet.com/indonesia/attractions/borobudur-temple/a/poi-sig/1216707/1002117");
            }
            if (new Date().after(sdf.parse("2019-04-22"))) {
                createMarker(13.6111, 103.9753, "Banteay Srei", "banteay", "https://www.lonelyplanet.com/cambodia/attractions/banteay-srei/a/poi-sig/500526/1002117");
            }
            if (new Date().after(sdf.parse("2019-04-29"))) {
                createMarker(13.4709, 104.2294, "Beng Mealea", "beng", "https://www.lonelyplanet.com/cambodia/attractions/beng-mealea/a/poi-sig/500536/1002117");
            }
            if (new Date().after(sdf.parse("2019-05-06"))) {
                createMarker(14.0711, 103.099, "Banteay Chhmar", "banteay_chhmar", "https://www.lonelyplanet.com/cambodia/attractions/banteay-chhmar/a/poi-sig/499456/1002117");
            }
            if (new Date().after(sdf.parse("2019-05-13"))) {
                createMarker(13.40749837, 103.8666632, "Angkor Wat", "angkor_wat", "https://www.lonelyplanet.com/cambodia/attractions/angkor-wat/a/poi-sig/500516/1002117");
            }
            if (new Date().after(sdf.parse("2019-05-20"))) {
                createMarker(13.434762, 103.889320, "Ta Prohm", "ta_prohm", "https://www.lonelyplanet.com/cambodia/attractions/ta-prohm/a/poi-sig/500632/1002117");
            }
            if (new Date().after(sdf.parse("2019-05-27"))) {
                createMarker(14.3901752, 104.6801322, "Prasat Preah Vihear", "prasat", "https://www.lonelyplanet.com/cambodia/attractions/prasat-preah-vihear/a/poi-sig/499598/1002117");
            }
            if (new Date().after(sdf.parse("2019-06-03"))) {
                createMarker(22.013011, 96.1089697, "Mandalay Hill", "mandalay", "https://www.lonelyplanet.com/myanmar-burma/mandalay/attractions/mandalay-hill/a/poi-sig/1369293/1002117");
            }
            if (new Date().after(sdf.parse("2019-06-10"))) {
                createMarker(13.407999, 104.748491, "Preah Khan of Kompong Svay", "kompong", "https://www.lonelyplanet.com/cambodia/attractions/preah-khan-of-kompong-svay/a/poi-sig/1520402/1002117");
            }
            if (new Date().after(sdf.parse("2019-06-17"))) {
                createMarker(5.42154611, 100.33480614, "Blue Mansion", "blue_mansion", "https://www.lonelyplanet.com/malaysia/george-town/attractions/blue-mansion/a/poi-sig/1217750/1002117");
            }
            if (new Date().after(sdf.parse("2019-06-24"))) {
                createMarker(13.7465072, 100.4932985, "Wat Pho", "wat_pho", "https://www.lonelyplanet.com/thailand/bangkok/attractions/wat-pho/a/poi-sig/1148214/1002117");
            }
            if (new Date().after(sdf.parse("2019-07-01"))) {
                createMarker(-8.2128021, 115.1222586, "Banyu Wana Amertha Waterfalls", "banyu_wana", "https://www.lonelyplanet.com/indonesia/munduk/attractions/banyu-wana-amertha-waterfalls/a/poi-sig/1607288/1002117");
            }
            if (new Date().after(sdf.parse("2019-07-08"))) {
                createMarker(-2.9966445, 119.9102631, "Ke'te Kesu'", "ketekesu", "https://www.lonelyplanet.com/indonesia/attractions/kete-kesu/a/poi-sig/1286776/1002117");
            }
            if (new Date().after(sdf.parse("2019-07-15"))) {
                createMarker(-8.5396603, 118.4578029, "Mesjid Raya Baiturrahman", "mesjid", "https://www.lonelyplanet.com/indonesia/banda-aceh/attractions/mesjid-raya-baiturrahman/a/poi-sig/455173/1002117");
            }
            if (new Date().after(sdf.parse("2019-07-22"))) {
                createMarker(17.0156231, 99.66847811, "Sukhothai Historical Park", "sukhothai", "https://www.lonelyplanet.com/thailand/sukhothai/attractions/sukhothai-historical-park/a/poi-sig/1244833/1002117");
            }
            if (new Date().after(sdf.parse("2019-07-29"))) {
                createMarker(19.89738653, 102.14324802, "Wat Xieng Thong", "wat_xieng", "https://www.lonelyplanet.com/laos/luang-prabang/attractions/wat-xieng-thong/a/poi-sig/442532/1002117");
            }
            if (new Date().after(sdf.parse("2019-08-05"))) {
                createMarker(20.405278, 104.226389, "Vieng Xai Caves", "vieng", "https://www.lonelyplanet.com/laos/attractions/vieng-xai-caves/a/poi-sig/1351137/1002117");
            }
            if (new Date().after(sdf.parse("2019-08-12"))) {
                createMarker(11.5752317, 104.926121, "Artisans Angkor", "artisans", "https://www.lonelyplanet.com/cambodia/siem-reap/shopping/artisans-angkor/a/poi-sho/1380116/1002117");
            }
            if (new Date().after(sdf.parse("2019-08-19"))) {
                createMarker(21.8484, 95.9682, "Bagaya Kyaung", "bagaya", "https://www.lonelyplanet.com/myanmar-burma/attractions/bagaya-kyaung/a/poi-sig/1369344/1002117");
            }
            if (new Date().after(sdf.parse("2019-08-26"))) {
                createMarker(18.7714652475, 100.769618588, "Wat Phumin", "wat_phumin", "https://www.lonelyplanet.com/thailand/nan/attractions/wat-phumin/a/poi-sig/1243793/1002117");
            }
            if (new Date().after(sdf.parse("2019-09-02"))) {
                createMarker(13.0990581, 103.2036114, "Romcheik 5 Artspace", "romcheik", "https://www.lonelyplanet.com/cambodia/battambang/attractions/romcheik-5-artspace/a/poi-sig/1552876/1002117");
            }
            if (new Date().after(sdf.parse("2019-09-09"))) {
                createMarker(21.9662842, 96.0659157, "Shwe In Bin Kyaung", "shwe", "https://www.lonelyplanet.com/myanmar-burma/mandalay/attractions/shwe-in-bin-kyaung/a/poi-sig/1368726/1002117");
            }
            if (new Date().after(sdf.parse("2019-09-16"))) {
                createMarker(20.2660839, 100.4039433, "Khao Soi Pa Orn", "khao_soi", "https://www.lonelyplanet.com/thailand/chiang-khong/restaurants/khao-soi-pa-orn/a/poi-eat/1243771/1002117");
            }
            if (new Date().after(sdf.parse("2019-09-23"))) {
                createMarker(13.3496452, 103.8601685, "Cuisine Wat Damnak", "cuisine", "https://www.lonelyplanet.com/cambodia/siem-reap/restaurants/cuisine-wat-damnak/a/poi-eat/1379517/1002117");
            }
            if (new Date().after(sdf.parse("2019-09-30"))) {
                createMarker(13.8002931, 100.55113866, "Chatuchak Weekend Market", "chatuchak", "https://www.lonelyplanet.com/thailand/bangkok/attractions/chatuchak-weekend-market/a/poi-sig/407334/1002117");
            }
            if (new Date().after(sdf.parse("2019-10-07"))) {
                createMarker(14.8422882975, 105.817223398, "Wat Phu Champasak", "wat_phu", "https://www.lonelyplanet.com/laos/attractions/wat-phu-champasak/a/poi-sig/1341560/1002117");
            }
            if (new Date().after(sdf.parse("2019-10-14"))) {
                createMarker(14.3473251, 99.07122883, "Erawan National Park", "erawan", "https://www.lonelyplanet.com/thailand/attractions/erawan-national-park/a/poi-sig/1174717/1002117");
            }
            if (new Date().after(sdf.parse("2019-10-21"))) {
                createMarker(20.597986, 93.193066, "Shittaung Paya", "shittaung", "https://www.lonelyplanet.com/myanmar-burma/mrauk-u/attractions/shittaung-paya/a/poi-sig/1369925/1002117");
            }
            if (new Date().after(sdf.parse("2019-10-28"))) {
                createMarker(11.300556, 104.801111, "Phnom Tamao Wildlife Rescue Centre", "phnom_tamao", "https://www.lonelyplanet.com/cambodia/attractions/phnom-tamao-wildlife-rescue-centre/a/poi-sig/1380394/1002117");
            }
            if (new Date().after(sdf.parse("2019-11-04"))) {
                createMarker(21.1620599, 94.87291704, "Dhammayangyi Pahto", "dhammayangyi", "https://www.lonelyplanet.com/myanmar-burma/attractions/dhammayangyi-pahto/a/poi-sig/1368653/1002117");
            }
            if (new Date().after(sdf.parse("2019-11-11"))) {
                createMarker(17.5552645, 106.1123041, "Phong Nha-Ke Bang National Park", "phong_nha", "https://www.lonelyplanet.com/vietnam/attractions/phong-nha-ke-bang-national-park/a/poi-sig/1388512/1002117");
            }
            if (new Date().after(sdf.parse("2019-11-18"))) {
                createMarker(18.1375, 103.879167, "Wat Phu Thok", "wat_phu_tok", "https://www.lonelyplanet.com/thailand/attractions/wat-phu-thok/a/poi-sig/1175197/1002117");
            }
            if (new Date().after(sdf.parse("2019-11-25"))) {
                createMarker(21.9518553, 96.0785073, "Mahamuni Paya", "mahamuni", "https://www.lonelyplanet.com/myanmar-burma/mandalay/attractions/mahamuni-paya/a/poi-sig/1368759/1002117");
            }
            if (new Date().after(sdf.parse("2019-12-02"))) {
                createMarker(17.793611, 104.783889, "Phu Hin Bun NPA", "phu_hin", "https://www.lonelyplanet.com/laos/tha-khaek/attractions/phu-hin-bun-npa/a/poi-sig/1548234/1002117");
            }
            if (new Date().after(sdf.parse("2019-12-09"))) {
                createMarker(13.73, 107.015, "Boeng Yeak Lom", "boeng", "https://www.lonelyplanet.com/cambodia/ban-lung/attractions/boeng-yeak-lom/a/poi-sig/1380421/1002117");
            }
            if (new Date().after(sdf.parse("2019-12-16"))) {
                createMarker(12.936181, 107.305066, "Seima Protected Forest", "seima", "https://www.lonelyplanet.com/cambodia/sen-monorom/attractions/seima-protected-forest/a/poi-sig/1567163/1002117");
            }
            if (new Date().after(sdf.parse("2019-12-23"))) {
                createMarker(19.89024885, 102.1370253, "Phu Si", "phu_si", "https://www.lonelyplanet.com/laos/luang-prabang/attractions/phu-si/a/poi-sig/442488/1002117");
            }
            if (new Date().after(sdf.parse("2019-12-30"))) {
                createMarker(16.7400595, 97.7184502, "Saddan Cave", "saddan", "https://www.lonelyplanet.com/myanmar-burma/hpa-an/attractions/saddan-cave/a/poi-sig/1371917/1002117");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Map.Entry<Marker,String>> entryList = new ArrayList<>(markerUrl.entrySet());
        Map.Entry<Marker,String> lastEntry = entryList.get(entryList.size()-1);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(lastEntry.getKey().getPosition()));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lastEntry.getKey().getPosition(), 6));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(final Marker marker) {

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 16), 4000, null);

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
