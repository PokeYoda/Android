package com.example.drawerapp.ui.zad2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawerapp.databinding.FragmentTask2Binding;
import com.example.drawerapp.ui.zad2.Task2ViewModel;
import com.google.android.material.snackbar.Snackbar;

public class Task2Fragment extends Fragment {

    private FragmentTask2Binding binding;

    String[] desc = {"Barbarian", "Bard", "Druid", "Fighter", "Rogue", "Warlock", "Blood hunter"};
    int index=0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Task2ViewModel homeViewModel =
                new ViewModelProvider(this).get(Task2ViewModel.class);


        binding = FragmentTask2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.leftArrow.setEnabled(false);
        binding.textImage.setText(desc[0]);
        binding.imageViewCharacter.setImageResource(getResources().getIdentifier("img0", "drawable", root.getContext().getPackageName()));

        binding.leftArrow.setOnClickListener(v->{
            index--;
            binding.textImage.setText(desc[index]);
            binding.imageViewCharacter.setImageResource(getResources().getIdentifier("img"+String.valueOf(index) , "drawable", root.getContext().getPackageName()));
            if(index <= 0) {
                binding.leftArrow.setEnabled(false);
            }
            binding.rightArrow.setEnabled(true);
        });

        binding.rightArrow.setOnClickListener(v->{
            index++;
            binding.textImage.setText(desc[index]);
            binding.imageViewCharacter.setImageResource(getResources().getIdentifier("img"+String.valueOf(index) , "drawable", root.getContext().getPackageName()));
            if(index>= desc.length-1){
                binding.rightArrow.setEnabled(false);
            }
            binding.leftArrow.setEnabled(true);
        });

        /*binding.ID3.setOnClickListener(v -> {
            if(binding.ID2.getText().toString().isEmpty()){
                if(binding.ID5.isChecked()){
                    Toast.makeText(root.getContext(),"Nie wpisano tekstu",Toast.LENGTH_SHORT).show();
                }
                else{
                    Snackbar.make(root.getRootView(),"Nie wpisano tekstu",Snackbar.LENGTH_SHORT).show();
                }
            }
            else{
                if(binding.ID5.isChecked()){
                    Toast.makeText(root.getContext(),binding.ID2.getText(),Toast.LENGTH_SHORT).show();
                }
                else{
                    Snackbar.make(root.getRootView(),binding.ID2.getText(),Snackbar.LENGTH_SHORT).show();
                }
            }

        });*/


//        final TextView textView = binding.textTask1;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}