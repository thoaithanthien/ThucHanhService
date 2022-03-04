package com.example.thuchanhservice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PhamThoai_AdapterGV extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<PhamThoai_GiaoVien> giaoViensList;

    public PhamThoai_AdapterGV(MainActivity context, int layout, List<PhamThoai_GiaoVien> nhanVienList) {
        this.context = context;
        this.layout = layout;
        this.giaoViensList = nhanVienList;
    }

    @Override
    public int getCount() {
        return giaoViensList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView tvMaGV, tvTenGV, tvGT, tvDiachi, tvSDT;
    }
    // Tim kiem
    public void filterSP(ArrayList<PhamThoai_GiaoVien> filterList){
        giaoViensList = filterList;
        notifyDataSetChanged();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.tvMaGV = (TextView) view.findViewById(R.id.tv_MaGV);
            holder.tvTenGV = (TextView) view.findViewById(R.id.tv_TenGV);
            holder.tvGT = (TextView) view.findViewById(R.id.tv_GT);
            holder.tvDiachi = (TextView) view.findViewById(R.id.tv_Diachi);
            holder.tvSDT = (TextView) view.findViewById(R.id.tv_SDT);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();

        }

        PhamThoai_GiaoVien giaoVien = giaoViensList.get(i);
        holder.tvMaGV.setText("ID:" + giaoVien.getIdGV());
        holder.tvTenGV.setText(giaoVien.getTenGV());
        holder.tvGT.setText(giaoVien.getGT());
        holder.tvDiachi.setText(giaoVien.getDiachi());
        holder.tvSDT.setText(giaoVien.getSDT());
        return view;
    }
}