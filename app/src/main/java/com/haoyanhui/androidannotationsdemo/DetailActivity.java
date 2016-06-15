package com.haoyanhui.androidannotationsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_detail)
public class DetailActivity extends Activity {

    @Extra
    String mInfoStr;

    @ViewById(R.id.tv_info)
    TextView mTvShowInfo;

    @AfterViews
    void initViews() {
        if (!TextUtils.isEmpty(mInfoStr)) {
            mTvShowInfo.setText(mInfoStr);
        } else {
            mTvShowInfo.setText("mInfoStr is empty!");
        }
    }

}
