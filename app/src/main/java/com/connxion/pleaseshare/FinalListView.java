package com.connxion.pleaseshare;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sbonelo Sthole on 2017/08/26.
 */


public class FinalListView extends Activity implements AdapterView.OnItemClickListener {
    String [] item_label;
    TypedArray icons;
    String [] count;

    List<RowItem> rowItems;
    ListView myListView;
    public FinalListView(){}

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_send);
        rowItems = new ArrayList<>();
        item_label = getResources().getStringArray(R.array.send_options);
        icons = getResources().obtainTypedArray(R.array.icons);
        count = getResources().getStringArray(R.array.count);

        for (int i = 0; i < item_label.length; i++){
            RowItem item = new RowItem(item_label[i], icons.getResourceId(i, -1), count[i]);
            rowItems.add(item);
        }

        myListView = findViewById(R.id.list);
        ListViewAdapterActivity adapterActivity = new ListViewAdapterActivity(this, rowItems);
        myListView.setAdapter(adapterActivity);
        myListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String label_name = rowItems.get(position).getSendOptions();
        Toast.makeText(getApplicationContext(), "" + label_name, Toast.LENGTH_LONG).show();
    }
}