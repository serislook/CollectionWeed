package com.company.weedlook.collectionweed.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.company.weedlook.collectionweed.R;
import com.company.weedlook.collectionweed.data.Memories;
import com.company.weedlook.collectionweed.models.Favorite;

import java.util.List;

/**
 * Created by osx on 23-08-17.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private List<Favorite> favorites = new Memories().favorites();

    private FavoriteClickListener listener;

    public FavoritesAdapter(FavoriteClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_favorite, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Favorite favorite = favorites.get(position);
        holder.name.setText(favorite.getName());
        holder.variety.setText(favorite.getVariety());
        holder.toforget.setChecked(favorite.istoforget());

        holder.toforget.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            int auxPosition = holder.getAdapterPosition();
                            Favorite auxFavorite = favorites.get(auxPosition);
                            auxFavorite.setToforget(true);
                            auxFavorite.save();
                            favorites.remove(auxPosition);
                            notifyItemRemoved(auxPosition);


                        }
                    }, 400);
                }

            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Favorite auxFavorite = favorites.get(holder.getAdapterPosition());
                listener.clikedID(auxFavorite.getId());


            }
        });

        holder.variety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Favorite auxFavorite = favorites.get(holder.getAdapterPosition());
                listener.clikedID(auxFavorite.getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return favorites.size();


    }

    public void update(Favorite favorite) {
        favorites.add(favorite);
        notifyDataSetChanged();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox toforget;
        private TextView name, variety;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameTv);
            variety = (TextView) itemView.findViewById(R.id.varietyTv);
            toforget = (CheckBox) itemView.findViewById(R.id.toforgetCb);
        }
    }
}
