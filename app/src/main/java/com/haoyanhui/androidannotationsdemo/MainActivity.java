package com.haoyanhui.androidannotationsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.haoyanhui.androidannotationsdemo.adapter.InfoAdapter;
import com.haoyanhui.androidannotationsdemo.entity.MsgInfo;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @ViewById(R.id.btn_start_detail)
    Button mBtnStartDetail;
    @ViewById(R.id.btn_refresh_list)
    Button mBtnRefreshList;

    @ViewById(R.id.lv_data)
    ListView mLvData;

    @Bean
    InfoAdapter mInfoAdapter;

    @AfterViews
    void initViews() {
        // 初始化控件
        mBtnStartDetail.setText("button 1");
        mLvData.setAdapter(mInfoAdapter);
    }

    private List<MsgInfo> getMsgInfo(int size) {
        List<MsgInfo> dataList = new ArrayList<>();
        MsgInfo msgInfo = null;
        for (int i = size; i > 0; i--) {
            msgInfo = new MsgInfo();
            msgInfo.id = String.valueOf(i);
            msgInfo.age = i;
            msgInfo.name = "name_" + i;
            dataList.add(msgInfo);
        }
        return dataList;
    }

    @Click(R.id.btn_start_detail)
    void btnClick() {
        // 启动新的activity
//        DetailActivity_.intent(this).start();
        // 启动新的activity并将mInfoStr的值传递过去
        DetailActivity_.intent(this).mInfoStr("this is infoStr.").start();
    }

    @Click(R.id.btn_refresh_list)
    void refreshList() {
        Random random = new Random();
        int size = random.nextInt(30);
        mInfoAdapter.reloadList(getMsgInfo(size));
    }


}