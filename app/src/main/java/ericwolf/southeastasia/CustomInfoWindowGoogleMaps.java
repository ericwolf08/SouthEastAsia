package ericwolf.southeastasia;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowGoogleMaps implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public CustomInfoWindowGoogleMaps(Context ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.custom_infowindow, null);

        view.setElevation(5);
        view.setFadingEdgeLength(20);

        TextView name_tv = view.findViewById(R.id.name);
        ImageView img = view.findViewById(R.id.pic);

        name_tv.setText(marker.getTitle());

        InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();

        int imageId = context.getResources().getIdentifier(infoWindowData.getImage().toLowerCase(),
                "drawable", context.getPackageName());
        img.setImageResource(imageId);

        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {

        return null;
    }
}
