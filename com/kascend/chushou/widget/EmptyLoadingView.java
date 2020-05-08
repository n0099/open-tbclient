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
    private static View.OnClickListener mFG;
    private ImageView mFH;
    private TextView mFI;
    private AnimationImageView mFJ;
    private TextView mFK;
    private View.OnClickListener mFL;
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
        this.mFH = (ImageView) findViewById(b.d.iv_empty);
        this.mFI = (TextView) findViewById(b.d.tv_desc);
        this.mFJ = (AnimationImageView) findViewById(b.d.iv_loading);
        this.mFK = (TextView) findViewById(b.d.tv_button);
        this.mFH.setOnClickListener(this);
        this.mFI.setOnClickListener(this);
        this.mFK.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void al(View.OnClickListener onClickListener) {
        mFG = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (mFG != null) {
                    mFG.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.mFL != null) {
                    this.mFL.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.mFL = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void IA(int i) {
        if (this.mFJ != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.mFJ.setVisibility(0);
                    this.mFH.setVisibility(8);
                    this.mFI.setVisibility(8);
                    this.mFK.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.mFJ.setVisibility(8);
                    this.mFH.setVisibility(0);
                    this.mFH.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.mFH.setClickable(true);
                    this.mFI.setVisibility(0);
                    this.mFI.setText(b.f.commonres_pagestatus_net_error);
                    this.mFK.setVisibility(0);
                    this.mFK.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.mFJ.setVisibility(8);
                    this.mFH.setVisibility(0);
                    this.mFH.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.mFH.setClickable(true);
                    this.mFI.setVisibility(0);
                    this.mFI.setText(b.f.commonres_pagestatus_unknown);
                    this.mFK.setVisibility(0);
                    this.mFK.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.mFJ.setVisibility(8);
                    this.mFH.setVisibility(0);
                    this.mFH.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.mFH.setClickable(true);
                    this.mFI.setVisibility(8);
                    this.mFK.setVisibility(0);
                    this.mFK.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.mFJ.setVisibility(8);
                    this.mFH.setVisibility(0);
                    this.mFH.setImageResource(b.c.commonres_pagestatus_empty);
                    this.mFH.setClickable(true);
                    this.mFI.setVisibility(0);
                    this.mFI.setText(b.f.commonres_pagestatus_empty);
                    this.mFK.setVisibility(8);
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
