package com.example.heszrave.touristguide;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class DisplayArtFragment extends DialogFragment {


    static String artName;
    static String TAG = MainActivity.class.getSimpleName();
    private static TextView artTitle;
    private static TextView artDescrption;
    private static ImageView artImage;
    public ImageButton playButton;
    public ImageButton pauseButton;
    public ImageButton stopButton;
    public Button backButton;
    static SharedPreferences sharedPreferences;
    static Context context = null;
    public MediaPlayer mediaPlayer;
    public static String language = "";

    private Button button;


    public static DialogFragment newInstance(String beacon, Context contexts) {

        context=contexts;

        Log.d(TAG, "Dialog fragment new instance");

        DisplayArtFragment displayArtFragment = new DisplayArtFragment();
        Bundle bundle = new Bundle();
        bundle.putString("beacon", beacon);
        displayArtFragment.setArguments(bundle);
        extractBeacon(beacon);
        return displayArtFragment;
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context=getActivity();

        View v = inflater.inflate(R.layout.activity_display_art_fragment, container, false);

        artTitle = (TextView) v.findViewById(R.id.artTitle);
        artImage = (ImageView) v.findViewById(R.id.artImage);
        artDescrption = (TextView) v.findViewById(R.id.artDescription);

        playButton = (ImageButton) v.findViewById(R.id.icon_play_btn);
        pauseButton = (ImageButton) v.findViewById(R.id.icon_pause_btn);
        stopButton = (ImageButton) v.findViewById(R.id.icon_stop_btn);
        backButton = v.findViewById(R.id.backButton);

     //   backButton = (Button) v.findViewById(R.id.backButton);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        });



        String audio_fileName = "";

        audio_fileName = artName + "_" + language + ".mp3";

        final String finalAudioLink = Config.audioDownload + "/" + audio_fileName;
        Log.d(TAG, "Audio LINK is :" + finalAudioLink);


        try {
           mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(finalAudioLink);
            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mediaPlayer = new MediaPlayer();
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource(finalAudioLink);
//                  mediaPlayer.prepare();
////                mediaPlayer.start();
                    mediaPlayer.prepare();
                    mediaPlayer.start();
//
                } catch (IOException e) {
                    e.printStackTrace();
                }

//                mediaPlayer.prepare();
                mediaPlayer.start();


                pauseButton.setVisibility(View.VISIBLE);
                stopButton.setVisibility(View.VISIBLE);
                playButton.setVisibility(View.GONE);

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    pauseButton.setVisibility(View.GONE);
                    stopButton.setVisibility(View.VISIBLE);
                    playButton.setVisibility(View.VISIBLE);
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
//                    mediaPlayer.release();
                    mediaPlayer.prepareAsync();
                    mediaPlayer.seekTo(0);
                    pauseButton.setVisibility(View.GONE);
                    stopButton.setVisibility(View.GONE);
                    playButton.setVisibility(View.VISIBLE);
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mediaPlayer.prepareAsync();
                mediaPlayer.seekTo(0);
                pauseButton.setVisibility(View.GONE);
                stopButton.setVisibility(View.GONE);
                playButton.setVisibility(View.VISIBLE);
            }
        });

        return v;





    }




    public static void extractBeacon(String beaconID) {
        Log.d(TAG, "extract beacon");
        Log.d(TAG, "Beacon isntance is : " + beaconID);
        if (beaconID.equals(Config.BeaconInstaceA)) {
            artName = "black_and_white_ruffed_lemur";
        }
        else if (beaconID.equals(Config.BeaconInstaceB)) {
            artName = "elephant";
        }

        retrieveArt(artName);
    }

    public static void retrieveArt(final String artName) {
        Log.d(TAG, "entered retrive art");
        Log.d(TAG, "Retrieve art received parameter: " + artName);


        class RetrieveArt extends AsyncTask<String, Void, String> {

            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
            String artLanguage = sharedPref.getString("SelectedLanguageKey", "english");


          //  String artLanguage1 = sharedPref.getString("SelectedLanguageKey", "malay");



         //  private ProgressDialog progressDialog;
            @Override
            protected void onPreExecute() {

          //  progressDialog.setMessage("Retrieving...");

                super.onPreExecute();
            }

            @Override
            protected String doInBackground(String... params) {


                if (artLanguage.equals("korean")) {
                    Log.d(TAG, "Art language is KOREAN");
                    language = "ko-KR";
                } else if (artLanguage.equals("english")) {
                    Log.d(TAG, "Art language is ENGLISH");
                    language = "en-GB";
                }else if (artLanguage.equals("chinese")) {
                    Log.d(TAG, "Art language is CHINESE");
                    language = "zh-TW";
                }else if (artLanguage.equals("japanese")) {
                    Log.d(TAG, "Art language is JAPANESE");
                    language = "ja-JP";
                } else if (artLanguage.equals("spanish")) {
                    Log.d(TAG, "Art language is SPANISH");
                    language = "es-ES";
                }else if (artLanguage.equals("malay")) {
                    Log.d(TAG, "Art language is MALAY");
                    language = "ms-MY";
                }

                try {
                    Log.d(TAG, "Inside Try");
                    Log.d(TAG, "Art language is : " + language);
                    Log.d(TAG, "Art name is : " + artName);
                    URL url = new URL(Config.RetieveArt);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);

                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                    String post_data = URLEncoder.encode("artName", "UTF-8") + "=" + URLEncoder.encode(artName, "iso-8859-1") + "&" +
                            URLEncoder.encode("artLanguage", "UTF-8") + "=" + URLEncoder.encode(language, "iso-8859-1");
//
//                    String post_data1 = URLEncoder.encode("artName", "UTF-8") + "=" + URLEncoder.encode(artName, "EUC-KR") + "&" +
//                            URLEncoder.encode("artLanguage", "UTF-8") + "=" + URLEncoder.encode(language, "EUC-KR");
//
//                    String post_data2 = URLEncoder.encode("artName", "UTF-8") + "=" + URLEncoder.encode(artName, "Shift-JIS") + "&" +
//                            URLEncoder.encode("artLanguage", "UTF-8") + "=" + URLEncoder.encode(language, "Shift-JIS");
                    bufferedWriter.write(post_data);
//                    bufferedWriter.write(post_data1);
//                    bufferedWriter.write(post_data2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();


                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                  //  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "EUC-KR"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }

                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();

                    return result;



                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }


            @Override
            protected void onPostExecute(String s) {

//                progressDialog.dismiss();
                String JSON_STRING = s.trim();
                extractArt(JSON_STRING);

                super.onPostExecute(s);
            }
        }

        RetrieveArt retrieveArt = new RetrieveArt();
        retrieveArt.execute();
    }


    public static void extractArt(String Json_string) {
        Log.d(TAG, "extracting art RESULT : " + Json_string);

        String aName = "";
        String aImage = "";
        String aDesc = "";
        try {
            JSONObject jsonObject = new JSONObject(Json_string);
            JSONArray jsonArray = jsonObject.getJSONArray("artDetail");

            JSONObject jo = jsonArray.getJSONObject(0);
            aName = jo.getString("ArtName");
            aImage = jo.getString("ArtImage");
            aDesc = jo.getString("ArtDescription");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "The result is : " + aName);
        Log.d(TAG, "The result is : " + aImage);
        Log.d(TAG, "The result is : " + aDesc);


        artTitle.setText(aName);
        artDescrption.setText(aDesc);
        String imageLink = Config.JOOMLA_ASSETS + aImage;
        Log.d(TAG, "Image link is : " + imageLink);
        new DownloadImageTask(artImage).execute(imageLink);



    }

    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {

            String urlDisplay = urls[0];
            Bitmap mIcon = null;
            try {
                InputStream inputStream = new URL(urlDisplay).openStream();
                mIcon = BitmapFactory.decodeStream(inputStream);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return mIcon;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
                bmImage.setImageBitmap(bitmap);

        }
    }




}


