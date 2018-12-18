package com.example.diogo.micro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = findViewById(R.id.mainview);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void square(View v) { myView.square(); }

    public void circle(View v) { myView.circle(); }

    public void line(View v) { myView.line(); }

    public void poli(View v) { myView.poli(); }

    public void black(View v) {
        myView.black();
    }

    public void red(View v) {
        myView.red();
    }

    public void green(View v) {
        myView.green();
    }

    public void orange(View v) {
        myView.orange();
    }

    public void purple(View v) {
        myView.purple();
    }

    public void blue(View v) {
        myView.blue();
    }

    public void reset(View v) {
        myView.reset();
    }
}
