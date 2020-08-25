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
    private static View.OnClickListener nZm;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView nZn;
    private TextView nZo;
    private AnimationImageView nZp;
    private TextView nZq;
    private View.OnClickListener nZr;

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
        this.nZn = (ImageView) findViewById(b.d.iv_empty);
        this.nZo = (TextView) findViewById(b.d.tv_desc);
        this.nZp = (AnimationImageView) findViewById(b.d.iv_loading);
        this.nZq = (TextView) findViewById(b.d.tv_button);
        this.nZn.setOnClickListener(this);
        this.nZo.setOnClickListener(this);
        this.nZq.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ap(View.OnClickListener onClickListener) {
        nZm = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (nZm != null) {
                    nZm.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.nZr != null) {
                    this.nZr.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.nZr = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Ns(int i) {
        if (this.nZp != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.nZp.setVisibility(0);
                    this.nZn.setVisibility(8);
                    this.nZo.setVisibility(8);
                    this.nZq.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.nZp.setVisibility(8);
                    this.nZn.setVisibility(0);
                    this.nZn.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.nZn.setClickable(true);
                    this.nZo.setVisibility(0);
                    this.nZo.setText(b.f.commonres_pagestatus_net_error);
                    this.nZq.setVisibility(0);
                    this.nZq.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.nZp.setVisibility(8);
                    this.nZn.setVisibility(0);
                    this.nZn.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.nZn.setClickable(true);
                    this.nZo.setVisibility(0);
                    this.nZo.setText(b.f.commonres_pagestatus_unknown);
                    this.nZq.setVisibility(0);
                    this.nZq.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.nZp.setVisibility(8);
                    this.nZn.setVisibility(0);
                    this.nZn.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.nZn.setClickable(true);
                    this.nZo.setVisibility(8);
                    this.nZq.setVisibility(0);
                    this.nZq.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.nZp.setVisibility(8);
                    this.nZn.setVisibility(0);
                    this.nZn.setImageResource(b.c.commonres_pagestatus_empty);
                    this.nZn.setClickable(true);
                    this.nZo.setVisibility(0);
                    this.nZo.setText(b.f.commonres_pagestatus_empty);
                    this.nZq.setVisibility(8);
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
