package com.edcompanies.builda;


import com.edcompanies.builda.ui.cart.Cart;
import com.edcompanies.builda.ui.home.BuildingMaterial;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataManager {

    private static DataManager dataManager;
    private final Cart cart=new Cart();

    private DataManager(){
    }


    public static DataManager getInstance(){

        if(dataManager==null)
            dataManager=new DataManager();
        return dataManager;
    }


    private int[] images=new int[]{
            R.drawable.nails,R.drawable.cement,R.drawable.tiles,R.drawable.hammer


    };

    public ArrayList<BuildingMaterial> getBuildingMaterialArrayList() {
        return buildingMaterialArrayList;
    }

    public void setBuildingMaterialArrayList(ArrayList<BuildingMaterial> buildingMaterialArrayList) {
        this.buildingMaterialArrayList = buildingMaterialArrayList;
    }

    private ArrayList<BuildingMaterial> buildingMaterialArrayList=new ArrayList<BuildingMaterial>();

    public void initializeData(JSONObject data){
        JSONArray dataArray = null;
        try {
            dataArray=data.getJSONArray("data");
            for (int i = 0; i < dataArray.length() ; i++) {
                BuildingMaterial material=new BuildingMaterial();
                JSONObject materialObj=dataArray.getJSONObject(i);
                material.setImage(images[i]);
                material.setName(materialObj.getString("name"));
                material.setRating(materialObj.getInt("rating"));
                material.setPrice(materialObj.getInt("price"));
                buildingMaterialArrayList.add(material);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }



    public ArrayList<BuildingMaterial> getMaterialsInCart() {
        return materialsInCart;
    }

    private ArrayList<BuildingMaterial> materialsInCart=new ArrayList<BuildingMaterial>();

    public void addToCart(BuildingMaterial material) {
        materialsInCart.add(material);
    }

    public Cart getCart() {
        return cart;
    }

}
