package id.sch.smktelkom_mlg.learn.androidmaps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class CMFragment extends Fragment implements OnMapReadyCallback {
    static final CameraPosition JKT = CameraPosition.builder()
            .target(new LatLng(-6.239339, 106.808951))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition SGN = CameraPosition.builder()
            .target(new LatLng(1.299314, 103.849001))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition BKK = CameraPosition.builder()
            .target(new LatLng(13.755043, 100.533748))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    MarkerOptions one;
    MarkerOptions two;
    MarkerOptions three;
    MarkerOptions four;
    MarkerOptions five;
    MarkerOptions six;
    MarkerOptions seven;
    MarkerOptions eight;
    MarkerOptions nine;
    GoogleMap m_map;
    Boolean mapReady = false;
    Button bJkt, bSgn, bBbk;

    public CMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cm, container, false);

        bJkt = view.findViewById(R.id.btnJkt);
        bSgn = view.findViewById(R.id.btnSgn);
        bBbk = view.findViewById(R.id.btnBkk);

        one = new MarkerOptions()
                .position(new LatLng(-6.239339, 106.808951))
                .title("Tobak Korean Restaurant")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sign));

        two = new MarkerOptions()
                .position(new LatLng(-6.231109, 106.809407))
                .title("Cheongdam Garden")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sign));

        three = new MarkerOptions()
                .position(new LatLng(-6.238895, 106.808631))
                .title("Jjang Korean Noodle & Grill")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sign));

        four = new MarkerOptions()
                .position(new LatLng(1.299314, 103.849001))
                .title("I'm Kim Korean BBQ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sign));

        five = new MarkerOptions()
                .position(new LatLng(1.289273, 103.846355))
                .title("EIGHT Korean BBQ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sign));

        six = new MarkerOptions()
                .position(new LatLng(1.300618, 103.842224))
                .title("Kim Dae Mun Korean Food")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sign));

        seven = new MarkerOptions()
                .position(new LatLng(13.755043, 100.533748))
                .title("Salang Korean BBQ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sign));

        eight = new MarkerOptions()
                .position(new LatLng(13.763580, 100.541713))
                .title("Supia Korean Restaurant")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sign));

        nine = new MarkerOptions()
                .position(new LatLng(13.730115, 100.563852))
                .title("Banjoo BBQ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.sign));

        bJkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    flyTo(JKT);
            }
        });

        bSgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    flyTo(SGN);
            }
        });

        bBbk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady)
                    flyTo(BKK);
            }
        });

        MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.mapsCM);
        mapFragment.getMapAsync(this);
        return view;
    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Map is Ready!", Toast.LENGTH_SHORT);
        toast.show();
        mapReady = true;
        m_map = googleMap;
        m_map.addMarker(one);
        m_map.addMarker(two);
        m_map.addMarker(three);
        m_map.addMarker(four);
        m_map.addMarker(five);
        m_map.addMarker(six);
        m_map.addMarker(seven);
        m_map.addMarker(eight);
        m_map.addMarker(nine);
        flyTo(JKT);
    }
}
