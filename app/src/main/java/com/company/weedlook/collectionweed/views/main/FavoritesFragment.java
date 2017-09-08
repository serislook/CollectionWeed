package com.company.weedlook.collectionweed.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.company.weedlook.collectionweed.R;
import com.company.weedlook.collectionweed.adapters.FavoriteClickListener;
import com.company.weedlook.collectionweed.adapters.FavoritesAdapter;
import com.company.weedlook.collectionweed.models.Favorite;
import com.company.weedlook.collectionweed.views.main.details.DetailsActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class FavoritesFragment extends Fragment implements FavoriteClickListener {

    private FavoritesAdapter adapter;

    public static final String WEED_ID = "com.company.weedlook.collectionweed.views.main.KEY.WEED_ID";


    public FavoritesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.favoriteRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FavoritesAdapter(this);
        recyclerView.setAdapter(adapter);


    }

    public void updateList(Favorite favorite) {
        adapter.update(favorite);

        //Log.d("favorite", favorite.getName());

    }

    @Override
    public void clikedID(long id) {

        Toast.makeText(getContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();

        Intent Intent = new Intent(getActivity(), DetailsActivity.class);
        Intent.putExtra(WEED_ID, id);
        startActivity(Intent);


    }

}
