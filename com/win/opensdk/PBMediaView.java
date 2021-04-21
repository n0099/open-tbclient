package com.win.opensdk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
/* loaded from: classes7.dex */
public class PBMediaView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public S f40141a;

    public PBMediaView(Context context) {
        this(context, null);
    }

    public PBMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f40141a = new S(context);
        addView(this.f40141a.f40172c, new FrameLayout.LayoutParams(-1, -1));
        try {
            ImageView imageView = new ImageView(context);
            int b2 = G.b(context, 15.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
            layoutParams.gravity = 3;
            imageView.setImageResource(R.drawable.btn_op);
            addView(imageView, layoutParams);
        } catch (Exception unused) {
        }
    }

    public S getHtmlWebView() {
        return this.f40141a;
    }
}
