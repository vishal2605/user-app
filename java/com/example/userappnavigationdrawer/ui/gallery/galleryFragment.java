package com.example.userappnavigationdrawer.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.userappnavigationdrawer.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class galleryFragment extends Fragment {
    RecyclerView convoRecycler,indepenRecycler,oculusRecycler,otherRecycler;
    GalleryAdaptor adaptor;
    DatabaseReference reference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_gallery, container, false);

        convoRecycler=view.findViewById(R.id.convocationRecycler);
        indepenRecycler=view.findViewById(R.id.independanceRecycler);
        oculusRecycler=view.findViewById(R.id.oculusRecycler);
        otherRecycler=view.findViewById(R.id.otherRecycler);

        reference= FirebaseDatabase.getInstance().getReference().child("gallery");
        getConvolationImage();
        getIndependanceImage();
        getOculusImage();
        getOtherImage();


         return view;
    }

    private void getConvolationImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);

                }
                adaptor=new GalleryAdaptor(getContext(),imageList);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                convoRecycler.setAdapter(adaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getOculusImage() {
        reference.child("Oculus").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);

                }
                adaptor=new GalleryAdaptor(getContext(),imageList);
                oculusRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                oculusRecycler.setAdapter(adaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);

                }
                adaptor=new GalleryAdaptor(getContext(),imageList);
                indepenRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                indepenRecycler.setAdapter(adaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getIndependanceImage() {
        reference.child("Independance day").addValueEventListener(new ValueEventListener() {
            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);

                }
                adaptor=new GalleryAdaptor(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                otherRecycler.setAdapter(adaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}