package com.edcompanies.builda.ui.cart;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edcompanies.builda.DataManager;
import com.edcompanies.builda.R;
import com.edcompanies.builda.ui.home.BuildingMaterial;

public class CartItemViewHolder extends RecyclerView.ViewHolder {

    ImageView materialImage;
    TextView materialName,materialPrice,materialQuantity,addItem,removeItem;
    int quantity=1;
    BuildingMaterial material;
    public CartItemViewHolder(@NonNull View itemView, OnTotalChanged mCallBack) {
        super(itemView);

        materialImage=itemView.findViewById(R.id.imc_material);
        materialName=itemView.findViewById(R.id.txtc_name);
        materialPrice=itemView.findViewById(R.id.txtc_price);
        materialQuantity=itemView.findViewById(R.id.txtc_quantity);
        addItem=itemView.findViewById(R.id.plus_);
        removeItem=itemView.findViewById(R.id.minus_);

        addItem.setOnClickListener(
                v -> {
                    ++quantity;
                    materialQuantity.setText(Integer.toString(quantity));
                    DataManager.getInstance().getCart().setTotal(DataManager.getInstance().getCart().getTotal()+material.getPrice());
                    mCallBack.onChange(DataManager.getInstance().getCart().getTotal());
                }
        );

        removeItem.setOnClickListener(
                v -> {
                    if(quantity>1) {
                        --quantity;
                        materialQuantity.setText(Integer.toString(quantity));
                        DataManager.getInstance().getCart().setTotal(DataManager.getInstance().getCart().getTotal()-material.getPrice());
                        mCallBack.onChange(DataManager.getInstance().getCart().getTotal());
                    }

                }
        );

        mCallBack.onChange(DataManager.getInstance().getCart().getTotal());



    }

}
