package groupn.tcss450.uw.edu.challengeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetListFragment extends Fragment{


    public SetListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onStart() {
        super.onStart();
        if (getArguments() != null) {
            CharSequence date = getArguments().getCharSequence("sDate");
            CharSequence url = getArguments().getCharSequence("sUrl");
            CharSequence gap = getArguments().getCharSequence("sGapchart");
            CharSequence artist = getArguments().getCharSequence("sArtist");
            CharSequence venue = getArguments().getCharSequence("sVenue");
            CharSequence location = getArguments().getCharSequence("sLocation");
            CharSequence set = getArguments().getCharSequence("sSetlistdata");
            CharSequence notes = getArguments().getCharSequence("sNotes");
            CharSequence rating = getArguments().getCharSequence("sRating");
            updateContent(date, url, gap, artist,
                          venue, location, set, notes, rating);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setlist, container, false);
        return v;
    }


    public void updateContent(CharSequence date, CharSequence url, CharSequence gap,
                              CharSequence artist, CharSequence venue, CharSequence location,
                              CharSequence set, CharSequence notes, CharSequence rating) {
        TextView tv = (TextView) getActivity().findViewById(R.id.dateText);
        TextView tv1 = (TextView) getActivity().findViewById(R.id.urlText);
        TextView tv2 = (TextView) getActivity().findViewById(R.id.gapchartText);
        TextView tv3 = (TextView) getActivity().findViewById(R.id.artistText);
        TextView tv4 = (TextView) getActivity().findViewById(R.id.venueText);
        TextView tv5 = (TextView) getActivity().findViewById(R.id.locationText);
        TextView tv6 = (TextView) getActivity().findViewById(R.id.setlistText);
        TextView tv7 = (TextView) getActivity().findViewById(R.id.notesText);
        TextView tv8 = (TextView) getActivity().findViewById(R.id.ratingText);

        tv.setText(date);
        tv1.setText(url);
        tv2.setText(gap);
        tv3.setText(artist);
        tv4.setText(venue);
        tv5.setText(location);
        tv6.setText(set);
        tv7.setText(notes);
        tv8.setText(rating);
    }
}
