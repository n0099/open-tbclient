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
    private static View.OnClickListener pBe;
    private View.OnClickListener mLoginListener;
    private int mType;
    private ImageView pBf;
    private TextView pBg;
    private AnimationImageView pBh;
    private TextView pBi;
    private View.OnClickListener pBj;

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
        this.pBf = (ImageView) findViewById(b.d.iv_empty);
        this.pBg = (TextView) findViewById(b.d.tv_desc);
        this.pBh = (AnimationImageView) findViewById(b.d.iv_loading);
        this.pBi = (TextView) findViewById(b.d.tv_button);
        this.pBf.setOnClickListener(this);
        this.pBg.setOnClickListener(this);
        this.pBi.setOnClickListener(this);
        setOnClickListener(this);
    }

    public static void aq(View.OnClickListener onClickListener) {
        pBe = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.mType) {
            case 5:
                if (this.mLoginListener != null) {
                    this.mLoginListener.onClick(view);
                    return;
                } else if (pBe != null) {
                    pBe.onClick(view);
                    return;
                } else {
                    return;
                }
            default:
                if (this.pBj != null) {
                    this.pBj.onClick(view);
                    return;
                }
                return;
        }
    }

    public void setReloadListener(View.OnClickListener onClickListener) {
        this.pBj = onClickListener;
    }

    public void setLoginListener(View.OnClickListener onClickListener) {
        this.mLoginListener = onClickListener;
    }

    public void Rs(int i) {
        if (this.pBh != null) {
            switch (i) {
                case 1:
                    this.mType = 1;
                    setVisibility(0);
                    this.pBh.setVisibility(0);
                    this.pBf.setVisibility(8);
                    this.pBg.setVisibility(8);
                    this.pBi.setVisibility(8);
                    return;
                case 2:
                    this.mType = 2;
                    setVisibility(8);
                    return;
                case 3:
                    this.mType = 3;
                    setVisibility(0);
                    this.pBh.setVisibility(8);
                    this.pBf.setVisibility(0);
                    this.pBf.setImageResource(b.c.commonres_pagestatus_net_error);
                    this.pBf.setClickable(true);
                    this.pBg.setVisibility(0);
                    this.pBg.setText(b.f.commonres_pagestatus_net_error);
                    this.pBi.setVisibility(0);
                    this.pBi.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 4:
                    this.mType = 4;
                    setVisibility(0);
                    this.pBh.setVisibility(8);
                    this.pBf.setVisibility(0);
                    this.pBf.setImageResource(b.c.commonres_pagestatus_unknown_error);
                    this.pBf.setClickable(true);
                    this.pBg.setVisibility(0);
                    this.pBg.setText(b.f.commonres_pagestatus_unknown);
                    this.pBi.setVisibility(0);
                    this.pBi.setText(b.f.commonres_pagestatus_action_refresh);
                    return;
                case 5:
                    this.mType = 5;
                    setVisibility(0);
                    this.pBh.setVisibility(8);
                    this.pBf.setVisibility(0);
                    this.pBf.setImageResource(b.c.commonres_pagestatus_need_login);
                    this.pBf.setClickable(true);
                    this.pBg.setVisibility(8);
                    this.pBi.setVisibility(0);
                    this.pBi.setText(b.f.commonres_pagestatus_action_login);
                    return;
                case 6:
                    this.mType = 6;
                    setVisibility(0);
                    this.pBh.setVisibility(8);
                    this.pBf.setVisibility(0);
                    this.pBf.setImageResource(b.c.commonres_pagestatus_empty);
                    this.pBf.setClickable(true);
                    this.pBg.setVisibility(0);
                    this.pBg.setText(b.f.commonres_pagestatus_empty);
                    this.pBi.setVisibility(8);
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
