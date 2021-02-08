package com.vrp.hindialphabets.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vrp.hindialphabets.R;
import com.vrp.hindialphabets.adapter.SelectAlphabetAdapter;
import com.vrp.hindialphabets.model.SelectAlphabetModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SelectAlphabetConsonant extends Fragment {
    @BindView(R.id.rv_select_alphabet)
    RecyclerView rv_select_alphabet;

    /*normal widgets*/
    private Unbinder unbinder;
    private SelectAlphabetAdapter selectAlphabetAdapter;
    private ArrayList<SelectAlphabetModel> alphabetModelArrayList = new ArrayList<>();

    public SelectAlphabetConsonant() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_alphabet_consonant, container, false);
        //use butter knife in fragments with the help of unbinder class
        unbinder = ButterKnife.bind(this, view);
        setSelectAlphabetsAdapter();
        return view;
    }
    private void setSelectAlphabetsAdapter() {
        alphabetModelArrayList.add(new SelectAlphabetModel("क"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ख"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ग"));
        alphabetModelArrayList.add(new SelectAlphabetModel("घ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ङ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("च"));
        alphabetModelArrayList.add(new SelectAlphabetModel("छ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ज"));
        alphabetModelArrayList.add(new SelectAlphabetModel("झ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ञ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ट"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ठ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ड"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ढ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ण"));
        alphabetModelArrayList.add(new SelectAlphabetModel("त"));
        alphabetModelArrayList.add(new SelectAlphabetModel("थ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("द"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ध"));
        alphabetModelArrayList.add(new SelectAlphabetModel("न"));
        alphabetModelArrayList.add(new SelectAlphabetModel("प"));
        alphabetModelArrayList.add(new SelectAlphabetModel("फ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ब"));
        alphabetModelArrayList.add(new SelectAlphabetModel("भ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("म"));
        alphabetModelArrayList.add(new SelectAlphabetModel("य"));
        alphabetModelArrayList.add(new SelectAlphabetModel("र"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ल"));
        alphabetModelArrayList.add(new SelectAlphabetModel("व"));
        alphabetModelArrayList.add(new SelectAlphabetModel("श"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ष"));
        alphabetModelArrayList.add(new SelectAlphabetModel("स"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ह"));
        alphabetModelArrayList.add(new SelectAlphabetModel("क्ष"));
        alphabetModelArrayList.add(new SelectAlphabetModel("त्र"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ज्ञ"));
        rv_select_alphabet.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        selectAlphabetAdapter = new SelectAlphabetAdapter(getActivity(), alphabetModelArrayList);
        rv_select_alphabet.setAdapter(selectAlphabetAdapter);

        selectAlphabetAdapter.onItemClick(new SelectAlphabetAdapter.ClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onAplhabetClick(int position) {
                Toast.makeText(getActivity(), "Working in consonant!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
