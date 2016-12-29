package com.xzw.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.xzw.ui.view.MarqueeFactory;

public class NoticeMF extends MarqueeFactory<TextView, String> {
    private LayoutInflater inflater;

    public NoticeMF(Context mContext) {
        super(mContext);
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public TextView generateMarqueeItemView(String data) {
        // view
        TextView mView = (TextView) inflater.inflate(R.layout.notice_item, null);
        mView.setText(data);
        return mView;
    }
}