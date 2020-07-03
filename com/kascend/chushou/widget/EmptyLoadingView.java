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
    private static View.OnClickListener nwH;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView nwI;
    private TextView nwJ;
    private AnimationImageView nwK;
    private TextView nwL;
    private View.OnClickListener nwM;

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
        this.nwI = (ImageView) findViewById(b.d.iv_empty);
        this.nwJ = (TextView) findViewById(b.d.tv_desc);
        this.nwK = (AnimationImageView) findViewById(b.d.iv_loading);
        this.nwL = (TextView) findViewById(b.d.tv_button);
        this.nwI.setOnClickListener(this);
        this.nwJ.setOnClickListener(this);
        this.nwL.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void an(View.OnClickListener onClickListener) {
        nwH = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (nwH != null) {
                    nwH.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.nwM != null) {
                    this.nwM.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.nwM = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Ku(int i) {
        if (this.nwK != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.nwK.setVisibility(0);
                    this.nwI.setVisibility(8);
                    this.nwJ.setVisibility(8);
                    this.nwL.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.nwK.setVisibility(8);
                    this.nwI.setVisibility(0);
                    this.nwI.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.nwI.setClickable(true);
                    this.nwJ.setVisibility(0);
                    this.nwJ.setText(b.f.commonres_pagestatus_net_error);
                    this.nwL.setVisibility(0);
                    this.nwL.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.nwK.setVisibility(8);
                    this.nwI.setVisibility(0);
                    this.nwI.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.nwI.setClickable(true);
                    this.nwJ.setVisibility(0);
                    this.nwJ.setText(b.f.commonres_pagestatus_unknown);
                    this.nwL.setVisibility(0);
                    this.nwL.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.nwK.setVisibility(8);
                    this.nwI.setVisibility(0);
                    this.nwI.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.nwI.setClickable(true);
                    this.nwJ.setVisibility(8);
                    this.nwL.setVisibility(0);
                    this.nwL.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.nwK.setVisibility(8);
                    this.nwI.setVisibility(0);
                    this.nwI.setImageResource(b.c.commonres_pagestatus_empty);
                    this.nwI.setClickable(true);
                    this.nwJ.setVisibility(0);
                    this.nwJ.setText(b.f.commonres_pagestatus_empty);
                    this.nwL.setVisibility(8);
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
