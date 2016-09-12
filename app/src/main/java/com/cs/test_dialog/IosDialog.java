package com.cs.test_dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by chenshuai on 2016/9/12.
 */

    public class IosDialog extends Dialog implements View.OnClickListener {

        private Context mContext;
        private OnClickListener mOnClickListener1;// 按钮1的单击监听事件
        private OnClickListener mOnClickListener2;// 按钮2的单击监听事件

        private TextView title;
        private TextView content;
        private Button bt_no;
        private Button bt_ys;


        public IosDialog(Context context) {
            super(context, R.style.Theme_Light_FullScreenDialogAct);
            mContext = context;
            Display dm = getWindow().getWindowManager().getDefaultDisplay();
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams((int) (dm.getWidth() * 0.75),
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            View view = LayoutInflater.from(context).inflate(
                    R.layout.dialog_ios_layout, null);
//        iosDialog = this;
            setContentView(view, lp);
            initViews();
            initEvents();
            setCancelable(true);
            setCanceledOnTouchOutside(true);
        }

        private void initEvents() {

            bt_no.setOnClickListener(this);
            bt_ys.setOnClickListener(this);

        }

        private void initViews() {

            title = (TextView) findViewById(R.id.title);
            content = (TextView) findViewById(R.id.content);

            bt_no = (Button) findViewById(R.id.bt_no);
            bt_ys = (Button) findViewById(R.id.bt_ys);

        }

        public void setTitle(CharSequence text) {
            if (text != null) {
                title.setText(text);
            }
        }

        public void setMessage(CharSequence text) {
            if (text != null) {
                content.setText(text);
            }
        }


        @Override
        public void onClick(View v) {
            int i = v.getId();
            if (i == R.id.bt_no) {
                if (mOnClickListener1 != null) {
                    mOnClickListener1.onClick(IosDialog.this, 0);
                }
            } else if (i == R.id.bt_ys) {
                mOnClickListener2.onClick(IosDialog.this, 1);
            }

        }

        public void setButton(CharSequence text1, OnClickListener onClicklistener1,
                              CharSequence text2, OnClickListener onClicklistener2) {

            bt_no.setText(text1);
            bt_ys.setText(text2);
            mOnClickListener1 = onClicklistener1;
            mOnClickListener2 = onClicklistener2;

        }


    }


