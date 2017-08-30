package com.connxion.pleaseshare;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SendActivity extends Fragment implements AdapterView.OnItemClickListener {
	String[]   item_label;
	TypedArray icons;
	String[]   count;

	List<RowItem> rowItems;
	ListView      myListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_send, container, false);
		rowItems = new ArrayList<>();
		item_label = getResources().getStringArray(R.array.send_options);
		icons = getResources().obtainTypedArray(R.array.icons);
		count = getResources().getStringArray(R.array.count);

		for (int i = 0; i < item_label.length; i++) {
			RowItem item = new RowItem(item_label[i], icons.getResourceId(i, -1), count[i]);
			rowItems.add(item);
		}

		myListView = view.findViewById(R.id.list);
		ListViewAdapterActivity adapterActivity = new ListViewAdapterActivity(getContext(), rowItems);
		myListView.setAdapter(adapterActivity);
		myListView.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		String label_name = rowItems.get(position).getSendOptions();
		Toast.makeText(getContext(), "" + label_name, Toast.LENGTH_LONG).show();
	}
}