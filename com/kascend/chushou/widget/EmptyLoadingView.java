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
    private static View.OnClickListener nFv;
    private View.OnClickListener mLoginListener;
    private int mType;
    private View.OnClickListener nFA;
    private ImageView nFw;
    private TextView nFx;
    private AnimationImageView nFy;
    private TextView nFz;

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
        this.nFw = (ImageView) findViewById(b.d.iv_empty);
        this.nFx = (TextView) findViewById(b.d.tv_desc);
        this.nFy = (AnimationImageView) findViewById(b.d.iv_loading);
        this.nFz = (TextView) findViewById(b.d.tv_button);
        this.nFw.setOnClickListener(this);
        this.nFx.setOnClickListener(this);
        this.nFz.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ao(View.OnClickListener onClickListener) {
        nFv = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (nFv != null) {
                    nFv.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.nFA != null) {
                    this.nFA.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.nFA = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void KO(int i) {
        if (this.nFy != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.nFy.setVisibility(0);
                    this.nFw.setVisibility(8);
                    this.nFx.setVisibility(8);
                    this.nFz.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.nFy.setVisibility(8);
                    this.nFw.setVisibility(0);
                    this.nFw.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.nFw.setClickable(true);
                    this.nFx.setVisibility(0);
                    this.nFx.setText(b.f.commonres_pagestatus_net_error);
                    this.nFz.setVisibility(0);
                    this.nFz.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.nFy.setVisibility(8);
                    this.nFw.setVisibility(0);
                    this.nFw.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.nFw.setClickable(true);
                    this.nFx.setVisibility(0);
                    this.nFx.setText(b.f.commonres_pagestatus_unknown);
                    this.nFz.setVisibility(0);
                    this.nFz.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.nFy.setVisibility(8);
                    this.nFw.setVisibility(0);
                    this.nFw.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.nFw.setClickable(true);
                    this.nFx.setVisibility(8);
                    this.nFz.setVisibility(0);
                    this.nFz.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.nFy.setVisibility(8);
                    this.nFw.setVisibility(0);
                    this.nFw.setImageResource(b.c.commonres_pagestatus_empty);
                    this.nFw.setClickable(true);
                    this.nFx.setVisibility(0);
                    this.nFx.setText(b.f.commonres_pagestatus_empty);
                    this.nFz.setVisibility(8);
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
