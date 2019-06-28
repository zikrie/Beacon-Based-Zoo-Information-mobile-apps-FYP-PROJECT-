package com.example.heszrave.touristguide.zooMap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heszrave.touristguide.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class GoogleMapsActivity extends FragmentActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener

{

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Location lastLocation;
    private Marker currentUserLocationMarker;
    private static final int Request_User_Location_Code = 99;
    private double latitude, longitude;
    private int ProximityRadius = 10000;


    private Marker tiger;
    private Marker elephant;
    private Marker restaurant;
    private Marker panda;
    private Marker monkey;
    private Marker orangutan;
    private Marker camel;
    private Marker zebra;
    private Marker giraffe;
    private Marker savannah;
    private Marker ostrich;
    private Marker hedgehog;
    private Marker wolf;
    private Marker savannah_cafe;
    private Marker buffolo;
    private Marker rhinoceros;
    private Marker goose;
    private Marker tapir;
    private Marker lion;
    private Marker deer;
    private Marker toilet;
    private Marker milky_stork;
    private Marker milky_stork2;
    private Marker kangaroo;
    private Marker snake;
    private Marker surau;
    private Marker butterfly;
    private Marker turtle;
    private Marker food2;
    private Marker tapir1;
    private Marker food3;
    private Marker food1;
    private Marker toilet1;
    private Marker bat;
    private Marker kangaroo2;
    private Marker tapir2;
    private Marker bear;
    private Marker hippopotamus;
    private Marker crocodile;
    private Marker animalshow;
    private Marker toilet2;
    private Marker rabbit;
    private Marker monkey1;
    private Marker horse;
    private Marker buffolo1;
    private Marker hospital;
    private Marker office;
    private Marker food4;
    private Marker fish;
    private Marker entranceb;
    private Marker entrancea;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            checkUserLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

//    public void onClick(View v){
//
//        String hospital = "hospital", school = "school", restaurant = "restaurant";
//        Object transferData[] = new Object[2];
//        GetNearbyPlaces getNearbyPlaces = new GetNearbyPlaces();
//
//
//        switch (v.getId()){
//            case R.id.search_address:
//                EditText addressField = (EditText) findViewById(R.id.location_search);
//                String address = addressField.getText().toString();
//
//                List<Address> addressList = null;
//                MarkerOptions userMarkerOptions = new MarkerOptions();
//
//                if(!TextUtils.isEmpty(address)){
//                    Geocoder geocoder = new Geocoder(this);
//                    try {
//                        addressList = geocoder.getFromLocationName(address, 6);
//
//                        if(addressList != null){
//                            for(int i =0; i<addressList.size(); i++){
//                                Address userAddress = addressList.get(i);
//                                LatLng latLng = new LatLng(userAddress.getLatitude(), userAddress.getLongitude());
//
//                                userMarkerOptions.position(latLng);
//                                userMarkerOptions.title(address);
//                                userMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
//
//                                mMap.addMarker(userMarkerOptions);
//
//                                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//                                mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
//                            }
//                        }
//                        else{
//                            Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//
//
//
//                }
//                else {
//                    Toast.makeText(this,"please write any location name..." , Toast.LENGTH_SHORT).show();
//                }
//                break;
//
//            case R.id.hospitals_nearby:
//                mMap.clear();
//                String url = getUrl(latitude,longitude, hospital);
//                transferData[0] = mMap;
//                transferData[1] = url;
//
//                getNearbyPlaces.execute(transferData);
//                Toast.makeText(this, "Searching for nearby hospitals...", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "Showing for nearby hospitals...", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.schools_nearby:
//                mMap.clear();
//                url = getUrl(latitude,longitude, school);
//                transferData[0] = mMap;
//                transferData[1] = url;
//
//                getNearbyPlaces.execute(transferData);
//                Toast.makeText(this, "Searching for nearby schools...", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "Showing for nearby schools...", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.restaurants_nearby:
//                mMap.clear();
//                url = getUrl(latitude,longitude, restaurant);
//                transferData[0] = mMap;
//                transferData[1] = url;
//
//                getNearbyPlaces.execute(transferData);
//                Toast.makeText(this, "Searching for nearby restaurants...", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, "Showing for nearby restaurants...", Toast.LENGTH_SHORT).show();
//                break;
//        }
//
//    }

    private String  getUrl(double latitude,double longitude,String nearbyPlace){
        StringBuilder googleURL = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googleURL.append("location=" + latitude + "," + longitude);
        googleURL.append("&radius=" + ProximityRadius);
        googleURL.append("&type=" + nearbyPlace);
        googleURL.append("&sensor=true");
        googleURL.append("&key=" + "AIzaSyCfg8ju3RfBjsGArY9ZkRtYLX0Es6HjmPw");

        Log.d("GoogleMapsActivity", "url = " + googleURL.toString());

        return googleURL.toString();

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            buildGoogleApiClient();

            mMap.setMyLocationEnabled(true);
        }


        tiger= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210794  , 101.757866))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.tiger))
                .title("TIGER")
                .snippet("Latitude: 3.210794 | Longitude: 101.757866"));

        elephant= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.211424 , 101.757572))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.elephant))
                .title("ELEPHANT")
                .snippet("Latitude: 3.211424 | Longitude: 101.757572"));

        panda= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.212863, 101.758428))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.panda))
                .title("PANDA")
                .snippet("Latitude: 3.212863 | Longitude: 101.758428"));

        monkey= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.213482, 101.758967))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.monkey))
                .title("MONKEY")
                .snippet("Latitude: 3.213482 | Longitude: 101.758967"));

        orangutan= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.213582, 101.75931))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.orangutan))
                .title("ORANGUTAN")
                .snippet("Latitude: 3.213582 | Longitude: 101.75931"));

        camel= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.2129, 101.759067))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.camel))
                .title("CAMEL")
                .snippet("Latitude: 3.2129 | Longitude: 101.759067"));

        zebra= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.213091, 101.75957))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.zebra))
                .title("ZEBRA")
                .snippet("Latitude: 3.213091 | Longitude: 101.75957"));

        giraffe= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.212531, 101.759327))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.giraffe))
                .title("GIRAFFE")
                .snippet("Latitude: 3.212531 | Longitude: 101.759327"));

        savannah= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.211888, 101.759309))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.savannah))
                .title("SAVANNAH")
                .snippet("Latitude: 3.211888 | Longitude: 101.759309"));

        ostrich= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.211193, 101.759243))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ostrich))
                .title("OSTRICH")
                .snippet("Latitude: 3.211193 | Longitude: 101.759243"));

        hedgehog= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.212131, 101.758468))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hedgehog))
                .title("HEDGEHOG")
                .snippet("Latitude: 3.212131 | Longitude: 101.758468"));


        wolf= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.211579, 101.758385))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.wolf))
                .title("WOLF")
                .snippet("Latitude: 3.211579 | Longitude: 101.758385"));

        savannah_cafe= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.211777, 101.758779))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.savannah_cafe))
                .title("SAVANNAH CAFATERIA")
                .snippet("Latitude: 3.211777  | Longitude: 101.758779"));

        buffolo= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.211788, 101.757725))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.buffolo))
                .title("BUFFALO")
                .snippet("Latitude: 3.211788 | Longitude: 101.757725"));

        rhinoceros= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210673, 101.759182))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rhinoceros))
                .title("RHINOCEROS")
                .snippet("Latitude: 3.210673 | Longitude: 101.759182"));

        goose= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210427, 101.759198))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.goose))
                .title("GOOSE")
                .snippet("Latitude: 3.210427 | Longitude: 101.759198"));

        tapir= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210888 , 101.757411))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.tapir))
                .title("TAPIR")
                .snippet("Latitude: 3.210888 | Longitude: 101.757411"));


        lion= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210794  , 101.757574))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.lion))
                .title("LION")
                .snippet("Latitude: 3.210794 | Longitude: 101.757574"));

        deer= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210949   , 101.756899))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.deer))
                .title("DEER")
                .snippet("Latitude: 3.210949  | Longitude: 101.756899"));

        toilet= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.2113    , 101.758841))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.toilet))
                .title("TOILET")
                .snippet("Latitude: 3.2113  | Longitude: 101.758841"));

        milky_stork= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209911     , 101.757878))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.milky_stork))
                .title("MILKY STORK")
                .snippet("Latitude: 3.209911    | Longitude: 101.757878"));

        milky_stork2= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209933      , 101.756282))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.milky_stork2))
                .title("MILKY STORK")
                .snippet("Latitude: 3.209933  | Longitude: 101.756282"));

        kangaroo= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209452 , 101.756019))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.kangaroo))
                .title("KANGAROO")
                .snippet("Latitude: 3.209452.  | Longitude: 101.756019"));

        snake= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210185  , 101.758526))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.snake))
                .title("SNAKE")
                .snippet("Latitude: 3.210185 | Longitude: 101.758526"));

        surau= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209649   , 101.757527))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.surau))
                .title("SURAU")
                .snippet("Latitude: 3.209649  | Longitude: 101.757527"));

        butterfly= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209659    , 101.758044))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.butterfly))
                .title("BUTTERFLY")
                .snippet("Latitude: 3.209659   | Longitude: 101.758044"));

        turtle= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209985     , 101.759035))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.turtle))
                .title("TURTLE")
                .snippet("Latitude: 3.209985   | Longitude: 101.759035"));

        food2= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209183      , 101.757066))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food2))
                .title("RESTAURANT")
                .snippet("Latitude: 3.209183  | Longitude: 101.757066"));

        tapir1= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.208949       , 3.208949 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.tapir1))
                .title("TAPIR")
                .snippet("Latitude: 3.208949    | Longitude: 3.208949 "));

        food3= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209667        , 101.758545 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food3))
                .title("RESTAURANT")
                .snippet("Latitude: 3.209667 | Longitude: 101.758545 "));

        food1= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209281         , 101.758671 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food1))
                .title("RESTAURANT")
                .snippet("Latitude: 3.209281 | Longitude: 101.758671 "));

        toilet1= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209103          , 101.758807 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.toilet1))
                .title("TOILET")
                .snippet("Latitude: 3.209103  | Longitude: 101.758807 "));

        bat= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210032  , 101.759121 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bat))
                .title("BAT")
                .snippet("Latitude: 3.210032  | Longitude: 101.759121"));


        kangaroo2= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210218   , 101.75932 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.kangaroo2))
                .title("KANGAROO")
                .snippet("Latitude: 3.210218  | Longitude: 101.75932"));

        tapir2= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210574    , 101.759998 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.tapir2))
                .title("TAPIR")
                .snippet("Latitude: 3.210574  | Longitude: 101.759998"));

        bear= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210999     , 101.760812 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.bear))
                .title("BEAR COMPLEX")
                .snippet("Latitude: 3.210999  | Longitude: 101.760812"));

        hippopotamus= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.20997      , 101.759341 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hippopotamus))
                .title("HIPPOPOTAMUS")
                .snippet("Latitude: 3.20997  | Longitude: 101.759341"));

        crocodile= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210007       , 101.759852 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.crocodile))
                .title("CROCODILE")
                .snippet("Latitude: 3.210007   | Longitude: 101.759852"));

        animalshow= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.21005        , 101.760163 ))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.animalshow))
                .title("ANIMAL SHOW")
                .snippet("Latitude: 3.21005  | Longitude: 101.760163"));


        toilet2= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.210053         , 101.76043))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.toilet2))
                .title("TOILET")
                .snippet("Latitude: 3.210053   | Longitude: 101.76043"));

        rabbit= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209729  , 101.758893))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rabbit))
                .title("RABBIT")
                .snippet("Latitude: 3.209729   | Longitude: 101.758893"));

        monkey1= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.21019   , 101.758855))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.monkey1))
                .title("RABBIT")
                .snippet("Latitude: 3.21019   | Longitude: 101.758855"));

        horse= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209575    , 101.759124))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.horse))
                .title("HORSE")
                .snippet("Latitude: 3.209575  | Longitude: 101.759124"));

        buffolo1= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209984     , 101.760728))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.buffolo1))
                .title("BUFFALO")
                .snippet("Latitude: 3.209984  | Longitude: 101.760728"));

        office= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209139       , 101.759367))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.office))
                .title("EDUCATION, ZOOLOGY, PUBLIC AFFAIRS & CUSTOMER SERVCES OFFICE")
                .snippet("Latitude: 3.209139  | Longitude: 101.759367"));


        hospital= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209204       , 101.759605))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital))
                .title("VETERINART HOSPITAL")
                .snippet("Latitude: 3.209204  | Longitude: 101.759605"));

        food4= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209207         , 101.759825))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.food4))
                .title("RESTAURANT")
                .snippet("Latitude: 3.209207  | Longitude: 101.759825"));

        fish= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209048 , 101.760569))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.fish))
                .title("AQUARIUM")
                .snippet("Latitude: 3.209048   | Longitude: 101.760569"));

        entranceb= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.209546   , 101.761176))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.entranceb))
                .title("ENTRANCE B")
                .snippet("Latitude: 3.209546    | Longitude: 101.761176"));


        entrancea= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(3.20909 , 101.758094))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.entrancea))
                .title("ENTRANCE A")
                .snippet("Latitude: 3.20909   | Longitude: 101.758094"));







    }

    public boolean checkUserLocationPermission(){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_User_Location_Code );
            }
            else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_User_Location_Code );

            }
            return false;

        }
        else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case Request_User_Location_Code:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                        if(googleApiClient == null){
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else {
                    Toast.makeText(this, "Permission Denied",Toast.LENGTH_SHORT ).show();
                }
                return;
        }
    }

    protected synchronized void buildGoogleApiClient(){
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        googleApiClient.connect();

    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        lastLocation = location;

        if(currentUserLocationMarker != null){
            currentUserLocationMarker.remove();
        }

        LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("User current location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        currentUserLocationMarker = mMap.addMarker(markerOptions);

//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//        mMap.animateCamera(CameraUpdateFactory.zoomBy(2));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,longitude),17));


        if(googleApiClient != null){
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        }


    }



    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1100);
        locationRequest.setFastestInterval(1100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}