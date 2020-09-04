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
    private static View.OnClickListener nZE;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView nZF;
    private TextView nZG;
    private AnimationImageView nZH;
    private TextView nZI;
    private View.OnClickListener nZJ;

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
        this.nZF = (ImageView) findViewById(b.d.iv_empty);
        this.nZG = (TextView) findViewById(b.d.tv_desc);
        this.nZH = (AnimationImageView) findViewById(b.d.iv_loading);
        this.nZI = (TextView) findViewById(b.d.tv_button);
        this.nZF.setOnClickListener(this);
        this.nZG.setOnClickListener(this);
        this.nZI.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ap(View.OnClickListener onClickListener) {
        nZE = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (nZE != null) {
                    nZE.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.nZJ != null) {
                    this.nZJ.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.nZJ = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Ns(int i) {
        if (this.nZH != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.nZH.setVisibility(0);
                    this.nZF.setVisibility(8);
                    this.nZG.setVisibility(8);
                    this.nZI.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.nZH.setVisibility(8);
                    this.nZF.setVisibility(0);
                    this.nZF.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.nZF.setClickable(true);
                    this.nZG.setVisibility(0);
                    this.nZG.setText(b.f.commonres_pagestatus_net_error);
                    this.nZI.setVisibility(0);
                    this.nZI.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.nZH.setVisibility(8);
                    this.nZF.setVisibility(0);
                    this.nZF.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.nZF.setClickable(true);
                    this.nZG.setVisibility(0);
                    this.nZG.setText(b.f.commonres_pagestatus_unknown);
                    this.nZI.setVisibility(0);
                    this.nZI.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.nZH.setVisibility(8);
                    this.nZF.setVisibility(0);
                    this.nZF.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.nZF.setClickable(true);
                    this.nZG.setVisibility(8);
                    this.nZI.setVisibility(0);
                    this.nZI.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.nZH.setVisibility(8);
                    this.nZF.setVisibility(0);
                    this.nZF.setImageResource(b.c.commonres_pagestatus_empty);
                    this.nZF.setClickable(true);
                    this.nZG.setVisibility(0);
                    this.nZG.setText(b.f.commonres_pagestatus_empty);
                    this.nZI.setVisibility(8);
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
