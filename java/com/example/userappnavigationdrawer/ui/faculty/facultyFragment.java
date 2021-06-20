package com.example.userappnavigationdrawer.ui.faculty;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.userappnavigationdrawer.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class facultyFragment extends Fragment {



    private RecyclerView csDepartment,itDepartment,entcDepartment,etrxDepartment;
    private LinearLayout csNoData;
    private LinearLayout itNoData;
    private LinearLayout extcNoData;
    private LinearLayout etrxNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private DatabaseReference reference,dbRef;
    private TeacherAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_faculty, container, false);
        csNoData= view.findViewById(R.id.csNoData);
        itNoData= view.findViewById(R.id.itNoData);
        extcNoData = view.findViewById(R.id.entcNoData);
        etrxNoData= view.findViewById(R.id.etrxNoData);
        csDepartment= view.findViewById(R.id.csDepartment);
        itDepartment= view.findViewById(R.id.itDepartment);
        entcDepartment= view.findViewById(R.id.entcDepartment);
        etrxDepartment= view.findViewById(R.id.etrxDepartment);
        reference=  FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        itDepartment();
        entcDepartment();
        etrxDepartment();

        return view;
    }

    private void csDepartment() {
        dbRef=reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1=new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);

                }
                else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren() ){
                        TeacherData data=dataSnapshot1.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list1,getContext());
                    csDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Database Error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void itDepartment() {
        dbRef=reference.child("Information Technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list2=new ArrayList<>();
                if(!datasnapshot.exists()){
                    itNoData.setVisibility(View.VISIBLE);
                    itDepartment.setVisibility(View.GONE);

                }
                else{
                    itNoData.setVisibility(View.GONE);
                    itDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot1:datasnapshot.getChildren() ){
                        TeacherData data=dataSnapshot1.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    itDepartment.setHasFixedSize(true);
                    itDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list2,getContext());
                    csDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Database Error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void entcDepartment() {
        dbRef=reference.child("Electronics and Telecommunications");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list3=new ArrayList<>();
                if(!datasnapshot.exists()){
                    extcNoData.setVisibility(View.VISIBLE);
                    entcDepartment.setVisibility(View.GONE);

                }
                else{
                    extcNoData.setVisibility(View.GONE);
                    entcDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot1:datasnapshot.getChildren() ){
                        TeacherData data=dataSnapshot1.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    entcDepartment.setHasFixedSize(true);
                    entcDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list3,getContext());
                    entcDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Database Error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void etrxDepartment() {
        dbRef=reference.child("Electronics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                list4=new ArrayList<>();
                if(!datasnapshot.exists()){
                    etrxNoData.setVisibility(View.VISIBLE);
                    etrxDepartment.setVisibility(View.GONE);

                }
                else{
                    etrxNoData.setVisibility(View.GONE);
                    etrxDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot1:datasnapshot.getChildren() ){
                        TeacherData data=dataSnapshot1.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    etrxDepartment.setHasFixedSize(true);
                    etrxDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter=new TeacherAdapter(list4,getContext());
                    etrxDepartment.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Database Error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}