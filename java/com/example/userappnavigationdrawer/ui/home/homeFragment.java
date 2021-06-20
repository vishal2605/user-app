package com.example.userappnavigationdrawer.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.userappnavigationdrawer.R;
import com.example.userappnavigationdrawer.SliderAdaptor;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class homeFragment extends Fragment {
    private int[] images;
    private String[] text;
    private SliderAdaptor adaptor;
    private SliderView sliderView;
    ImageView map;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView=view.findViewById(R.id.sliderView);
        images=new int[]{R.drawable.spitlogo,R.drawable.spitentry,R.drawable.spitphoto,R.drawable.spitclass,R.drawable.spitplacement};
        text=new String[]{"First Image","Second Image","Third image","Fourth Image","Fifth Image"};
        adaptor=new SliderAdaptor(images,text);
        sliderView.setSliderAdapter(adaptor);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.DROP);
        sliderView.startAutoCycle();
        // map
        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmap();
            }

            private void openmap() {
                Uri uri=Uri.parse("geo:0,0/q=Sardar Patel Institute of Technology");
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);

            }
        });
        return view;

    }
}