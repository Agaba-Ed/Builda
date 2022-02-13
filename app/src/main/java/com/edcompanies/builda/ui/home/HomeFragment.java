package com.edcompanies.builda.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;;
import androidx.recyclerview.widget.GridLayoutManager;

import com.edcompanies.builda.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.recyclerMaterials.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.recyclerMaterials.setAdapter(new BuildingMaterialAdapter(getContext()));
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}