package groupn.tcss450.uw.edu.challengeapp;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import static android.R.layout.simple_dropdown_item_1line;


/**
 * A simple {@link Fragment} subclass.
 */
public class GetSetlistFragment extends Fragment implements View.OnClickListener {

    private static final String PARTIAL_URL
            = "http://cssgate.insttech.washington.edu" +
            "/~cfb3/TCSS450A-W17/phish/setlist/";
    private OnFragmentInteractionListener mListener;
    private int check = 1;
    private Button[] mBut;
    private String[] mId;
    private int mNum;
    private ViewFlipper vf;
    private static final String[] ID = new String[] {
            Integer.toString(1479253444), Integer.toString(1252691618),
            Integer.toString(1252633496), Integer.toString(1252343167),
            Integer.toString(1250887835), Integer.toString(1252877083),
            Integer.toString(1252956590), Integer.toString(1252989413),
            Integer.toString(1479253406), Integer.toString(1475149035)
    };
    private AutoCompleteTextView mTextView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_getsetlist, container, false);
        Button bb = (Button) v.findViewById(R.id.searchButton);
        bb.setOnClickListener(this);
        Button b = (Button) v.findViewById(R.id.randomButton);
        b.setOnClickListener(this);
        Button b1 = (Button) v.findViewById(R.id.toptenButton);
        b1.setOnClickListener(this);
        Button but1 = (Button) v.findViewById(R.id.button01);
        but1.setOnClickListener(this);
        Button but2 = (Button) v.findViewById(R.id.button02);
        but2.setOnClickListener(this);
        Button but3 = (Button) v.findViewById(R.id.button03);
        but3.setOnClickListener(this);
        Button but4 = (Button) v.findViewById(R.id.button04);
        but4.setOnClickListener(this);
        Button but5 = (Button) v.findViewById(R.id.button05);
        but5.setOnClickListener(this);
        Button but6 = (Button) v.findViewById(R.id.button06);
        but6.setOnClickListener(this);
        Button but7 = (Button) v.findViewById(R.id.button07);
        but7.setOnClickListener(this);
        Button but8 = (Button) v.findViewById(R.id.button08);
        but8.setOnClickListener(this);
        Button but9 = (Button) v.findViewById(R.id.button09);
        but9.setOnClickListener(this);
        Button but10 = (Button) v.findViewById(R.id.button10);
        but10.setOnClickListener(this);
        mBut = new Button[10];
        mId = new String[10];
        mBut[0] = but1;
        mBut[1] = but2;
        mBut[2] = but3;
        mBut[3] = but4;
        mBut[4] = but5;
        mBut[5] = but6;
        mBut[6] = but7;
        mBut[7] = but8;
        mBut[8] = but9;
        mBut[9] = but10;
        vf = (ViewFlipper) v.findViewById( R.id.viewFlipper );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(),
                simple_dropdown_item_1line, ID);
        mTextView = (AutoCompleteTextView)
                v.findViewById(R.id.autoCompleteTextView);
        mTextView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
    public void onStart() {
        super.onStart();
        if(getArguments() != null) {
            CharSequence u = getArguments().getCharSequence("uKey");
            updateContent(u);
        }
    }

    public void updateContent(CharSequence u) {
        TextView tv = (TextView) getActivity().findViewById(R.id.userText);

        tv.setText(u);
    }
// <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDGErSTMC1iAlNiMbfRDaOP3S7GrZ1OYFs&callback=initMap"type="text/javascript"></script>
    @Override
    public void onClick(View view) {
        AsyncTask<String, Void, String> task = new Create2WebServiceTask();
        if(mListener != null) {
            if(check != 1) {
                vf.showNext();
            }
            switch (view.getId()) {
                case R.id.randomButton:
                    check = 1;
                    task.execute(PARTIAL_URL, "random.php");
                    break;
                case R.id.toptenButton:
                    check = 2;
                    task.execute(PARTIAL_URL, "recent.php");
                    break;
                case R.id.button01:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[0]);
                    break;
                case R.id.button02:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[1]);
                    break;
                case R.id.button03:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[2]);
                    break;
                case R.id.button04:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[3]);
                    break;
                case R.id.button05:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[4]);
                    break;
                case R.id.button06:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[5]);
                    break;
                case R.id.button07:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[6]);
                    break;
                case R.id.button08:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[7]);
                    break;
                case R.id.button09:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[8]);
                    break;
                case R.id.button10:
                    check = 1;
                    task.execute(PARTIAL_URL, "getShow.php?show_id=" + mId[9]);
                    break;
                case R.id.searchButton:
                    check = 1;
                    if(!mTextView.getText().toString().equals("Search")) {
                        task.execute(PARTIAL_URL, "getShow.php?show_id=" +
                                mTextView.getText().toString());
                    }
            }
        }
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

    private class Create2WebServiceTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            if (strings.length != 2) {
                throw new IllegalArgumentException("Two String arguments required.");
            }
            String response = "";
            HttpURLConnection urlConnection = null;
            String url = strings[0];
            String args = strings[1];
            try {
                URL urlObject = new URL(url + args);
                urlConnection = (HttpURLConnection) urlObject.openConnection();
                InputStream content = urlConnection.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
                String s = "";
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


            JSONObject ob = null;
            JSONArray ar = null;
            try {
                ob = new JSONObject(result);
                ob = ob.getJSONObject("response");
                ar = ob.getJSONArray("data");

                ob = ar.getJSONObject(0);
                Log.e("CHEcK THIS STRING", ob.getString("short_date"));
            } catch (JSONException e) {
                e.printStackTrace();
            }




            if(check == 1) {

                 mListener.onFragment4Interaction(ob);
            } else {

                for(int i=0; i<10; i++) {
                    try {
                        ob = ar.getJSONObject(i);
                        mBut[i].setText(ob.getString("short_date"));
                        mId[i] = Integer.toString(ob.getInt("showid"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                vf.showNext();

            }

        }
    }

}
