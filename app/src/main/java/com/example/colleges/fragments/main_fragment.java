package com.example.colleges.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colleges.R;
import com.example.colleges.adapter.universities_adapter;
import com.example.colleges.models.model;
import com.example.colleges.networkinstance.retrofit_instance;
import com.example.colleges.networkinstance.universities_api;
import com.example.colleges.repository.universities_repository;
import com.example.colleges.viewmodel.main_viewmodel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class main_fragment extends Fragment {

    private main_viewmodel mviewmodel;
    private RecyclerView recyclerView;
    private universities_adapter adapter;
    private List<model> universities_list;
    private universities_repository repository;
    private universities_api api ;

    public static main_fragment newInstance(){
        return new main_fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = LayoutInflater.from(getContext()).inflate(R.layout.main_fragment,container,false);
        recyclerView = view.findViewById(R.id.recycler_view_home);
        repository = new universities_repository(getActivity().getApplication());
        universities_list = new ArrayList<>();
        adapter = new universities_adapter(getContext(),universities_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        networkrequest();
        return view;
    }

    private void networkrequest() {
        api = retrofit_instance.getRetroClient().create(universities_api.class);
        Call<List<model>> call = api.getuniversities("India");
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                repository.insertuniversities(response.body());
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                Log.d("mainc",t.toString());
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mviewmodel = new ViewModelProvider(this).get(main_viewmodel.class);
        mviewmodel.getGetuniversities_list().observe(getViewLifecycleOwner(), new Observer<List<model>>() {
            @Override
            public void onChanged(List<model> list) {
                universities_list = list;
                adapter.setUniversities_list(list);
                Log.d("listc","onchanged:"+list);
            }
        });

    }

}
