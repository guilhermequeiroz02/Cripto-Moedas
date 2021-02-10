package com.example.pim4;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class adapter extends ArrayAdapter<CryptoActive> {

    private  static final String TAG = "adapter";

    private Context mContext;
    int mResource;

    public adapter(@NonNull Context context, int resource, @NonNull List<CryptoActive> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int id = getItem(position).id;
        String name = getItem(position).name;
        String symbol = getItem(position).symbol;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvCrypto = (TextView) convertView.findViewById(R.id.textView);
        TextView tvValor = (TextView) convertView.findViewById(R.id.textView2);

        return convertView;

    }
}
