package com.example.todoappexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/*
Compile time -> handled while the code is building
Runtime -> handled while the code is running

    OOP -> Object Orientated Programming
    polymorphism ->
                Taking many forms
                overloading ->
                        compile time
                        two or more methods of the same name, but different parameters
                overriding ->
                        runtime
                        pulling methods from teh parent class/interface
    Abstraction -> only showing the needed functionality
    Inheritance -> one class derives form another class.
    Encapsulation ->
                hiding the data,
                variables are private
                methods are public
                getters and setters

    Visibility Modifiers
    -public -> everything can see
    -private -> only visible within the class
    -protected -> only visible to its children

 */


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etInput;
    Button btnSubmit;
    ListView lvTodos;
    ImageButton ibtnPlus;
    TextView tvMiddleText;

    //etInput needs an adapter to convert character sequence to string
    ArrayAdapter<String> lvAdapter;
    String displayText;
    final String KEY =  "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_layout);

        etInput = findViewById(R.id.et_Input);
        btnSubmit = findViewById(R.id.btn_Submit);
        lvTodos = findViewById(R.id.lv_Todos);
        ibtnPlus = findViewById(R.id.ibtn_plus);
        tvMiddleText = findViewById(R.id.tv_middle_text);

        if(savedInstanceState != null){
            displayText = savedInstanceState.getString(KEY);
            tvMiddleText.setText(displayText);
        }

        //context and the ID of the layout
        //context -> current state of our application
        lvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvTodos.setAdapter(lvAdapter);
        btnSubmit.setOnClickListener(this);

        ibtnPlus.setOnClickListener(view -> {
            tvMiddleText.setText(etInput.getText().toString());
            etInput.getText().clear();
        });

    }

    @Override
    public void onClick(View view) {
        String newInput = etInput.getText().toString();
        // ==, ===
        // == -> checks the value of 2 values
        // === -> checks the references or address of 2 values

        if(newInput.equals("")){
            Toast.makeText(this,"Input cannot be empty!!",Toast.LENGTH_LONG).show();
        }else{
            addNewTodo(newInput);
        }
    }

    private void addNewTodo(String input) {
        lvAdapter.add(input);
        etInput.getText().clear();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //not lifecycle aware when activity is destroyed
        outState.putString(KEY, tvMiddleText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        displayText = savedInstanceState.getString(KEY);
    }
}