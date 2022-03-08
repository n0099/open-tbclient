package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class DividerView extends View {
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f56530b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Paint f56531c;

    /* renamed from: d  reason: collision with root package name */
    public int f56532d;

    /* renamed from: e  reason: collision with root package name */
    public int f56533e;

    public DividerView(Context context) {
        this(context, null);
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.ksad_color, R.attr.ksad_dashGap, R.attr.ksad_dashLength, R.attr.ksad_dashThickness, R.attr.ksad_orientation}, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(2, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(3, 3);
            this.f56533e = obtainStyledAttributes.getColor(0, -16777216);
            this.f56532d = obtainStyledAttributes.getInt(4, a);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.f56531c = paint;
            paint.setAntiAlias(true);
            this.f56531c.setColor(this.f56533e);
            this.f56531c.setStyle(Paint.Style.STROKE);
            this.f56531c.setStrokeWidth(dimensionPixelSize3);
            this.f56531c.setPathEffect(new DashPathEffect(new float[]{dimensionPixelSize2, dimensionPixelSize}, 0.0f));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width;
        float f2;
        float height;
        Paint paint;
        Canvas canvas2;
        float f3;
        if (this.f56532d == a) {
            height = getHeight() * 0.5f;
            f3 = 0.0f;
            width = getWidth();
            paint = this.f56531c;
            canvas2 = canvas;
            f2 = height;
        } else {
            width = getWidth() * 0.5f;
            f2 = 0.0f;
            height = getHeight();
            paint = this.f56531c;
            canvas2 = canvas;
            f3 = width;
        }
        canvas2.drawLine(f3, f2, width, height, paint);
    }

    public void setDividerColor(int i2) {
        this.f56533e = i2;
        this.f56531c.setColor(i2);
        postInvalidate();
    }
}
