package com.example.a2lavea02.fileio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import android.app.AlertDialog;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu (Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()== R.id.Save)
        {
        try
        {
            PrintWriter pw = new PrintWriter(new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath() + "/textedit.txt"));
            EditText et = (EditText)findViewById(R.id.et1);
            pw.println(et.getText().toString());
            pw.close();
        }
        catch(IOException e)
            {
                new AlertDialog.Builder(this).setMessage("Error Loading: " + e).setPositiveButton("Dismiss", null).show();
            }
        }
        else if (item.getItemId()== R.id.Load)
        {
            try {
                FileReader fr = new FileReader(Environment.getExternalStorageDirectory().getAbsolutePath() + "/textedit.txt");
                BufferedReader reader = new BufferedReader(fr);
                EditText et = (EditText)findViewById(R.id.et1);
                String line = "";
                while((line = reader.readLine()) != null)
                {
                    et.append(line+"\n");
                }
            }
            catch (IOException e)
            {
                new AlertDialog.Builder(this).setMessage("Error Loading: " + e).setPositiveButton("Dismiss", null).show();
            }
        }
    return true;
    }


}
