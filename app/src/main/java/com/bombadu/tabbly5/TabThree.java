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

public class TabThree extends Fragment {
    boolean isTextColor = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab3, container, false);

        final TextView threeTextView = view.findViewById(R.id.threeTextView);
        threeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isTextColor){
                    threeTextView.setTextColor(Color.BLUE);
                    isTextColor = true;
                } else {
                    threeTextView.setTextColor(Color.BLACK);
                    isTextColor = false;
                }
            }
        });
        return view;
    }
}
