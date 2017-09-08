package com.company.weedlook.collectionweed.views.main.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.company.weedlook.collectionweed.R;
import com.company.weedlook.collectionweed.models.Favorite;
import com.company.weedlook.collectionweed.views.main.FavoritesFragment;

import static com.company.weedlook.collectionweed.R.id.nameEt;

public class DetailsActivity extends AppCompatActivity {

    private Favorite favorite;
    private EditText input1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long Idweed = getIntent().getLongExtra(FavoritesFragment.WEED_ID, 0);

        favorite = Favorite.findById(Favorite.class, Idweed);
        getSupportActionBar().setTitle(favorite.getName());
        input1 = (EditText) findViewById(nameEt);


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (favorite.getName() != null) {
            favorite.setName(favorite.getName());
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        favorite.setName(favorite.getName().toString());
        favorite.save();

    }
}
