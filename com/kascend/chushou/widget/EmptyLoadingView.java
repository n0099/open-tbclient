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
    private static View.OnClickListener pzB;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView pzC;
    private TextView pzD;
    private AnimationImageView pzE;
    private TextView pzF;
    private View.OnClickListener pzG;

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
        this.pzC = (ImageView) findViewById(b.d.iv_empty);
        this.pzD = (TextView) findViewById(b.d.tv_desc);
        this.pzE = (AnimationImageView) findViewById(b.d.iv_loading);
        this.pzF = (TextView) findViewById(b.d.tv_button);
        this.pzC.setOnClickListener(this);
        this.pzD.setOnClickListener(this);
        this.pzF.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void aq(View.OnClickListener onClickListener) {
        pzB = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (pzB != null) {
                    pzB.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.pzG != null) {
                    this.pzG.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.pzG = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void QP(int i) {
        if (this.pzE != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.pzE.setVisibility(0);
                    this.pzC.setVisibility(8);
                    this.pzD.setVisibility(8);
                    this.pzF.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.pzE.setVisibility(8);
                    this.pzC.setVisibility(0);
                    this.pzC.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.pzC.setClickable(true);
                    this.pzD.setVisibility(0);
                    this.pzD.setText(b.f.commonres_pagestatus_net_error);
                    this.pzF.setVisibility(0);
                    this.pzF.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.pzE.setVisibility(8);
                    this.pzC.setVisibility(0);
                    this.pzC.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.pzC.setClickable(true);
                    this.pzD.setVisibility(0);
                    this.pzD.setText(b.f.commonres_pagestatus_unknown);
                    this.pzF.setVisibility(0);
                    this.pzF.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.pzE.setVisibility(8);
                    this.pzC.setVisibility(0);
                    this.pzC.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.pzC.setClickable(true);
                    this.pzD.setVisibility(8);
                    this.pzF.setVisibility(0);
                    this.pzF.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.pzE.setVisibility(8);
                    this.pzC.setVisibility(0);
                    this.pzC.setImageResource(b.c.commonres_pagestatus_empty);
                    this.pzC.setClickable(true);
                    this.pzD.setVisibility(0);
                    this.pzD.setText(b.f.commonres_pagestatus_empty);
                    this.pzF.setVisibility(8);
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
