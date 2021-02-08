package com.vrp.hindialphabets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.vrp.hindialphabets.fragments.SelectAlphabetConsonant;
import com.vrp.hindialphabets.fragments.SelectAlphabetVowels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.ll_vowels)
    LinearLayout ll_vowels;
    @BindView(R.id.ll_consonant)
    LinearLayout ll_consonant;
    @BindView(R.id.rl_main)
    RelativeLayout rl_main;

    /*normal widgets*/
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*to enable back button*/
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Hind Alphabets");
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ll_vowels,R.id.ll_consonant})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_vowels:
                Fragment fragment = new SelectAlphabetVowels();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.rl_main, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
                ll_vowels.setVisibility(View.GONE);
                ll_consonant.setVisibility(View.GONE);
                transaction.addToBackStack(null);  // this will manage backstack
                transaction.commit();
                break;
            case R.id.ll_consonant:
                Fragment fragment1 = new SelectAlphabetConsonant();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.rl_main, fragment1); // fragment container id in first parameter is the  container(Main layout id) of Activity
                ll_vowels.setVisibility(View.GONE);
                ll_consonant.setVisibility(View.GONE);
                transaction1.addToBackStack(null);  // this will manage backstack
                transaction1.commit();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.rate_this_app) {
            // do something
        }
        if(id == R.id.share_this_app) {
            // do something
        }
        if(id == R.id.settings) {
            // do something
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ll_vowels.setVisibility(View.VISIBLE);
        ll_consonant.setVisibility(View.VISIBLE);
    }
}
