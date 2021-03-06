package br.com.trmasolucoes.testelocationapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    //Acesso a SH1 no linux
    //keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android

    private ListView listView;
    private String[] activities = {"LastLocationActivity",
                                    "UpdateLocationActivity",
                                    "AddressLocationActivity",
                                    "TrackingActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activities);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;

        switch(position){
            case 0:
                intent = new Intent(this, LastLocationActivity.class);
                break;
            case 1:
                intent = new Intent(this, UpdateLocationActivity.class);
                break;
            case 2:
                intent = new Intent(this, AddressLocationActivity.class);
                break;
            case 3:
                intent = new Intent(this, TrackingActivity.class);
                break;
        }

        startActivity(intent);
    }
}
