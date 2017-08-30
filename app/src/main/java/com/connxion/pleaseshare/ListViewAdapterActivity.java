package com.connxion.pleaseshare;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sbonelo Sthole on 2017/08/26.
 */

public class ListViewAdapterActivity extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;

    ListViewAdapterActivity(Context context, List<RowItem> rowItems){
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount(){
        return rowItems.size();
    }

    @Override
    public Object getItem(int position){
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position){
        return rowItems.indexOf(getItem(position));
    }

    private class ViewHolder {
        ImageView icon;
        TextView item_label;
        TextView files_count;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = mInflater.inflate(R.layout.per_item_list, null);
            holder = new ViewHolder();
            holder.files_count = convertView.findViewById(R.id.files_count);
            holder.icon = convertView.findViewById(R.id.icon);
            holder.item_label = convertView.findViewById(R.id.item_label);

            RowItem row_pos = rowItems.get(position);

            holder.icon.setImageResource(row_pos.getIcons());
            holder.item_label.setText(row_pos.getSendOptions());
            holder.files_count.setText(row_pos.getCount_str());
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}