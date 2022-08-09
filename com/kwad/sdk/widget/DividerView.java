package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class DividerView extends View {
    public static int ORIENTATION_HORIZONTAL = 0;
    public static int ORIENTATION_VERTICAL = 1;
    public int aqw;
    public Paint mPaint;
    public int orientation;

    public DividerView(Context context) {
        this(context, null);
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040396, R.attr.obfuscated_res_0x7f040397, R.attr.obfuscated_res_0x7f040398, R.attr.obfuscated_res_0x7f040399, R.attr.obfuscated_res_0x7f0403ad}, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(2, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(3, 3);
            this.aqw = obtainStyledAttributes.getColor(0, -16777216);
            this.orientation = obtainStyledAttributes.getInt(4, ORIENTATION_HORIZONTAL);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setColor(this.aqw);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(dimensionPixelSize3);
            this.mPaint.setPathEffect(new DashPathEffect(new float[]{dimensionPixelSize2, dimensionPixelSize}, 0.0f));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width;
        float f;
        float height;
        Paint paint;
        Canvas canvas2;
        float f2;
        if (this.orientation == ORIENTATION_HORIZONTAL) {
            height = getHeight() * 0.5f;
            f2 = 0.0f;
            width = getWidth();
            paint = this.mPaint;
            canvas2 = canvas;
            f = height;
        } else {
            width = getWidth() * 0.5f;
            f = 0.0f;
            height = getHeight();
            paint = this.mPaint;
            canvas2 = canvas;
            f2 = width;
        }
        canvas2.drawLine(f2, f, width, height, paint);
    }

    public void setDividerColor(int i) {
        this.aqw = i;
        this.mPaint.setColor(i);
        postInvalidate();
    }
}
