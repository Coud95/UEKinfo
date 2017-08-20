package pl.coud.uekinfo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap googleMap;
    MapView mapView;
    View view;
    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_map, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.mapView);
        if(mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068585, 19.955923)).title("Biblioteka Główna UEK"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069200, 19.954701)).title("Pawilon A"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068835, 19.955398)).title("Pawilon B"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069205, 19.955204)).title("Pawilon C"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069348, 19.954290)).title("Pawilon D"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069069, 19.955859)).title("Pawilon E"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068399, 19.956556)).title("Pawilon F"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069521, 19.953867)).title("Pawilon G"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.067984, 19.955589)).title("Pawilon Ustronie"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068066, 19.956422)).title("Pawilon Sportowo-dydaktyczny"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068505, 19.953935)).title("Budynek Główny"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069163, 19.954131)).title("Księżówka"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069213, 19.953986)).title("Klub Grota"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069027, 19.955828)).title("zaUEK"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069299, 19.954807)).title("Pokusa"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068340, 19.956864)).title("Bułka z makiem"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068956, 19.954402)).title("Kiosk"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068087, 19.954615)).title("Kort tenisowy"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.067861, 19.956895)).title("Basen UEK"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069095, 19.953464)).title("Dom Ogrodnika"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068327, 19.952883)).title("Stróżówka"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069316, 19.953608)).title("Paczkomat InPost"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068623, 19.957292)).title("Parking podziemny UEK"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068445, 19.956759)).title("SJO UEK"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068126, 19.955666)).title("Stołówka"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068350, 19.954848)).title("Boisko"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069133, 19.955172)).title("Kawka z mleczkiem"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068054, 19.954270)).title("Parking pod Budynkiem Głównym"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.068008, 19.955988)).title("Parking pod pawilonem sportowo-dydaktycznym"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(50.069213, 19.955450)).title("Siłownia"));

        CameraPosition UEK = CameraPosition.builder().target(new LatLng(50.0685492, 19.9549886)).zoom(18).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(UEK));
    }
}
