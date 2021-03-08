package com.win.opensdk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.win.opensdk.bd;
/* loaded from: classes14.dex */
public class PBMediaView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public bg f8102a;

    public PBMediaView(Context context) {
        this(context, null);
    }

    public PBMediaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PBMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8102a = new bg(context);
        addView(this.f8102a.c, new FrameLayout.LayoutParams(-1, -1));
        try {
            ImageView imageView = new ImageView(context);
            int b = v.b(context, 15.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b, b);
            layoutParams.gravity = 3;
            imageView.setImageResource(bd.a.btn_op);
            addView(imageView, layoutParams);
        } catch (Exception e) {
        }
    }

    public bg getHtmlWebView() {
        return this.f8102a;
    }
}
