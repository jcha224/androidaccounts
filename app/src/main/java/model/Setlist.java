package model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by John on 4/23/2017.
 */

public final class Setlist implements Serializable {
    /** error messages */
    //"error_code":0,"error_message":null,"response":{"count":1,"data":[{
    /** "showid":1363195961 */
    private static int mShowId = 0;

    /** "showdate":"2013-08-03", */
    private static String mShowDate = "";

    /**"short_date":"08\/03\/2013", */
    private static String mShortDate = "";

    /** "long_date":"Saturday 08\/03\/2013", */
    private static String mLongDate = "";

    /** "relative_date":"4 years ago", */
    private static String mRelativeDate = "";

    /**"url":"http:\/\/phish.net\/setlists\/phish-august-03-2013-bill-graham-civic-auditorium-san-francisco-ca-usa.html", */
    private static String mURL = "";

    /** "gapchart":"http:\/\/phish.net\/setlists\/gap-chart\/phish-august-03-2013-bill-graham-civic-auditorium-san-francisco-ca-usa.html", */
    private static String mGapChart = "";

    /** "artist":"Phish<\/a>", */
    private static String mArtist = "";

    /** "artistid":1, */
    private static int mArtistId = 0;

    /** "venueid":816, */
    private static int mVenueId = 0;

    /** "venue":"Bill Graham Civic Auditorium<\/a>", */
    private static String mVenue = "";

    /** "location":"San Francisco, CA, USA", */
    private static String mLocation = "";

    /** "setlistdata":"
     *  Set 1<\/span>: Grind<\/a>, Weigh<\/a> > Alumni Blues<\/a> > Letter to Jimmy Page<\/a> >
     * Alumni Blues<\/a>, Lengthwise<\/a> -> Maze<\/a>, Sample in a Jar<\/a> > NICU<\/a>, Mound<\/a>,
     * Jesus Just Left Chicago<\/a>, Driver<\/a>, Timber (Jerry)<\/a> > Axilla<\/a>,
     * Bug<\/a> > Possum<\/a>, First Tube<\/a><\/p>
     * Encore 2<\/span>: to "Steam."\" href='http:\/\/phish.net\/song\/rock-and-roll'
     * class='setlist-song' title='Bad Ass Mike kicks off this dynamic,
     * multi-section jam with some really sick bass work. From there, it ranges far
     * and wide before settling into quieter, but active playing which then > to
     * "Steam."'>Rock and Roll<\/a> > Steam<\/a> > Backwards Down the Number Line<\/a> >
     * Mike's Song<\/a> > I Am Hydrogen<\/a> > Weekapaug Groove<\/a>, Joy<\/a> > Fluffhead<\/a> >
     * Also Sprach Zarathustra<\/a> > Slave to the Traffic Light<\/a><\/p>
     * Encore<\/span>:Waste<\/a> > Suzy Greenberg<\/a>",
     */
    private static String mSetListData = "";

    /** "setlistnotes":"This show was webcast via LivePhish<\/a>.
     * Trey teased Apostrophe in Mike's Song and Waste and Also Sprach
     * Zarathustra in Suzy. Mike teased Nellie Kane in Weekapaug. via phish.net<\/a>",
     */
    private static String mSetListNotes = "";

    /** "rating":"3.8529"}]}} */
    private static String mRating = "";


    public static Setlist getSetListData(JSONObject object) throws JSONException {
        Setlist current = null;

            current.mShowId = object.getInt("showid");

            /** "showdate":"2013-08-03", */
            current.mShowDate = object.getString("showdate");

            /**"short_date":"08\/03\/2013", */
            current.mShortDate = object.getString("short_date");

            /** "long_date":"Saturday 08\/03\/2013", */
            current.mLongDate = object.getString("long_date");

            /** "relative_date":"4 years ago", */
            current.mRelativeDate = object.getString("relative_date");

            /**"url":"http:\/\/phish.net\/setlists\/phish-august-03-2013-bill-graham-civic-auditorium-san-francisco-ca-usa.html", */
            current.mURL = object.getString("url");;

            /** "gapchart":"http:\/\/phish.net\/setlists\/gap-chart\/phish-august-03-2013-bill-graham-civic-auditorium-san-francisco-ca-usa.html", */
            current.mGapChart = object.getString("gapchart");

            /** "artist":"Phish<\/a>", */
            current.mArtist = filter(object.getString("artist"));

            /** "artistid":1, */
            current.mArtistId = object.getInt("artistid");

        Log.e("AFTERRR", filter(object.getString("artist")));
            /** "venueid":816, */
            current.mVenueId = object.getInt("venueid");

            /** "venue":"Bill Graham Civic Auditorium<\/a>", */
            current.mVenue = filter(object.getString("venue"));

            /** "location":"San Francisco, CA, USA", */
            current.mLocation = object.getString("location");

            /** "setlistdata":"
             *  Set 1<\/span>: Grind<\/a>, Weigh<\/a> > Alumni Blues<\/a> > Letter to Jimmy Page<\/a> >
             * Alumni Blues<\/a>, Lengthwise<\/a> -> Maze<\/a>, Sample in a Jar<\/a> > NICU<\/a>, Mound<\/a>,
             * Jesus Just Left Chicago<\/a>, Driver<\/a>, Timber (Jerry)<\/a> > Axilla<\/a>,
             * Bug<\/a> > Possum<\/a>, First Tube<\/a><\/p>
             */
            current.mSetListData = filter(object.getString("setlistdata"));

            /** Encore 2<\/span>: to "Steam."\" href='http:\/\/phish.net\/song\/rock-and-roll'
             * class='setlist-song' title='Bad Ass Mike kicks off this dynamic,
             * multi-section jam with some really sick bass work. From there, it ranges far
             * and wide before settling into quieter, but active playing which then > to
             * "Steam."'>Rock and Roll<\/a> > Steam<\/a> > Backwards Down the Number Line<\/a> >
             * Mike's Song<\/a> > I Am Hydrogen<\/a> > Weekapaug Groove<\/a>, Joy<\/a> > Fluffhead<\/a> >
             * Also Sprach Zarathustra<\/a> > Slave to the Traffic Light<\/a><\/p>
             */


            /** Encore<\/span>:Waste<\/a> > Suzy Greenberg<\/a>", */


            /** "setlistnotes":"This show was webcast via LivePhish<\/a>.
             * Trey teased Apostrophe in Mike's Song and Waste and Also Sprach
             * Zarathustra in Suzy. Mike teased Nellie Kane in Weekapaug. via phish.net<\/a>",
             */
            current.mSetListNotes = filter(object.getString("setlistnotes"));

            /** "rating":"3.8529"}]}} */
            current.mRating = object.getString("rating");

        return current;
    }

    public static String getArtist() {
        return mArtist;
    }
    public static String getDate() {
        return mLongDate;
    }
    public static String getUrl() {
        return mURL;
    }
    public static String getGap() {
        return mGapChart;
    }
    public static String getVenue() {
        return mVenue;
    }
    public static String getLocation() {
        return mLocation;
    }
    public static String getRating() {
        return mRating;
    }
    public static String getSetList() {
        return mSetListData;
    }
    public static String getNotes() {
        return mSetListNotes;
    }


    public static String filter(String str) {
        String res = "";
        boolean fil = false;
        int in = 0;
        for(int i=0; i<str.length();i++) {
            if(str.charAt(i) == '<') {
                fil = true;
                res = res + str.substring(in, i);
                while(fil && i<str.length()){
                    if(str.charAt(i) =='>') {
                        in=i+1;
                        fil = false;
                    }
                    i++;
                }
                i--;
            }


        }
        return res;
    }

}
