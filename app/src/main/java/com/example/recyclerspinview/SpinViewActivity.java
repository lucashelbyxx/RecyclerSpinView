package com.example.recyclerspinview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spinview.SpinViewLayoutManger;
import com.example.spinview.RecyclerSpinView;


public class SpinViewActivity extends AppCompatActivity implements Adapter.onItemClick {

    private RecyclerSpinView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_spinflow);
        initList();
    }

    private void initList() {
        mList = findViewById(R.id.list);
//        mList.setFlatFlow(true); //平面滚动
//        mList.setGreyItem(true); //设置灰度渐变
//        mList.setAlphaItem(true); //设置半透渐变
        mList.setLoop(); //循环滚动，注：循环滚动模式暂不支持平滑滚动
        mList.setAdapter(new Adapter(this, this, false));
        mList.setOnItemSelectedListener(new SpinViewLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                ((TextView)findViewById(R.id.index)).setText((position+1)+"/"+mList.getLayoutManager().getItemCount());
            }
        });
    }

    @Override
    public void clickItem(int pos) {
        mList.smoothScrollToPosition(pos);
    }
}
