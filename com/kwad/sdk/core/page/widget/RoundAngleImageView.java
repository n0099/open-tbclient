package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes8.dex */
public class RoundAngleImageView extends ImageView {
    public Path ZA;
    public float[] ZB;
    public RectF zV;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ZA = new Path();
        this.zV = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float[] fArr = this.ZB;
        if (fArr == null || fArr.length != 8) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float[] fArr2 = this.ZB;
        float f = fArr2[1] + fArr2[7];
        this.ZA.rewind();
        float f2 = measuredWidth;
        if (f2 >= fArr2[0] + fArr2[3]) {
            float f3 = measuredHeight;
            if (f3 > f) {
                this.zV.set(0.0f, 0.0f, f2, f3);
                this.ZA.addRoundRect(this.zV, this.ZB, Path.Direction.CW);
                canvas.clipPath(this.ZA);
            }
        }
        super.onDraw(canvas);
    }

    public void setRadius(float f) {
        this.ZB = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.ZB;
            if (i >= fArr.length) {
                return;
            }
            fArr[i] = f;
            i++;
        }
    }

    public void setRadius(float[] fArr) {
        this.ZB = new float[8];
        int i = 0;
        while (true) {
            float[] fArr2 = this.ZB;
            if (i >= fArr2.length) {
                return;
            }
            fArr2[i] = fArr[i];
            i++;
        }
    }
}
