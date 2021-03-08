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
    private Path f6216a;
    private float b;
    private RectF c;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6216a = new Path();
        this.c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.b == 0.0f) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.b * 2.0f;
        if (measuredWidth >= this.b * 2.0f && measuredHeight > f) {
            this.c.set(0.0f, 0.0f, measuredWidth, measuredHeight);
            this.f6216a.addRoundRect(this.c, this.b, this.b, Path.Direction.CW);
            canvas.clipPath(this.f6216a);
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f) {
        this.b = f;
    }
}
