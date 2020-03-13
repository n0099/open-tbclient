package com.kascend.chushou.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import tv.chushou.widget.a.b;
/* loaded from: classes5.dex */
public class EmptyLoadingView extends RelativeLayout implements View.OnClickListener {
    private static View.OnClickListener nhg;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView nhh;
    private TextView nhi;
    private AnimationImageView nhj;
    private TextView nhk;
    private View.OnClickListener nhl;

    public EmptyLoadingView(Context context) {
        this(context, null, 0);
    }

    public EmptyLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmptyLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 4;
        LayoutInflater.from(context.getApplicationContext()).inflate(b.e.commonres_empty_loading_view, (ViewGroup) this, true);
        this.nhh = (ImageView) findViewById(b.d.iv_empty);
        this.nhi = (TextView) findViewById(b.d.tv_desc);
        this.nhj = (AnimationImageView) findViewById(b.d.iv_loading);
        this.nhk = (TextView) findViewById(b.d.tv_button);
        this.nhh.setOnClickListener(this);
        this.nhi.setOnClickListener(this);
        this.nhk.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ai(View.OnClickListener onClickListener) {
        nhg = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (nhg != null) {
                    nhg.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.nhl != null) {
                    this.nhl.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.nhl = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Na(int i) {
        if (this.nhj != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.nhj.setVisibility(0);
                    this.nhh.setVisibility(8);
                    this.nhi.setVisibility(8);
                    this.nhk.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.nhj.setVisibility(8);
                    this.nhh.setVisibility(0);
                    this.nhh.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.nhh.setClickable(true);
                    this.nhi.setVisibility(0);
                    this.nhi.setText(b.f.commonres_pagestatus_net_error);
                    this.nhk.setVisibility(0);
                    this.nhk.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.nhj.setVisibility(8);
                    this.nhh.setVisibility(0);
                    this.nhh.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.nhh.setClickable(true);
                    this.nhi.setVisibility(0);
                    this.nhi.setText(b.f.commonres_pagestatus_unknown);
                    this.nhk.setVisibility(0);
                    this.nhk.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.nhj.setVisibility(8);
                    this.nhh.setVisibility(0);
                    this.nhh.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.nhh.setClickable(true);
                    this.nhi.setVisibility(8);
                    this.nhk.setVisibility(0);
                    this.nhk.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.nhj.setVisibility(8);
                    this.nhh.setVisibility(0);
                    this.nhh.setImageResource(b.c.commonres_pagestatus_empty);
                    this.nhh.setClickable(true);
                    this.nhi.setVisibility(0);
                    this.nhi.setText(b.f.commonres_pagestatus_empty);
                    this.nhk.setVisibility(8);
                    return;
                default:
                    this.mType = -1;
                    setVisibility(8);
                    return;
            }
        }
    }

    public int getType() {
        return this.mType;
    }
}
