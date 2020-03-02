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
    private static View.OnClickListener ngV;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView ngW;
    private TextView ngX;
    private AnimationImageView ngY;
    private TextView ngZ;
    private View.OnClickListener nha;

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
        this.ngW = (ImageView) findViewById(b.d.iv_empty);
        this.ngX = (TextView) findViewById(b.d.tv_desc);
        this.ngY = (AnimationImageView) findViewById(b.d.iv_loading);
        this.ngZ = (TextView) findViewById(b.d.tv_button);
        this.ngW.setOnClickListener(this);
        this.ngX.setOnClickListener(this);
        this.ngZ.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ai(View.OnClickListener onClickListener) {
        ngV = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (ngV != null) {
                    ngV.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.nha != null) {
                    this.nha.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.nha = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Na(int i) {
        if (this.ngY != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.ngY.setVisibility(0);
                    this.ngW.setVisibility(8);
                    this.ngX.setVisibility(8);
                    this.ngZ.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.ngY.setVisibility(8);
                    this.ngW.setVisibility(0);
                    this.ngW.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.ngW.setClickable(true);
                    this.ngX.setVisibility(0);
                    this.ngX.setText(b.f.commonres_pagestatus_net_error);
                    this.ngZ.setVisibility(0);
                    this.ngZ.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.ngY.setVisibility(8);
                    this.ngW.setVisibility(0);
                    this.ngW.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.ngW.setClickable(true);
                    this.ngX.setVisibility(0);
                    this.ngX.setText(b.f.commonres_pagestatus_unknown);
                    this.ngZ.setVisibility(0);
                    this.ngZ.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.ngY.setVisibility(8);
                    this.ngW.setVisibility(0);
                    this.ngW.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.ngW.setClickable(true);
                    this.ngX.setVisibility(8);
                    this.ngZ.setVisibility(0);
                    this.ngZ.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.ngY.setVisibility(8);
                    this.ngW.setVisibility(0);
                    this.ngW.setImageResource(b.c.commonres_pagestatus_empty);
                    this.ngW.setClickable(true);
                    this.ngX.setVisibility(0);
                    this.ngX.setText(b.f.commonres_pagestatus_empty);
                    this.ngZ.setVisibility(8);
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
