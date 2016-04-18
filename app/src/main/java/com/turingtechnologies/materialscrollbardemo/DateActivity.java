package com.turingtechnologies.materialscrollbardemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.turingtechnologies.materialscrollbar.DateAndTimeIndicator;
import com.turingtechnologies.materialscrollbar.MaterialScrollBarListener;
import com.turingtechnologies.materialscrollbar.TouchScrollBar;

public class DateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new DemoAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        new TouchScrollBar(this, recyclerView, false)
                .addIndicator(new DateAndTimeIndicator(this, false, true, true, true), 24)
                .setHandleColour("#808080")
                .setIndicatorColour("#FF8080")
                .setHandleColour("#0000FF")
                .setBarColour("#808080")
                .setBarPadding(12, 12)
                .setBarThickness(2, 4)
                .setAutoHide(false)
                .setHandleHeight(32)
                .setEventsListener(new MaterialScrollBarListener() {
                    @Override
                    public void onMaterialScrollBarIndicatorShows() {
                        ((FloatingActionButton)findViewById(R.id.fab)).hide();
                    }

                    @Override
                    public void onMaterialScrollBarIndicatorHides() {
                        ((FloatingActionButton)findViewById(R.id.fab)).show();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_date, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_toName) {
            Intent i = new Intent(this, NameActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
