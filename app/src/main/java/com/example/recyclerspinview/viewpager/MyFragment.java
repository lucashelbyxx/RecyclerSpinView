package com.example.recyclerspinview.viewpager;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recyclerspinview.Adapter;
import com.example.recyclerspinview.R;
import com.example.spinview.SpinViewLayoutManger;
import com.example.spinview.RecyclerSpinView;


public class MyFragment extends Fragment {
    private RecyclerSpinView mList;
    private TextView mIndex;


    public static Fragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        initList(rootView);
        return rootView;
    }

    private void initList(View rootView) {
        mList = (RecyclerSpinView) rootView.findViewById(R.id.list);
        mIndex = ((TextView)rootView.findViewById(R.id.index));
//        mList.setFlatFlow(true); //平面滚动
        mList.setGreyItem(true); //设置灰度渐变
//        mList.setAlphaItem(true); //设置半透渐变
        mList.setAdapter(new Adapter(getActivity(), false));
        mList.setOnItemSelectedListener(new SpinViewLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                mIndex.setText((position+1)+"/"+mList.getLayoutManager().getItemCount());
            }
        });
    }
}
