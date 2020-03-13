package com.kascend.chushou.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kascend.chushou.a;
/* loaded from: classes5.dex */
public class SubscribeButton extends LinearLayout {
    public static float a;
    private boolean b;
    private TextView c;
    private LinearLayout d;
    private LinearLayout e;
    private Context h;
    private AnimatorSet neo;
    private AnimatorSet nhB;

    public SubscribeButton(Context context) {
        this(context, null, 0);
    }

    public SubscribeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubscribeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.SubscribeButton);
        boolean z = obtainStyledAttributes.getBoolean(a.k.SubscribeButton_custom_size, false);
        obtainStyledAttributes.recycle();
        this.h = context;
        LayoutInflater.from(context).inflate(z ? a.h.widget_subscribe_button_small : a.h.widget_subscribe_button, (ViewGroup) this, true);
        this.d = (LinearLayout) findViewById(a.f.ll_subscribe_root);
        this.e = (LinearLayout) findViewById(a.f.ll_content);
        this.c = (TextView) findViewById(a.f.tv_subscribe_content);
        a = this.h.getResources().getDisplayMetrics().density;
        if (a >= 2.0f) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.subscribe_btn_height);
            this.nhB = new AnimatorSet();
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.e, PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f));
            ofPropertyValuesHolder.setDuration(20L);
            ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.e, PropertyValuesHolder.ofFloat("translationY", 0.0f, dimensionPixelOffset));
            ofPropertyValuesHolder2.setDuration(10L);
            this.nhB.play(ofPropertyValuesHolder2).after(ofPropertyValuesHolder);
            this.neo = new AnimatorSet();
            ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(this.e, PropertyValuesHolder.ofFloat("translationY", dimensionPixelOffset, 0.0f));
            ofPropertyValuesHolder3.setDuration(250L);
            this.neo.play(ofPropertyValuesHolder3);
        }
    }
}
