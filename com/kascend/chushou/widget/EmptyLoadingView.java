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
    private static View.OnClickListener nwK;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView nwL;
    private TextView nwM;
    private AnimationImageView nwN;
    private TextView nwO;
    private View.OnClickListener nwP;

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
        this.nwL = (ImageView) findViewById(b.d.iv_empty);
        this.nwM = (TextView) findViewById(b.d.tv_desc);
        this.nwN = (AnimationImageView) findViewById(b.d.iv_loading);
        this.nwO = (TextView) findViewById(b.d.tv_button);
        this.nwL.setOnClickListener(this);
        this.nwM.setOnClickListener(this);
        this.nwO.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void an(View.OnClickListener onClickListener) {
        nwK = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (nwK != null) {
                    nwK.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.nwP != null) {
                    this.nwP.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.nwP = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Ku(int i) {
        if (this.nwN != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.nwN.setVisibility(0);
                    this.nwL.setVisibility(8);
                    this.nwM.setVisibility(8);
                    this.nwO.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.nwN.setVisibility(8);
                    this.nwL.setVisibility(0);
                    this.nwL.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.nwL.setClickable(true);
                    this.nwM.setVisibility(0);
                    this.nwM.setText(b.f.commonres_pagestatus_net_error);
                    this.nwO.setVisibility(0);
                    this.nwO.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.nwN.setVisibility(8);
                    this.nwL.setVisibility(0);
                    this.nwL.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.nwL.setClickable(true);
                    this.nwM.setVisibility(0);
                    this.nwM.setText(b.f.commonres_pagestatus_unknown);
                    this.nwO.setVisibility(0);
                    this.nwO.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.nwN.setVisibility(8);
                    this.nwL.setVisibility(0);
                    this.nwL.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.nwL.setClickable(true);
                    this.nwM.setVisibility(8);
                    this.nwO.setVisibility(0);
                    this.nwO.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.nwN.setVisibility(8);
                    this.nwL.setVisibility(0);
                    this.nwL.setImageResource(b.c.commonres_pagestatus_empty);
                    this.nwL.setClickable(true);
                    this.nwM.setVisibility(0);
                    this.nwM.setText(b.f.commonres_pagestatus_empty);
                    this.nwO.setVisibility(8);
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
