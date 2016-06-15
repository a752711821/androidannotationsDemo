package com.haoyanhui.androidannotationsdemo.adapter.itemview;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haoyanhui.androidannotationsdemo.R;
import com.haoyanhui.androidannotationsdemo.entity.MsgInfo;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by haoyanhui on 16/6/12.
 */
@EViewGroup(R.layout.item_layout)
public class ItemInfo extends LinearLayout {

    private MsgInfo mMsgInfo;

    @ViewById(R.id.tv_id)
    TextView mTvID;
    @ViewById(R.id.tv_name)
    TextView mTvName;

    public ItemInfo(Context context) {
        super(context);
    }

    public void setData(MsgInfo info) {
        Log.d("hyh", "info name = " + info.name);
        this.mMsgInfo = info;

        mTvID.setText(info.id);
        mTvName.setText(info.name);
    }

}
