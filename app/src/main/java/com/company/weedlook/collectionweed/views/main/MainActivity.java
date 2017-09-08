package com.company.weedlook.collectionweed.views.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.company.weedlook.collectionweed.R;
import com.company.weedlook.collectionweed.models.Favorite;

public class MainActivity extends AppCompatActivity {

    private FavoritesFragment favoritesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        favoritesFragment = (FavoritesFragment) getSupportFragmentManager().findFragmentById(R.id.favoritesfragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_favorite);

                ImageButton button = (ImageButton) dialog.findViewById(R.id.rememberfavoriteIb);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText input1 = (EditText) dialog.findViewById(R.id.nameEt);
                        EditText input2 = (EditText) dialog.findViewById(R.id.varietyEt);
                        String name = input1.getText().toString();
                        String variety = input2.getText().toString();

                        if (name.trim().length() > 0) {

                            Favorite favorite = new Favorite();
                            favorite.setName(name);
                            favorite.setVariety(variety);
                            favorite.save();
                            Log.d("toforget", String.valueOf(favorite));

                            favoritesFragment.updateList(favorite);
                        }

                        dialog.dismiss();


                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
