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
    public Path a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f39665b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f39666c;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Path();
        this.f39666c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float[] fArr = this.f39665b;
        if (fArr == null || fArr.length != 8) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float[] fArr2 = this.f39665b;
        float f2 = fArr2[1] + fArr2[7];
        this.a.rewind();
        float f3 = measuredWidth;
        if (f3 >= fArr2[0] + fArr2[3]) {
            float f4 = measuredHeight;
            if (f4 > f2) {
                this.f39666c.set(0.0f, 0.0f, f3, f4);
                this.a.addRoundRect(this.f39666c, this.f39665b, Path.Direction.CW);
                canvas.clipPath(this.a);
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f2) {
        this.f39665b = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.f39665b;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = f2;
            i++;
        }
    }

    public void setRadius(float[] fArr) {
        this.f39665b = new float[8];
        int i = 0;
        while (true) {
            float[] fArr2 = this.f39665b;
            if (i >= fArr2.length) {
                return;
            }
            fArr2[i] = fArr[i];
            i++;
        }
    }
}
