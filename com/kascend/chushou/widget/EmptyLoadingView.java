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
    private static View.OnClickListener naQ;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView naR;
    private TextView naS;
    private AnimationImageView naT;
    private TextView naU;
    private View.OnClickListener naV;

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
        this.naR = (ImageView) findViewById(b.d.iv_empty);
        this.naS = (TextView) findViewById(b.d.tv_desc);
        this.naT = (AnimationImageView) findViewById(b.d.iv_loading);
        this.naU = (TextView) findViewById(b.d.tv_button);
        this.naR.setOnClickListener(this);
        this.naS.setOnClickListener(this);
        this.naU.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void al(View.OnClickListener onClickListener) {
        naQ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (naQ != null) {
                    naQ.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.naV != null) {
                    this.naV.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.naV = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Jn(int i) {
        if (this.naT != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.naT.setVisibility(0);
                    this.naR.setVisibility(8);
                    this.naS.setVisibility(8);
                    this.naU.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.naT.setVisibility(8);
                    this.naR.setVisibility(0);
                    this.naR.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.naR.setClickable(true);
                    this.naS.setVisibility(0);
                    this.naS.setText(b.f.commonres_pagestatus_net_error);
                    this.naU.setVisibility(0);
                    this.naU.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.naT.setVisibility(8);
                    this.naR.setVisibility(0);
                    this.naR.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.naR.setClickable(true);
                    this.naS.setVisibility(0);
                    this.naS.setText(b.f.commonres_pagestatus_unknown);
                    this.naU.setVisibility(0);
                    this.naU.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.naT.setVisibility(8);
                    this.naR.setVisibility(0);
                    this.naR.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.naR.setClickable(true);
                    this.naS.setVisibility(8);
                    this.naU.setVisibility(0);
                    this.naU.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.naT.setVisibility(8);
                    this.naR.setVisibility(0);
                    this.naR.setImageResource(b.c.commonres_pagestatus_empty);
                    this.naR.setClickable(true);
                    this.naS.setVisibility(0);
                    this.naS.setText(b.f.commonres_pagestatus_empty);
                    this.naU.setVisibility(8);
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
