package com.vrp.hindialphabets.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.vrp.hindialphabets.R;

public class VowelsSliderAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
//    private TextView slideHeading, slideDescription;
//    private ImageView slide_imageView;


    public VowelsSliderAdapter(Context context) {

        this.context = context;
    }

    // imgage array for vowels
    public int[] image_slide = {
            R.drawable.anaar,
            R.drawable.aam,
            R.drawable.imalee,
            R.drawable.eekha,
            R.drawable.ullu,
            R.drawable.oont,
            R.drawable.rishi,
            R.drawable.aedee,
            R.drawable.ainak,
            R.drawable.okhal,
            R.drawable.aurat,
            R.drawable.angoor,
            R.drawable.ah
    };

    // heading Array
    public String[] alphabet_slide = {
            "अ",
            "आ",
            "इ",
            "ई",
            "उ",
            "ऊं",
            "ऋ",
            "ए",
            "ऐ",
            "ओ",
            "औ",
            "अं",
            "अ:"
    };

    // heading Array
    public String[] heading_slide = {
            "अनार (Annar)",
            "आम (Aam)",
            "इमली (Imalee)",
            "ईख (Eekha)",
            "उल्लू (Ullu)",
            "ऊंट (Oont)",
            "ऋषि (Rishi)",
            "एडी (Aedee)",
            "ऐनक (Ainak)",
            "ओखली (Okhali)",
            "औरत (Aurat)",
            "अंगूर (Angoor)",
            "अ: (Ah)"
    };

    // description Array
    public String[] description_slide = {
            "Splash Screen like professional with Animation in Android Studio",
            "Splash Screen with Transition Animation",
            " simple way to create Splash Scree"
    };


    @Override
    public int getCount() {
        return image_slide.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.vowels_slider_adapter, container, false);
        container.addView(view);

        TextView tv_vowels = view.findViewById(R.id.tv_vowels);
        ImageView slide_imageView = view.findViewById(R.id.imageView1);
        TextView slideHeading = view.findViewById(R.id.tvHeading);
        TextView slideDescription = view.findViewById(R.id.tvDescription);

        tv_vowels.setText(alphabet_slide[position]);
        slide_imageView.setImageResource(image_slide[position]);
        slideHeading.setText(heading_slide[position]); //comment by vimal
        //slideDescription.setText(description_slide[position]); comment by vimal

        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        View view = (View) object;
//        container.removeView(view);
//    }
}
