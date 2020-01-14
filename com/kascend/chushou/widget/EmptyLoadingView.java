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
/* loaded from: classes4.dex */
public class EmptyLoadingView extends RelativeLayout implements View.OnClickListener {
    private static View.OnClickListener ngq;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView ngr;
    private TextView ngs;
    private AnimationImageView ngt;
    private TextView ngu;
    private View.OnClickListener ngv;

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
        this.ngr = (ImageView) findViewById(b.d.iv_empty);
        this.ngs = (TextView) findViewById(b.d.tv_desc);
        this.ngt = (AnimationImageView) findViewById(b.d.iv_loading);
        this.ngu = (TextView) findViewById(b.d.tv_button);
        this.ngr.setOnClickListener(this);
        this.ngs.setOnClickListener(this);
        this.ngu.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void ai(View.OnClickListener onClickListener) {
        ngq = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (ngq != null) {
                    ngq.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.ngv != null) {
                    this.ngv.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.ngv = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void MX(int i) {
        if (this.ngt != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.ngt.setVisibility(0);
                    this.ngr.setVisibility(8);
                    this.ngs.setVisibility(8);
                    this.ngu.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.ngt.setVisibility(8);
                    this.ngr.setVisibility(0);
                    this.ngr.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.ngr.setClickable(true);
                    this.ngs.setVisibility(0);
                    this.ngs.setText(b.f.commonres_pagestatus_net_error);
                    this.ngu.setVisibility(0);
                    this.ngu.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.ngt.setVisibility(8);
                    this.ngr.setVisibility(0);
                    this.ngr.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.ngr.setClickable(true);
                    this.ngs.setVisibility(0);
                    this.ngs.setText(b.f.commonres_pagestatus_unknown);
                    this.ngu.setVisibility(0);
                    this.ngu.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.ngt.setVisibility(8);
                    this.ngr.setVisibility(0);
                    this.ngr.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.ngr.setClickable(true);
                    this.ngs.setVisibility(8);
                    this.ngu.setVisibility(0);
                    this.ngu.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.ngt.setVisibility(8);
                    this.ngr.setVisibility(0);
                    this.ngr.setImageResource(b.c.commonres_pagestatus_empty);
                    this.ngr.setClickable(true);
                    this.ngs.setVisibility(0);
                    this.ngs.setText(b.f.commonres_pagestatus_empty);
                    this.ngu.setVisibility(8);
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
