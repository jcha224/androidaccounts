package groupn.tcss450.uw.edu.challengeapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.places.Places;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static groupn.tcss450.uw.edu.challengeapp.R.id.progressBar;
import static groupn.tcss450.uw.edu.challengeapp.R.id.queryButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class GooglePlaces extends Fragment implements OnConnectionFailedListener, View.OnClickListener {
    private static final String API_URL = "https://maps.googleapis.com/maps/api/place/details/json?";
    private static final String API_KEY = "AIzaSyB6uUO1NN88F35RPpaxfWTOiXsyXFpgIAg";
    private GetSetlistFragment.OnFragmentInteractionListener mListener;
    private GoogleApiClient mGoogleApiClient;
    private Button mBut;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActivity().setContentView(R.layout.activity_main);
//
//        mGoogleApiClient = new GoogleApiClient
//                .Builder(getActivity())
//                .addApi(Places.GEO_DATA_API)
//                .addApi(Places.PLACE_DETECTION_API)
//                .enableAutoManage(getActivity(), this)
//                .build();
    }
    public GooglePlaces() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GetSetlistFragment.OnFragmentInteractionListener) {
            mListener = (GetSetlistFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_google_places, container, false);
        mBut = (Button)view.findViewById(queryButton);
        mBut.setOnClickListener(this);
        return view;
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    public void updateContent(CharSequence u) {

    }
    @Override
    public void onClick(View v) {
        AsyncTask<String, Void, String> task = new RetrieveFeedTask();

                    task.execute();

    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragment4Interaction(JSONObject obj);
    }
    class RetrieveFeedTask extends AsyncTask<String, Void, String> {

        Exception exception;

        @Override
        protected String doInBackground(String... strings) {
            //if (strings.length != 1) {
            //    throw new IllegalArgumentException("Two String arguments required.");
            //}

            String response = "";
            HttpURLConnection urlConnection = null;
            String arg = "ChIJN1t_tDeuEmsRUsoyG83frY4";
            try {
                URL urlObject = new URL(API_URL + "placeid=" + arg + "&key=" + API_KEY);
                urlConnection = (HttpURLConnection) urlObject.openConnection();
                InputStream content = urlConnection.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
                String s = "";
                Log.e("LOG CHEC THIS SHIT OUT", "try");
                while ((s = buffer.readLine()) != null) {
                    response += s;
                }
            } catch (Exception e) {
                response = "Unable to connect, Reason: "
                        + e.getMessage();
            } finally {
                if (urlConnection != null)
                    urlConnection.disconnect();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            // Something wrong with the network or the URL.
            if (result.startsWith("Unable to")) {
                Toast.makeText(getActivity().getApplicationContext(), result, Toast.LENGTH_LONG)
                        .show();
                return;
            }
            Log.e("LOG CHEC THIS SHIT OUT", "onpostexecute");

            JSONObject ob = null;
            JSONArray ar = null;
            try {
                ob = new JSONObject(result);
                ob = ob.getJSONObject("result");

                //ar = ob.getJSONArray("address_components");

                //ob = ar.getJSONObject(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

}
