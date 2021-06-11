package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class RoundAngleImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Path f34577a;

    /* renamed from: b  reason: collision with root package name */
    public float f34578b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f34579c;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f34577a = new Path();
        this.f34579c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f34578b == 0.0f) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = this.f34578b;
        float f3 = f2 * 2.0f;
        float f4 = f2 * 2.0f;
        float f5 = measuredWidth;
        if (f5 >= f3) {
            float f6 = measuredHeight;
            if (f6 > f4) {
                this.f34579c.set(0.0f, 0.0f, f5, f6);
                Path path = this.f34577a;
                RectF rectF = this.f34579c;
                float f7 = this.f34578b;
                path.addRoundRect(rectF, f7, f7, Path.Direction.CW);
                canvas.clipPath(this.f34577a);
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f2) {
        this.f34578b = f2;
    }
}
