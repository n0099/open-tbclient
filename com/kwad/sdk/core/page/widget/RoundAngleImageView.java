package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes10.dex */
public class RoundAngleImageView extends ImageView {
    public float[] avd;
    public Path mPath;
    public RectF mRectF;

    public RoundAngleImageView(Context context) {
        this(context, null);
    }

    public void setRadius(float f) {
        this.avd = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.avd;
            if (i < fArr.length) {
                fArr[i] = f;
                i++;
            } else {
                return;
            }
        }
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float[] fArr = this.avd;
        if (fArr != null && fArr.length == 8) {
            if (Build.VERSION.SDK_INT < 18) {
                setLayerType(1, null);
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float[] fArr2 = this.avd;
            float f = fArr2[1] + fArr2[7];
            this.mPath.rewind();
            float f2 = measuredWidth;
            if (f2 >= fArr2[0] + fArr2[3]) {
                float f3 = measuredHeight;
                if (f3 > f) {
                    this.mRectF.set(0.0f, 0.0f, f2, f3);
                    this.mPath.addRoundRect(this.mRectF, this.avd, Path.Direction.CW);
                    canvas.clipPath(this.mPath);
                }
            }
            super.onDraw(canvas);
            return;
        }
        super.onDraw(canvas);
    }

    public void setRadius(float[] fArr) {
        this.avd = new float[8];
        int i = 0;
        while (true) {
            float[] fArr2 = this.avd;
            if (i < fArr2.length) {
                fArr2[i] = fArr[i];
                i++;
            } else {
                return;
            }
        }
    }
}
