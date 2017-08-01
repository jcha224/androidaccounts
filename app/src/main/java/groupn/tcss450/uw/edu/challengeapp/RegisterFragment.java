package groupn.tcss450.uw.edu.challengeapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegisterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener{

    private static final String PARTIAL_URL
            = "http://cssgate.insttech.washington.edu/" +
            "~jcha224/lab4";
    private OnFragmentInteractionListener mListener;
    private EditText u;
    private EditText p;
    private EditText p2;
    private boolean unused;


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        Button b = (Button) v.findViewById(R.id.button4);
        b.setOnClickListener(this);
        u = (EditText) v.findViewById(R.id.username3);
        p = (EditText) v.findViewById(R.id.password3);
        p2 = (EditText) v.findViewById(R.id.password4);
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
    public void onClick(View v) {

        AsyncTask<String, Void, String> task = new CreateWebServiceTask();
        if(mListener != null) {
            if(u.getText().length() == 0) {
                u.setError("Cannot be left empty");
            }
            if(p.getText().length() == 0) {
                p.setError("Cannot be left empty");
            }
            if(p2.getText().length() == 0) {
                p2.setError("Cannot be left empty");
            }
            if(u.getText().length() > 0 &&
                    p.getText().length() > 0 &&
                    p2.getText().length() > 0) {
                if(p.getText().toString().equals(p2.getText().toString())) {
                    task.execute(PARTIAL_URL, u.getText().toString(), p.getText().toString());

                }else {
                    p.setError("Passwords do not match");
                    p2.setError("Passwords do not match");
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
        void onFragment3Interaction(CharSequence u, CharSequence p);
    }

    private class CreateWebServiceTask extends AsyncTask<String, Void, String> {
        private final String SERVICE = "_create.php";
        @Override
        protected String doInBackground(String... strings) {
            if (strings.length != 3) {
                throw new IllegalArgumentException("Two String arguments required.");
            }
            String response = "";
            HttpURLConnection urlConnection = null;
            String url = strings[0];
            String args = "?my_usr=" + strings[1];
            String args2 = "&my_pw=" + strings[2];
            try {
                URL urlObject = new URL(url + SERVICE + args + args2);
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

            Log.d("REGG", result);
            if(!result.equals("[]")) {
                u.setError("Username is taken");
            } else {
                mListener.onFragment3Interaction(u.getText(), p.getText());
            }

        }
    }
}
