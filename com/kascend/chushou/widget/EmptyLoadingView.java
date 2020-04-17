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
    private static View.OnClickListener mFB;
    private ImageView mFC;
    private TextView mFD;
    private AnimationImageView mFE;
    private TextView mFF;
    private View.OnClickListener mFG;
    private View.OnClickListener mLoginListener;
    private int mType;

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
        this.mFC = (ImageView) findViewById(b.d.iv_empty);
        this.mFD = (TextView) findViewById(b.d.tv_desc);
        this.mFE = (AnimationImageView) findViewById(b.d.iv_loading);
        this.mFF = (TextView) findViewById(b.d.tv_button);
        this.mFC.setOnClickListener(this);
        this.mFD.setOnClickListener(this);
        this.mFF.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void al(View.OnClickListener onClickListener) {
        mFB = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (mFB != null) {
                    mFB.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.mFG != null) {
                    this.mFG.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.mFG = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void IA(int i) {
        if (this.mFE != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.mFE.setVisibility(0);
                    this.mFC.setVisibility(8);
                    this.mFD.setVisibility(8);
                    this.mFF.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.mFE.setVisibility(8);
                    this.mFC.setVisibility(0);
                    this.mFC.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.mFC.setClickable(true);
                    this.mFD.setVisibility(0);
                    this.mFD.setText(b.f.commonres_pagestatus_net_error);
                    this.mFF.setVisibility(0);
                    this.mFF.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.mFE.setVisibility(8);
                    this.mFC.setVisibility(0);
                    this.mFC.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.mFC.setClickable(true);
                    this.mFD.setVisibility(0);
                    this.mFD.setText(b.f.commonres_pagestatus_unknown);
                    this.mFF.setVisibility(0);
                    this.mFF.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.mFE.setVisibility(8);
                    this.mFC.setVisibility(0);
                    this.mFC.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.mFC.setClickable(true);
                    this.mFD.setVisibility(8);
                    this.mFF.setVisibility(0);
                    this.mFF.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.mFE.setVisibility(8);
                    this.mFC.setVisibility(0);
                    this.mFC.setImageResource(b.c.commonres_pagestatus_empty);
                    this.mFC.setClickable(true);
                    this.mFD.setVisibility(0);
                    this.mFD.setText(b.f.commonres_pagestatus_empty);
                    this.mFF.setVisibility(8);
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
