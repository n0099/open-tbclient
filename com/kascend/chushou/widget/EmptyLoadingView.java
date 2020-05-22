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
    private static View.OnClickListener mZG;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView mZH;
    private TextView mZI;
    private AnimationImageView mZJ;
    private TextView mZK;
    private View.OnClickListener mZL;

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
        this.mZH = (ImageView) findViewById(b.d.iv_empty);
        this.mZI = (TextView) findViewById(b.d.tv_desc);
        this.mZJ = (AnimationImageView) findViewById(b.d.iv_loading);
        this.mZK = (TextView) findViewById(b.d.tv_button);
        this.mZH.setOnClickListener(this);
        this.mZI.setOnClickListener(this);
        this.mZK.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void al(View.OnClickListener onClickListener) {
        mZG = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (mZG != null) {
                    mZG.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.mZL != null) {
                    this.mZL.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.mZL = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Jl(int i) {
        if (this.mZJ != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.mZJ.setVisibility(0);
                    this.mZH.setVisibility(8);
                    this.mZI.setVisibility(8);
                    this.mZK.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.mZJ.setVisibility(8);
                    this.mZH.setVisibility(0);
                    this.mZH.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.mZH.setClickable(true);
                    this.mZI.setVisibility(0);
                    this.mZI.setText(b.f.commonres_pagestatus_net_error);
                    this.mZK.setVisibility(0);
                    this.mZK.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.mZJ.setVisibility(8);
                    this.mZH.setVisibility(0);
                    this.mZH.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.mZH.setClickable(true);
                    this.mZI.setVisibility(0);
                    this.mZI.setText(b.f.commonres_pagestatus_unknown);
                    this.mZK.setVisibility(0);
                    this.mZK.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.mZJ.setVisibility(8);
                    this.mZH.setVisibility(0);
                    this.mZH.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.mZH.setClickable(true);
                    this.mZI.setVisibility(8);
                    this.mZK.setVisibility(0);
                    this.mZK.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.mZJ.setVisibility(8);
                    this.mZH.setVisibility(0);
                    this.mZH.setImageResource(b.c.commonres_pagestatus_empty);
                    this.mZH.setClickable(true);
                    this.mZI.setVisibility(0);
                    this.mZI.setText(b.f.commonres_pagestatus_empty);
                    this.mZK.setVisibility(8);
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
