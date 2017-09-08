package com.company.weedlook.collectionweed.data;

import com.company.weedlook.collectionweed.models.Favorite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osx on 23-08-17.
 */

public class Memories {


    public List<Favorite> favorites() {

        List<Favorite> favorites = new ArrayList<>();
        List<Favorite> favoriteList = Favorite.find(Favorite.class, "toforget = 0 ");
        if (favoriteList != null && favoriteList.size() > 0) {
            favorites.addAll(favoriteList);
        }

        return favorites;


    }


}
