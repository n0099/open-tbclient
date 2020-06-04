package com.kascend.chushou.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.PrivacyItem;
import tv.chushou.widget.ToggleButton;
/* loaded from: classes5.dex */
public class OnlineToggleButton extends RelativeLayout {
    private ImageView b;
    private TextView c;
    private ToggleButton naX;
    private RotateAnimation naY;

    public OnlineToggleButton(Context context) {
        this(context, null);
    }

    public OnlineToggleButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(a.h.view_online_toggle_btn, (ViewGroup) this, false);
        this.naX = (ToggleButton) inflate.findViewById(a.f.btn_toggle);
        this.naX.setClickable(false);
        this.b = (ImageView) inflate.findViewById(a.f.iv_progress);
        if (this.naY == null) {
            this.naY = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.naY.setRepeatCount(-1);
            this.naY.setInterpolator(new LinearInterpolator());
            this.naY.setDuration(1000L);
        }
        this.c = (TextView) inflate.findViewById(a.f.tv_unknown);
        addView(inflate);
    }

    public void a(PrivacyItem privacyItem) {
        if (privacyItem.mState == 2) {
            d();
        } else if (privacyItem.mState == 1) {
            e();
            this.naX.dRN();
        } else if (privacyItem.mState == 0) {
            e();
            this.naX.dRO();
        } else if (privacyItem.mState == 3) {
            f();
        }
    }

    private void d() {
        this.b.setVisibility(0);
        this.b.startAnimation(this.naY);
        this.naX.setVisibility(8);
        this.c.setVisibility(8);
    }

    private void e() {
        this.naX.setVisibility(0);
        this.b.setVisibility(8);
        this.b.clearAnimation();
        this.c.setVisibility(8);
    }

    private void f() {
        this.c.setVisibility(0);
        this.naX.setVisibility(8);
        this.b.setVisibility(8);
        this.b.clearAnimation();
    }

    public void a() {
        this.naX.toggle();
    }

    public void b() {
        e();
        this.naX.dRN();
    }

    public void c() {
        e();
        this.naX.dRO();
    }
}
