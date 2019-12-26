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

public class TabOne extends Fragment {
    boolean isTextColor = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1, container, false);
        final TextView oneTextView = view.findViewById(R.id.oneTextView);
        oneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isTextColor){
                    oneTextView.setTextColor(Color.RED);
                    isTextColor = true;
                } else {
                    oneTextView.setTextColor(Color.BLACK);
                    isTextColor = false;
                }
            }
        });

        String[] myCities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Detroit", "Jacksonville", "Indianapolis", "San Francisco", "Columbus", "Austin", "Memphis", "Fort Worth", "Baltimore", "Charlotte", "El Paso", "Boston", "Seattle"};

        return view;
    }
}
