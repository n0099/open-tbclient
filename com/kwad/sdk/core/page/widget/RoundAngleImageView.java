package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes3.dex */
public class RoundAngleImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Path f9366a;

    /* renamed from: b  reason: collision with root package name */
    private float f9367b;
    private RectF c;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9366a = new Path();
        this.c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f9367b == 0.0f) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.f9367b * 2.0f;
        if (measuredWidth >= this.f9367b * 2.0f && measuredHeight > f) {
            this.c.set(0.0f, 0.0f, measuredWidth, measuredHeight);
            this.f9366a.addRoundRect(this.c, this.f9367b, this.f9367b, Path.Direction.CW);
            canvas.clipPath(this.f9366a);
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f) {
        this.f9367b = f;
    }
}
