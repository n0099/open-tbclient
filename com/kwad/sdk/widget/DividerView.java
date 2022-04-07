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
    public static int a = 0;
    public static int b = 1;
    public Paint c;
    public int d;
    public int e;

    public DividerView(Context context) {
        this(context, null);
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040349, R.attr.obfuscated_res_0x7f04034a, R.attr.obfuscated_res_0x7f040350, R.attr.obfuscated_res_0x7f040351, R.attr.obfuscated_res_0x7f040367}, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(2, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(3, 3);
            this.e = obtainStyledAttributes.getColor(0, -16777216);
            this.d = obtainStyledAttributes.getInt(4, a);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.c = paint;
            paint.setAntiAlias(true);
            this.c.setColor(this.e);
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeWidth(dimensionPixelSize3);
            this.c.setPathEffect(new DashPathEffect(new float[]{dimensionPixelSize2, dimensionPixelSize}, 0.0f));
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
        if (this.d == a) {
            height = getHeight() * 0.5f;
            f2 = 0.0f;
            width = getWidth();
            paint = this.c;
            canvas2 = canvas;
            f = height;
        } else {
            width = getWidth() * 0.5f;
            f = 0.0f;
            height = getHeight();
            paint = this.c;
            canvas2 = canvas;
            f2 = width;
        }
        canvas2.drawLine(f2, f, width, height, paint);
    }

    public void setDividerColor(int i) {
        this.e = i;
        this.c.setColor(i);
        postInvalidate();
    }
}
