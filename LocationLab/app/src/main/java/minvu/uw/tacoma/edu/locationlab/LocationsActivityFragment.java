package minvu.uw.tacoma.edu.locationlab;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LocationsActivityFragment extends Fragment {
    private TextView mLocationTextView;

    // TODO: Rename and change types of parameters

    public LocationsActivityFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_locations_activity, container, false);
        mLocationTextView = (TextView) v.findViewById(R.id.location_text);
        updateView();
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        updateView();
    }

    public void updateView() {
        Location location = ((MainActivity) getActivity()).getCurrentLocation();
        if (location != null)
            mLocationTextView.setText(location.toString());
    }

}
