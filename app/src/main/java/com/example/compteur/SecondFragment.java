package com.example.compteur;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {
    private int count = 0;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment));

        view.findViewById(R.id.minusButton).setOnClickListener(view1 -> minusCount());

        view.findViewById(R.id.plusButton).setOnClickListener(view1 -> plusCount());

        view.findViewById(R.id.RAZButton).setOnClickListener(view1 -> razCount());
    }

    private void minusCount(){
        if(count>0){
            count--;
        }
        modifyTextView(count);
    }

    private void plusCount(){
        count++;
        modifyTextView(count);
    }

    private void razCount(){
        count=0;
        modifyTextView(count);
    }

    private void modifyTextView(int count){
        TextView t = getView().findViewById(R.id.countText);
        t.setText(String.valueOf(count));
    }
}