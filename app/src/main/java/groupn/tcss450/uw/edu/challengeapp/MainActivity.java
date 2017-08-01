package groupn.tcss450.uw.edu.challengeapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import model.Setlist;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,
                    LoginFragment.OnFragmentInteractionListener, RegisterFragment.OnFragmentInteractionListener,
                    GetSetlistFragment.OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            if (findViewById(R.id.fragmentContainer) != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragmentContainer, new HomeFragment())
                        .commit();
            }
        }
    }

    @Override
    public void onFragment1Interaction(int button) {

        LoginFragment frag2;
        RegisterFragment frag3;
        FragmentTransaction transaction;

        if(button == R.id.button1) {
             frag2 = new LoginFragment();
             transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, frag2)
                    .addToBackStack(null);
        }else {
            frag3 = new RegisterFragment();
            transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, frag3)
                    .addToBackStack(null);
        }

        transaction.commit();
    }

    @Override
    public void onFragment2Interaction(CharSequence u, CharSequence p) {

        GooglePlaces frag4 = new GooglePlaces();
        Bundle args = new Bundle();
        args.putCharSequence("uKey", u);
        frag4.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, frag4)
                .addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragment3Interaction(CharSequence u, CharSequence p) {
        GooglePlaces frag4 = new GooglePlaces();
        Bundle args = new Bundle();
        args.putCharSequence("uKey", u);
        frag4.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, frag4)
                .addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onFragment4Interaction(JSONObject obj) {
        SetListFragment frag4 = new SetListFragment();
        Bundle args = new Bundle();
        Setlist s = null;
        try {
            Log.e("IT MADE IT!!!!!", "ALMOST");
            s = Setlist.getSetListData(obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        args.putCharSequence("sDate", Setlist.getDate());
        args.putCharSequence("sUrl", Setlist.getUrl());
        args.putCharSequence("sGapchart", Setlist.getGap());
        args.putCharSequence("sArtist", Setlist.getArtist());
        args.putCharSequence("sVenue", Setlist.getVenue());
        args.putCharSequence("sLocation", Setlist.getLocation());
        args.putCharSequence("sSetlistdata", Setlist.getSetList());
        args.putCharSequence("sNotes", Setlist.getNotes());
        args.putCharSequence("sRating", Setlist.getRating());
        frag4.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, frag4)
                .addToBackStack(null);
        transaction.commit();
    }



}
