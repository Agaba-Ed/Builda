package com.edcompanies.builda.ui.home;

import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.edcompanies.builda.DataManager;
import com.edcompanies.builda.R;
import com.google.android.material.snackbar.Snackbar;

public class BuildingMaterialViewHolder extends RecyclerView.ViewHolder {
    ImageView materialImage;
    TextView materialName,materialPrice,popUpMenu;
    RatingBar materialRating;
    BuildingMaterial material;
    public BuildingMaterialViewHolder(@NonNull View itemView) {
        super(itemView);

        materialImage=itemView.findViewById(R.id.imv_building_material);
        materialName=itemView.findViewById(R.id.txv_material_name);
        materialPrice=itemView.findViewById(R.id.txv_price);
        materialRating=itemView.findViewById(R.id.ratingBar2);
        popUpMenu=itemView.findViewById(R.id.pop_up_button);

        popUpMenu.setOnClickListener(
                v -> {
                    PopupMenu popup = new PopupMenu(itemView.getContext(), v);
                    MenuInflater inflater = popup.getMenuInflater();
                    inflater.inflate(R.menu.actions, popup.getMenu());
                    popup.show();
                    popup.setOnMenuItemClickListener(item -> {
                        switch (item.getItemId()){
                            case R.id.action_details:
                                break;
                            case R.id.action_add_to_cart:
                                addToCart(material);
                                break;
                            case R.id.action_share:
                                break;
                            default:
                                return false;

                        }
                        return true;
                    });

                }
        );



    }

    private void addToCart(BuildingMaterial material) {
        DataManager.getInstance().addToCart(material);
        Snackbar.make(itemView,"Added to Cart",Snackbar.LENGTH_SHORT).show();
        DataManager.getInstance().getCart().setTotal(DataManager.getInstance().getCart().getTotal()+material.getPrice());

    }
}
