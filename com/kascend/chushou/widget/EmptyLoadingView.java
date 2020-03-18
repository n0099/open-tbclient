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
    private static View.OnClickListener niU;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView niV;
    private TextView niW;
    private AnimationImageView niX;
    private TextView niY;
    private View.OnClickListener niZ;

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
        this.niV = (ImageView) findViewById(b.d.iv_empty);
        this.niW = (TextView) findViewById(b.d.tv_desc);
        this.niX = (AnimationImageView) findViewById(b.d.iv_loading);
        this.niY = (TextView) findViewById(b.d.tv_button);
        this.niV.setOnClickListener(this);
        this.niW.setOnClickListener(this);
        this.niY.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ai(View.OnClickListener onClickListener) {
        niU = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (niU != null) {
                    niU.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.niZ != null) {
                    this.niZ.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.niZ = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Ng(int i) {
        if (this.niX != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.niX.setVisibility(0);
                    this.niV.setVisibility(8);
                    this.niW.setVisibility(8);
                    this.niY.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.niX.setVisibility(8);
                    this.niV.setVisibility(0);
                    this.niV.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.niV.setClickable(true);
                    this.niW.setVisibility(0);
                    this.niW.setText(b.f.commonres_pagestatus_net_error);
                    this.niY.setVisibility(0);
                    this.niY.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.niX.setVisibility(8);
                    this.niV.setVisibility(0);
                    this.niV.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.niV.setClickable(true);
                    this.niW.setVisibility(0);
                    this.niW.setText(b.f.commonres_pagestatus_unknown);
                    this.niY.setVisibility(0);
                    this.niY.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.niX.setVisibility(8);
                    this.niV.setVisibility(0);
                    this.niV.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.niV.setClickable(true);
                    this.niW.setVisibility(8);
                    this.niY.setVisibility(0);
                    this.niY.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.niX.setVisibility(8);
                    this.niV.setVisibility(0);
                    this.niV.setImageResource(b.c.commonres_pagestatus_empty);
                    this.niV.setClickable(true);
                    this.niW.setVisibility(0);
                    this.niW.setText(b.f.commonres_pagestatus_empty);
                    this.niY.setVisibility(8);
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
