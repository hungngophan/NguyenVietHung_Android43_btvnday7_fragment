package com.example.nguyenviethung_android43_btvnday7_fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class TuneFragment extends Fragment {
    TextView tvFromdefault,tvFromfile;


    public TuneFragment() {
        // Required empty public constructor
    }


    public static TuneFragment newInstance() {
        TuneFragment fragment = new TuneFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tune_fragment,container,false);
        tvFromdefault = view.findViewById(R.id.tvFromdefault);
        tvFromfile = view.findViewById(R.id.tvFromfile);

        // set event tvFromdefault
        tvFromdefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Nexus Tune","Winphone Tune","Peep Tune","Nokia Tune","Ect"};
                List<String> list = new ArrayList<>();
                AlertDialog alertDialog = new AlertDialog.Builder((getContext()))
                        .setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.add(strings[which]);
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvFromdefault.setText(list.get( list.size()-1 ).toString());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();
                alertDialog.show();

            }
        });/// end onClick

        return view;

    }// end onCreateView
}
