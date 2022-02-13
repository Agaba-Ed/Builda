package com.edcompanies.builda.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.edcompanies.builda.DataManager;
import com.edcompanies.builda.R;

import java.util.ArrayList;

public class BuildingMaterialAdapter extends RecyclerView.Adapter<BuildingMaterialViewHolder> {

    private final Context mContext;
    private ArrayList<BuildingMaterial> buildingMaterials;

    BuildingMaterialAdapter(Context context){
        this.mContext=context;
        buildingMaterials= DataManager.getInstance().getBuildingMaterialArrayList();
    }

    @NonNull
    @Override
    public BuildingMaterialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(mContext).inflate(R.layout.item_building_material,parent,false);

        return new BuildingMaterialViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingMaterialViewHolder holder, int position) {
        BuildingMaterial material=buildingMaterials.get(position);
        holder.materialName.setText(material.getName());
        holder.materialImage.setImageResource(material.getImage());
        holder.materialRating.setRating(Float.valueOf(material.getRating()));
        holder.materialPrice.setText(Integer.toString(material.getPrice()));
        holder.material=material;

    }

    @Override
    public int getItemCount() {
        return buildingMaterials.size();
    }
}
