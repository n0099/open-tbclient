package com.win.opensdk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes7.dex */
public class PBMediaView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public K f36900a;

    public PBMediaView(Context context) {
        this(context, null);
    }

    public PBMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBMediaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f36900a = new K(context);
        addView(this.f36900a.f36851c, new FrameLayout.LayoutParams(-1, -1));
        try {
            ImageView imageView = new ImageView(context);
            int i3 = (int) ((context.getResources().getDisplayMetrics().density * 15.0f) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
            layoutParams.gravity = 3;
            imageView.setImageResource(R.drawable.win_btn_op);
            addView(imageView, layoutParams);
        } catch (Exception unused) {
        }
    }

    public K getHtmlWebView() {
        return this.f36900a;
    }
}
