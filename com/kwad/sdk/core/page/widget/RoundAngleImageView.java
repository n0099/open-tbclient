package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes7.dex */
public class RoundAngleImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Path f34675a;

    /* renamed from: b  reason: collision with root package name */
    public float f34676b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f34677c;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f34675a = new Path();
        this.f34677c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f34676b == 0.0f) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = this.f34676b;
        float f3 = f2 * 2.0f;
        float f4 = f2 * 2.0f;
        float f5 = measuredWidth;
        if (f5 >= f3) {
            float f6 = measuredHeight;
            if (f6 > f4) {
                this.f34677c.set(0.0f, 0.0f, f5, f6);
                Path path = this.f34675a;
                RectF rectF = this.f34677c;
                float f7 = this.f34676b;
                path.addRoundRect(rectF, f7, f7, Path.Direction.CW);
                canvas.clipPath(this.f34675a);
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f2) {
        this.f34676b = f2;
    }
}
