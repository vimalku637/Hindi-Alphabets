package com.vrp.hindialphabets.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vrp.hindialphabets.R;
import com.vrp.hindialphabets.fragments.SelectAlphabetVowels;

import butterknife.BindView;

public class VowelsSliderActivity extends AppCompatActivity {
    private ImageView iv_back, iv_next;
    RelativeLayout rl_main, rl_btn_bottom;
    private ViewPager sViewPager;
    private LinearLayout dotsLayout;
    private TextView dots[];

    VowelsSliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vowels_slider);
        // find view id
        initView();

        // create Adapter object
        sliderAdapter = new VowelsSliderAdapter(this);
        // set adapter in ViewPager
        sViewPager.setAdapter(sliderAdapter);
        // set PageChangeListener
        sViewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        // adding bottom dots -> addBottomDots(0);
//      addDotIndicator(0);
        //addBottomDots(0); //comment by vimal
    }


    // btnBackClick
    public void btnBackClick(View v) {
        // checking for last page
        // if last page home screen will be launched
        int current = getItem(-1);
//        if (current < layouts.length) {
        if (current < sliderAdapter.image_slide.length) {
            // move to next screen
            sViewPager.setCurrentItem(current);
        } else {
            launchHomeScreen();
        }
    }

    //btnHomeClick
    public void btnHomeClick(View view) {
        Fragment fragment = new SelectAlphabetVowels();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.rl_main, fragment); // fragment container id in first parameter is the  container(Main layout id) of Activity
        sViewPager.setVisibility(View.GONE);
        rl_btn_bottom.setVisibility(View.GONE);
        transaction.addToBackStack(null);  // this will manage backstack
        transaction.commit();
    }

    //btnNextClick
    public void btnNextClick(View v) {
        // checking for last page
        // if last page home screen will be launched
        int current = getItem(1);
//        if (current < layouts.length) {
        if (current < sliderAdapter.image_slide.length) {
            // move to next screen
            sViewPager.setCurrentItem(current);
        } else {
            launchHomeScreen();
        }
    }

    private void launchHomeScreen() {
        /*startActivity(new Intent(this, MainActivity.class));
        finish();*/
    }

    private int getItem(int i) {
        return sViewPager.getCurrentItem() + i;
    }

    private void initView() {
        sViewPager = findViewById(R.id.sViewPager);
        dotsLayout = findViewById(R.id.layoutDots);
        iv_back = findViewById(R.id.iv_back);
        iv_next = findViewById(R.id.iv_next);
        rl_main = findViewById(R.id.rl_main);
        rl_btn_bottom = findViewById(R.id.rl_btn_bottom);
    }


    // viewPagerPage ChangeListener according to Dots-Points
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            //addBottomDots(position); //comment by vimal

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == sliderAdapter.image_slide.length - 1) {
                // last page. make button text to GOT IT
                iv_next.setImageResource(R.drawable.next_icon);
                iv_back.setVisibility(View.VISIBLE);
            } else {
                // still pages are left
                iv_next.setImageResource(R.drawable.next_icon);
                iv_back.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };



    // add dot indicator
    public void addDotIndicator(){
        dots = new TextView[3];
        for (int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8266;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorWhite));

            dotsLayout.addView(dots[i]);
        }
    }

    // set of Dots points
    private void addBottomDots(int currentPage) {
//        dots = new TextView[layouts.length];
        dots = new TextView[3];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorWhite));  // dot_inactive
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.colorAccent)); // dot_active
    }
}
