package com.example.drawerapp.ui.zad4;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.drawerapp.R; // Correct import for R file
import com.example.drawerapp.databinding.FragmentTask4Binding;

import java.util.ArrayList;

public class Task4Fragment extends Fragment {

    private FragmentTask4Binding binding;
    private EditText plainTextInput;
    private Button addButton;
    private ListView listView;
    private ArrayList<String> itemList;
    private CustomAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Task4ViewModel homeViewModel =
                new ViewModelProvider(this).get(Task4ViewModel.class);

        binding = FragmentTask4Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize UI elements
        plainTextInput = binding.plainTextInput;
        addButton = binding.addButton;
        listView = binding.listView;

        // Initialize item list and adapter
        itemList = new ArrayList<>();
        adapter = new CustomAdapter(itemList);
        listView.setAdapter(adapter);

        // Enable the "Add" button only if the input field is not empty
        plainTextInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addButton.setEnabled(s.length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Add item to the list on button click
        addButton.setOnClickListener(v -> {
            String input = plainTextInput.getText().toString();
            if (!input.isEmpty()) {
                itemList.add(input);
                adapter.notifyDataSetChanged();
                plainTextInput.setText(""); // Clear input field
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // Custom Adapter for handling cross functionality
    private class CustomAdapter extends BaseAdapter {
        private ArrayList<String> items;

        public CustomAdapter(ArrayList<String> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(requireContext()).inflate(R.layout.list_item, parent, false);
            }

            // Get references to views
            TextView itemText = convertView.findViewById(R.id.itemText);
            TextView removeItem = convertView.findViewById(R.id.removeItem);

            // Set the item text
            itemText.setText(items.get(position));

            // Handle remove (X) button click
            removeItem.setOnClickListener(v -> {
                items.remove(position);
                notifyDataSetChanged();
            });

            return convertView;
        }
    }
}
