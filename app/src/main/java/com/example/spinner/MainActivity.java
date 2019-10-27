package com.example.spinner;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spiners=findViewById(R.id.spinner);
        ArrayList<itemData> modules =new ArrayList<itemData>();
        modules.add(new itemData("wiko","rainbow",R.drawable.a));
        modules.add(new itemData("samsung","galaxy",R.drawable.b));
        modules.add(new itemData("Sony","XZ1",R.drawable.c));
        modules.add(new itemData("Hwuayei","Y6",R.drawable.d));
        modules.add(new itemData("iphone","s6",R.drawable.e));
        SpinnerAdapter adapter1=new SpinnerAdapter(this,R.layout.spinnerrow,modules);
        spiners.setAdapter(adapter1);
    }
    public class SpinnerAdapter extends ArrayAdapter<itemData> {
        Activity context;
        ArrayList<itemData> list;
        LayoutInflater inflater;

        public SpinnerAdapter(Activity context, int id, ArrayList<itemData> list) {
            super(context, id, list);
            this.list = list;
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView=inflater.inflate(R.layout.spinnerrow,parent,false);
            ImageView img= itemView.findViewById(R.id.imageView);
            TextView titre=itemView.findViewById(R.id.textView);
            TextView desc=itemView.findViewById(R.id.textView2);
            itemData rowid=list.get(position);
            titre.setText(rowid.name);
            desc.setText(rowid.description);
            img.setImageResource(rowid.image);
            return itemView;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getView(position, convertView, parent);
        }
    }
}

