package com.example.heszrave.touristguide.dropdownListFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heszrave.touristguide.MainActivity;
import com.example.heszrave.touristguide.R;
import com.squareup.picasso.Picasso;

public class FoodDetailsActivity extends AppCompatActivity {

    private ImageView favoriteIcon;
    private Button button;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageView = findViewById(R.id.imageView);
        TextView foodNameTextView = findViewById(R.id.nameTextView);
        favoriteIcon = findViewById(R.id.favoriteIcon);
        TextView priceTextView = findViewById(R.id.priceTextView);
        TextView detailsTextView = findViewById(R.id.detailsTextView);

        final Food food = (Food) getIntent().getSerializableExtra("food");
        final Food sds = (Food) getIntent().getSerializableExtra("restaurant");
//        sds.getName()
        final String foodType = food.getFoodType().toString();
        Log.d(TAG, "Restaurant type :" + foodType);
        Picasso.with(this)
                .load(food.getImage())
                .resize(200, 200)
                .into(imageView);

        foodNameTextView.setText(food.getName());
        favoriteIcon.setImageResource(food.isFavorite() ? R.drawable.ic_favorite_solid_24dp : R.drawable.ic_favorite_border_24dp);
        priceTextView.setText(getResources().getString(R.string.price, food.getPrice()));
        detailsTextView.setText(food.getDetails());

        favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(food.isFavorite()) {
                    favoriteIcon.setImageResource(R.drawable.ic_favorite_border_24dp);
                    food.setFavorite(false);
                }
                else {
                    favoriteIcon.setImageResource(R.drawable.ic_favorite_solid_24dp);
                    food.setFavorite(true);
                }
            }
        });

        Button ButtonMap = (Button) findViewById(R.id.ButtonMap);
        ButtonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (foodType.equals("RESTAURANT_VANGGEY"))
                {

                    Intent intent = new Intent(getApplicationContext(), GoogleMapsRestaurantVenggey.class);
                    intent.putExtra("restaurant", food);
                    startActivity(intent);

                }

                else if (foodType.equals("MADFOON_PALACE"))
                {
                    Intent intent = new Intent(getApplicationContext(), GoogleMapsMadfoonPalace.class);
                    intent.putExtra("restaurant", food);
                    startActivity(intent);

                }

                else if (foodType.equals("WAYBACK_BURGERS"))
                {
                    Intent intent = new Intent(getApplicationContext(), GoogleMapsWaybackBurgers.class);
                    intent.putExtra("restaurant", food);
                    startActivity(intent);

                }

                else if (foodType.equals("MAKAN_CULTURE"))
                {
                    Intent intent = new Intent(getApplicationContext(), GoogleMapsMakanCulture.class);
                    intent.putExtra("restaurant", food);
                    startActivity(intent);

                }

                else
                {
                    Log.d(TAG, "No food equals");
                }





            }
        });




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

}
