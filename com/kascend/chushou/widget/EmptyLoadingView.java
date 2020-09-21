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
/* loaded from: classes6.dex */
public class EmptyLoadingView extends RelativeLayout implements View.OnClickListener {
    private static View.OnClickListener ojs;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView ojt;
    private TextView oju;
    private AnimationImageView ojv;
    private TextView ojw;
    private View.OnClickListener ojx;

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
        this.ojt = (ImageView) findViewById(b.d.iv_empty);
        this.oju = (TextView) findViewById(b.d.tv_desc);
        this.ojv = (AnimationImageView) findViewById(b.d.iv_loading);
        this.ojw = (TextView) findViewById(b.d.tv_button);
        this.ojt.setOnClickListener(this);
        this.oju.setOnClickListener(this);
        this.ojw.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ap(View.OnClickListener onClickListener) {
        ojs = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (ojs != null) {
                    ojs.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.ojx != null) {
                    this.ojx.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.ojx = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void NX(int i) {
        if (this.ojv != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.ojv.setVisibility(0);
                    this.ojt.setVisibility(8);
                    this.oju.setVisibility(8);
                    this.ojw.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.ojv.setVisibility(8);
                    this.ojt.setVisibility(0);
                    this.ojt.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.ojt.setClickable(true);
                    this.oju.setVisibility(0);
                    this.oju.setText(b.f.commonres_pagestatus_net_error);
                    this.ojw.setVisibility(0);
                    this.ojw.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.ojv.setVisibility(8);
                    this.ojt.setVisibility(0);
                    this.ojt.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.ojt.setClickable(true);
                    this.oju.setVisibility(0);
                    this.oju.setText(b.f.commonres_pagestatus_unknown);
                    this.ojw.setVisibility(0);
                    this.ojw.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.ojv.setVisibility(8);
                    this.ojt.setVisibility(0);
                    this.ojt.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.ojt.setClickable(true);
                    this.oju.setVisibility(8);
                    this.ojw.setVisibility(0);
                    this.ojw.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.ojv.setVisibility(8);
                    this.ojt.setVisibility(0);
                    this.ojt.setImageResource(b.c.commonres_pagestatus_empty);
                    this.ojt.setClickable(true);
                    this.oju.setVisibility(0);
                    this.oju.setText(b.f.commonres_pagestatus_empty);
                    this.ojw.setVisibility(8);
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
