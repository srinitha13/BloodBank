package com.example.bloodbank.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.bloodbank.Adapters.RequestAdapter;
import com.example.bloodbank.DataModels.RequestDataModel;
import com.example.bloodbank.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<RequestDataModel> requestDatamodels;
    private RequestAdapter requestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView make_request_button=findViewById(R.id.make_request_button);
        make_request_button.OnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MakeRequestActivity.class));

            }
        });


        requestDatamodels=new ArrayList<>();
        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item){
                if(item.getItemId()==R.id.search_button){
                    startActivity(new Intent(MainActivity.this,SearchActivity.class));
                }
                return false;
            }
        });

        recyclerView=findViewById(R.id.recyclerview);
        LayoutManager layoutManager=new LayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
       requestAdapter =new RequestAdapter(requestDatamodels,this);
       recyclerView.setAdapter(requestAdapter);
       populateHomePage();
    }
    private void populateHomePage(){
        RequestDataModel requestDataModel=new RequestDataModel("Meaasage:-","");
        requestDatamodels.add(requestDataModel);
        requestDatamodels.add(requestDataModel);
        requestDatamodels.add(requestDataModel);
        requestDatamodels.add(requestDataModel);
        requestDatamodels.add(requestDataModel);
        requestAdapter.notifyDataSetChanged();

    }

}
