package com.thecodingbot.databasebasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textInput;
    TextView outputText;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInput= (EditText) findViewById(R.id.input);
        outputText= (TextView) findViewById(R.id.text);
        dbHandler= new MyDBHandler(this, null, null, 1);
        printDataBase();
    }

    public void printDataBase(){
        String dbString=dbHandler.databaseToString();
        outputText.setText(dbString);
        textInput.setText("");
    }

    public void addButtonClicked(View view){
        Products products= new Products(textInput.getText().toString());
        dbHandler.addProduct(products);
        printDataBase();
    }

    public void deleteButtonClicked(View view){
        String delText=textInput.getText().toString();
        dbHandler.deleteProduct(delText);
        printDataBase();
    }
}
