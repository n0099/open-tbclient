package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class RoundAngleImageView extends ImageView {
    public Path a;
    public float[] b;
    public RectF c;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new Path();
        this.c = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float[] fArr = this.b;
        if (fArr == null || fArr.length != 8) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float[] fArr2 = this.b;
        float f = fArr2[1] + fArr2[7];
        this.a.rewind();
        float f2 = measuredWidth;
        if (f2 >= fArr2[0] + fArr2[3]) {
            float f3 = measuredHeight;
            if (f3 > f) {
                this.c.set(0.0f, 0.0f, f2, f3);
                this.a.addRoundRect(this.c, this.b, Path.Direction.CW);
                canvas.clipPath(this.a);
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f) {
        this.b = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.b;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = f;
            i++;
        }
    }

    public void setRadius(float[] fArr) {
        this.b = new float[8];
        int i = 0;
        while (true) {
            float[] fArr2 = this.b;
            if (i >= fArr2.length) {
                return;
            }
            fArr2[i] = fArr[i];
            i++;
        }
    }
}
