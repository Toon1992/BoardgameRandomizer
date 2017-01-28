package com.example.toon.boardgamerandomizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toon.boardgamerandomizer.Views.Fragments.BoardGameViewFragment;
import com.example.toon.boardgamerandomizer.Views.UIUtiles.UIUtiles;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tvUserName)
    EditText teUserName;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnSearch)
    public void onSearch(){
        String text = teUserName.getText().toString();

        if(text.trim().isEmpty()){
            UIUtiles.makeToast(this,R.string.errorSearch,Toast.LENGTH_SHORT);
        } else {
            initializeFragment(text);
        }
    }

    private void initializeFragment(String user) {
        Bundle args = new Bundle();
        args.putString("user", user);
        BoardGameViewFragment fragment = new BoardGameViewFragment();
        fragment.setArguments(args);

        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment_Container,fragment).commit();
    }
}
