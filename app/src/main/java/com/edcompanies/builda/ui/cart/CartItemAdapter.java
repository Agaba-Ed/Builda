package com.edcompanies.builda.ui.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edcompanies.builda.DataManager;
import com.edcompanies.builda.R;
import com.edcompanies.builda.ui.home.BuildingMaterial;

import java.util.ArrayList;


public class CartItemAdapter extends RecyclerView.Adapter<CartItemViewHolder> {

    private final Context mContext;
    private ArrayList<BuildingMaterial> buildingMaterials;
    private OnTotalChanged mCallBack;


    public CartItemAdapter(Context context,OnTotalChanged callback) {
        buildingMaterials= DataManager.getInstance().getMaterialsInCart();
        this.mContext=context;
        this.mCallBack=callback;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(mContext).inflate(R.layout.item_cart_item,parent,false);

        return new CartItemViewHolder(itemView,mCallBack);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {
        BuildingMaterial material=buildingMaterials.get(position);
        holder.materialName.setText(material.getName());
        holder.materialImage.setImageResource(material.getImage());
        holder.materialPrice.setText(Integer.toString(material.getPrice()));
        holder.material=material;


    }

    @Override
    public int getItemCount() {
        return buildingMaterials.size();
    }
}
