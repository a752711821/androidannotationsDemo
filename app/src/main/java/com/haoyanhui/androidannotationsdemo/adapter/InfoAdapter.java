package com.haoyanhui.androidannotationsdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.haoyanhui.androidannotationsdemo.adapter.itemview.ItemInfo;
import com.haoyanhui.androidannotationsdemo.adapter.itemview.ItemInfo_;
import com.haoyanhui.androidannotationsdemo.entity.MsgInfo;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haoyanhui on 16/6/12.
 * adapter 的使用
 */
@EBean
public class InfoAdapter extends BaseAdapter {

    @RootContext
    Context mContext;

    private List<MsgInfo> mMsgInfoList = new ArrayList<>();

    public void reloadList(List<MsgInfo> list) {
        Log.d("hyh", "list size = " + list.size());
        if (list != null) {
            mMsgInfoList.clear();
            mMsgInfoList.addAll(list);
        } else {
            mMsgInfoList.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mMsgInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMsgInfoList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ItemInfo itemInfo;
        if (view == null) {
            itemInfo = ItemInfo_.build(mContext);
        } else {
            itemInfo = (ItemInfo) view;
        }
        itemInfo.setData(mMsgInfoList.get(position));
        return itemInfo; //  todo 注意 返回值
    }
}
