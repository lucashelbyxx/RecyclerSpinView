package com.example.recyclerspinview;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spinview.SpinViewLayoutManger;
import com.example.spinview.RecyclerSpinView;


/**
 * 3D 旋转
 */
public class SpinView3DActivity extends AppCompatActivity implements Adapter.onItemClick {

    private RecyclerSpinView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_spinflow);
        initList();
    }

    private void initList() {
        mList = findViewById(R.id.list);
        mList.set3DItem(true); //3D 滚动
        mList.setLoop(); //循环滚动
        mList.setAdapter(new Adapter(this, this, true));
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