package tutorial.maps.google.googlemapsapplication;

/**
 * Created by prane on 2/8/2016.
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class Maps1Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Bitmap bmp;
    Bitmap bmp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps1_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        bmp1 = Bitmap.createScaledBitmap(bmp, 144, 144, false);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in UMKC and move the camera
        LatLng umkc = new LatLng(39.0335, -94.5756);
        mMap.addMarker(new MarkerOptions().position(umkc).icon(BitmapDescriptorFactory.fromBitmap(bmp1)));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(4);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(umkc));
        mMap.animateCamera(zoom);
    }
}

    //this method gets invoked when the user gives the location in the text field and hits the locate button
//    public void onLocate(View newView ) throws Exception{
//        //EditText textFieldLocation = (EditText)findViewById(R.id.editTextLocation);
//        //String location = textFieldLocation.getText().toString();
//        String newLocation = location.trim();
//        if (newLocation.equals("")){
//            Toast.makeText(Maps1Activity.this, "Please input desired location",
//                    Toast.LENGTH_SHORT).show();
//        }
//        else {
//            //getting the desired location from the user and converting it into corresponding
//            //latitude and longitude
//            Geocoder gc = new Geocoder(this);
//            List<Address> addresses = gc.getFromLocationName(location, 1);
//            Address address = addresses.get(0);
//
//            //Add a marker in the inputed location and move the camera
//            LatLng loc = new LatLng(address.getLatitude(), address.getLongitude());
//            //mMap.addMarker(new MarkerOptions().position(loc).icon(BitmapDescriptorFactory.
//            //defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).title("Marker in "+location));
//            //mMap.addMarker(new MarkerOptions().position(loc).icon(BitmapDescriptorFactory.
//            //fromResource(R.mipmap.walter)));
//            //CameraUpdate zoom=CameraUpdateFactory.zoomTo(4);
//            //mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
//            //mMap.animateCamera(zoom);
//            mMap.addMarker(new MarkerOptions().position(loc).icon(BitmapDescriptorFactory.fromBitmap(bmp1)));
//            CameraUpdate zoom=CameraUpdateFactory.zoomTo(4);
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
//            mMap.animateCamera(zoom);
//
//        }
//    }
//
//}

