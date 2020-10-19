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
    private static View.OnClickListener oyL;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView oyM;
    private TextView oyN;
    private AnimationImageView oyO;
    private TextView oyP;
    private View.OnClickListener oyQ;

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
        this.oyM = (ImageView) findViewById(b.d.iv_empty);
        this.oyN = (TextView) findViewById(b.d.tv_desc);
        this.oyO = (AnimationImageView) findViewById(b.d.iv_loading);
        this.oyP = (TextView) findViewById(b.d.tv_button);
        this.oyM.setOnClickListener(this);
        this.oyN.setOnClickListener(this);
        this.oyP.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ap(View.OnClickListener onClickListener) {
        oyL = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (oyL != null) {
                    oyL.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.oyQ != null) {
                    this.oyQ.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.oyQ = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void OD(int i) {
        if (this.oyO != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.oyO.setVisibility(0);
                    this.oyM.setVisibility(8);
                    this.oyN.setVisibility(8);
                    this.oyP.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.oyO.setVisibility(8);
                    this.oyM.setVisibility(0);
                    this.oyM.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.oyM.setClickable(true);
                    this.oyN.setVisibility(0);
                    this.oyN.setText(b.f.commonres_pagestatus_net_error);
                    this.oyP.setVisibility(0);
                    this.oyP.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.oyO.setVisibility(8);
                    this.oyM.setVisibility(0);
                    this.oyM.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.oyM.setClickable(true);
                    this.oyN.setVisibility(0);
                    this.oyN.setText(b.f.commonres_pagestatus_unknown);
                    this.oyP.setVisibility(0);
                    this.oyP.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.oyO.setVisibility(8);
                    this.oyM.setVisibility(0);
                    this.oyM.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.oyM.setClickable(true);
                    this.oyN.setVisibility(8);
                    this.oyP.setVisibility(0);
                    this.oyP.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.oyO.setVisibility(8);
                    this.oyM.setVisibility(0);
                    this.oyM.setImageResource(b.c.commonres_pagestatus_empty);
                    this.oyM.setClickable(true);
                    this.oyN.setVisibility(0);
                    this.oyN.setText(b.f.commonres_pagestatus_empty);
                    this.oyP.setVisibility(8);
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
