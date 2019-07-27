package com.example.android.tour_guide;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.tour_guide.R;

import java.util.ArrayList;

public class EventsFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_local_attraction, container, false);

        final ArrayList<com.example.android.tour_guide.LocalAttraction> events = new ArrayList<>();

        final String[] eventsNames = getResources().getStringArray(R.array.list_event_names);
        final String[] eventsAddresses = getResources().getStringArray(R.array.list_event_addresses);
        final String[] eventsOpeningHours = getResources().getStringArray(R.array.list_event_opening_hours);
        final TypedArray eventsImages = getResources().obtainTypedArray(R.array.list_event_images);

        for  (int id = 0; id != eventsNames.length; ++id) {
            com.example.android.tour_guide.LocalAttraction newLocalAttraction = new com.example.android.tour_guide.LocalAttraction(eventsNames[id], eventsAddresses[id],
                    eventsOpeningHours[id], eventsImages.getDrawable(id));
            events.add(newLocalAttraction);
        }

        com.example.android.tour_guide.LocalAttractionAdapter adapter = new com.example.android.tour_guide.LocalAttractionAdapter(getActivity(), events);

        ListView listView = (ListView) rootView.findViewById(R.id.list_local_attraction);

        listView.setAdapter(adapter);

        return rootView;
    }
}

