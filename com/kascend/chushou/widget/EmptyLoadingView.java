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
    private static View.OnClickListener pqg;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView pqh;
    private TextView pqi;
    private AnimationImageView pqj;
    private TextView pqk;
    private View.OnClickListener pql;

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
        this.pqh = (ImageView) findViewById(b.d.iv_empty);
        this.pqi = (TextView) findViewById(b.d.tv_desc);
        this.pqj = (AnimationImageView) findViewById(b.d.iv_loading);
        this.pqk = (TextView) findViewById(b.d.tv_button);
        this.pqh.setOnClickListener(this);
        this.pqi.setOnClickListener(this);
        this.pqk.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ap(View.OnClickListener onClickListener) {
        pqg = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (pqg != null) {
                    pqg.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.pql != null) {
                    this.pql.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.pql = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Qu(int i) {
        if (this.pqj != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.pqj.setVisibility(0);
                    this.pqh.setVisibility(8);
                    this.pqi.setVisibility(8);
                    this.pqk.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.pqj.setVisibility(8);
                    this.pqh.setVisibility(0);
                    this.pqh.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.pqh.setClickable(true);
                    this.pqi.setVisibility(0);
                    this.pqi.setText(b.f.commonres_pagestatus_net_error);
                    this.pqk.setVisibility(0);
                    this.pqk.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.pqj.setVisibility(8);
                    this.pqh.setVisibility(0);
                    this.pqh.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.pqh.setClickable(true);
                    this.pqi.setVisibility(0);
                    this.pqi.setText(b.f.commonres_pagestatus_unknown);
                    this.pqk.setVisibility(0);
                    this.pqk.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.pqj.setVisibility(8);
                    this.pqh.setVisibility(0);
                    this.pqh.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.pqh.setClickable(true);
                    this.pqi.setVisibility(8);
                    this.pqk.setVisibility(0);
                    this.pqk.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.pqj.setVisibility(8);
                    this.pqh.setVisibility(0);
                    this.pqh.setImageResource(b.c.commonres_pagestatus_empty);
                    this.pqh.setClickable(true);
                    this.pqi.setVisibility(0);
                    this.pqi.setText(b.f.commonres_pagestatus_empty);
                    this.pqk.setVisibility(8);
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
