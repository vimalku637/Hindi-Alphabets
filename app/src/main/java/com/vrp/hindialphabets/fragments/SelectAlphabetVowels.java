package com.vrp.hindialphabets.fragments;

import android.content.Intent;
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
import com.vrp.hindialphabets.viewpager.VowelsSliderActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SelectAlphabetVowels extends Fragment {
    @BindView(R.id.rv_select_alphabet)
    RecyclerView rv_select_alphabet;

    /*normal widgets*/
    private Unbinder unbinder;
    private SelectAlphabetAdapter selectAlphabetAdapter;
    private ArrayList<SelectAlphabetModel> alphabetModelArrayList = new ArrayList<>();

    public SelectAlphabetVowels() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_alphabet_vowels, container, false);
        //use butter knife in fragments with the help of unbinder class
        unbinder = ButterKnife.bind(this, view);
        setSelectAlphabetsAdapter();
        return view;
    }
    private void setSelectAlphabetsAdapter() {
        alphabetModelArrayList.add(new SelectAlphabetModel("अ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("आ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("इ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ई"));
        alphabetModelArrayList.add(new SelectAlphabetModel("उ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ऊ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ऋ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ए"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ऐ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("ओ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("औ"));
        alphabetModelArrayList.add(new SelectAlphabetModel("अं"));
        alphabetModelArrayList.add(new SelectAlphabetModel("अः"));
        rv_select_alphabet.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        selectAlphabetAdapter = new SelectAlphabetAdapter(getActivity(), alphabetModelArrayList);
        rv_select_alphabet.setAdapter(selectAlphabetAdapter);

        selectAlphabetAdapter.onItemClick(new SelectAlphabetAdapter.ClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onAplhabetClick(int position) {
                Intent intent = new Intent(getActivity(), VowelsSliderActivity.class);
                startActivity(intent);
            }
        });
    }
}
