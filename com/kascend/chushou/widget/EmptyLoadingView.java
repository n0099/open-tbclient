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
    private static View.OnClickListener ngT;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView ngU;
    private TextView ngV;
    private AnimationImageView ngW;
    private TextView ngX;
    private View.OnClickListener ngY;

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
        this.ngU = (ImageView) findViewById(b.d.iv_empty);
        this.ngV = (TextView) findViewById(b.d.tv_desc);
        this.ngW = (AnimationImageView) findViewById(b.d.iv_loading);
        this.ngX = (TextView) findViewById(b.d.tv_button);
        this.ngU.setOnClickListener(this);
        this.ngV.setOnClickListener(this);
        this.ngX.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ai(View.OnClickListener onClickListener) {
        ngT = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (ngT != null) {
                    ngT.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.ngY != null) {
                    this.ngY.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.ngY = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Na(int i) {
        if (this.ngW != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.ngW.setVisibility(0);
                    this.ngU.setVisibility(8);
                    this.ngV.setVisibility(8);
                    this.ngX.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.ngW.setVisibility(8);
                    this.ngU.setVisibility(0);
                    this.ngU.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.ngU.setClickable(true);
                    this.ngV.setVisibility(0);
                    this.ngV.setText(b.f.commonres_pagestatus_net_error);
                    this.ngX.setVisibility(0);
                    this.ngX.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.ngW.setVisibility(8);
                    this.ngU.setVisibility(0);
                    this.ngU.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.ngU.setClickable(true);
                    this.ngV.setVisibility(0);
                    this.ngV.setText(b.f.commonres_pagestatus_unknown);
                    this.ngX.setVisibility(0);
                    this.ngX.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.ngW.setVisibility(8);
                    this.ngU.setVisibility(0);
                    this.ngU.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.ngU.setClickable(true);
                    this.ngV.setVisibility(8);
                    this.ngX.setVisibility(0);
                    this.ngX.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.ngW.setVisibility(8);
                    this.ngU.setVisibility(0);
                    this.ngU.setImageResource(b.c.commonres_pagestatus_empty);
                    this.ngU.setClickable(true);
                    this.ngV.setVisibility(0);
                    this.ngV.setText(b.f.commonres_pagestatus_empty);
                    this.ngX.setVisibility(8);
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
