package com.example.userappnavigationdrawer.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.userappnavigationdrawer.R;

import java.util.ArrayList;
import java.util.List;

public class aboutFragment extends Fragment {
    private ViewPager viewPager;
    private BranchAdaptor adaptor;
    private List<BranchModel> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about, container, false);
        list=new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_comps, "Computer Science","The most important aspect of computer science is problem solving, an essential skill for life. Students study the design, development and analysis of software and hardware used to solve problems in a variety of business, scientific and social contexts. Because computers solve problems to serve people, there is a significant human side to computer science as well."));
        list.add(new BranchModel(R.drawable.ic_comps, "IT","Business rely on information technology to help them be more productive. This is a career that benefits any business by allowing companies to work more efficiently and to maximise productivity. And with that comes faster communication, electronic storage and the protection of important documentation."));
        list.add(new BranchModel(R.drawable.ic_elctronics, "Electronic and telecommunication" , "Today, in various industries, various electronic things are used such as fiber optics, electronics and transistors which make various tasks much easier. This is where the knowledge of electronics and telecommunication engineering is used. ... Communication Industry – Telephones and Radio etc."));
        list.add(new BranchModel(R.drawable.ic_elctronics, "Electronics"," electronic engineers work at the forefront of practical technology, improving the devices and systems we use every day. From solar-energy systems to mobile phones, we innovate to meet society's communication, tech and energy needs."));
        adaptor=new BranchAdaptor(getContext(),list);
        viewPager=view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adaptor);

        ImageView imageView=view.findViewById(R.id.college_image);
        Glide.with(getContext()).load(R.drawable.spitentry).into(imageView);
        return view;
    }
}