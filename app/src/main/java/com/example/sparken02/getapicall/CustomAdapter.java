package com.example.sparken02.getapicall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by sparken02 on 12/6/17.
 */

public class CustomAdapter extends BaseAdapter {

    Context mContext;
    List<Response.ContactsBean> myresponseobj;
    LayoutInflater inflater;

    public CustomAdapter(Context mContext, List<Response.ContactsBean> myresponseobj) {
        this.mContext = mContext;
        this.myresponseobj = myresponseobj;
    }

    @Override
    public int getCount() {
        return myresponseobj.size();
    }

    @Override
    public Object getItem(int position) {
        return myresponseobj.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.each_list_item,parent,false);
        Response.ContactsBean item = (Response.ContactsBean)getItem(position);
        TextView txt1,txt2,txt3;
        txt1 = (TextView)convertView.findViewById(R.id.txt1);
        txt2 = (TextView)convertView.findViewById(R.id.txt2);
        txt3 = (TextView)convertView.findViewById(R.id.txt3);

        txt1.setText(item.getName());
        txt2.setText(item.getEmail());
        txt3.setText(item.getPhone().getMobile());




        return convertView;
    }
}
