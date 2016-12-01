package com.zyx.viewpagerfragment_12_1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyx.viewpagerfragment_12_1.R;

/**
 * Created by Administrator on 2016/12/1 0001.
 * Administrator  ZYX
 */
public class Fragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
             View view=inflater.inflate(R.layout.fragment1_item,container,false);

             return view;
    }
}
