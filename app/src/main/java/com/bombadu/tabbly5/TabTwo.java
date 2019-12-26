package com.bombadu.tabbly5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabTwo extends Fragment {
    boolean isTextColor = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);

        final TextView twoTextView = view.findViewById(R.id.twoTextView);
        twoTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isTextColor){
                    twoTextView.setTextColor(Color.GREEN);

                    isTextColor = true;
                } else {
                    twoTextView.setTextColor(Color.BLACK);
                    isTextColor = false;
                }
            }
        });
        return view;
    }
}
