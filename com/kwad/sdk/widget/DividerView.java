package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class DividerView extends View {
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f57968b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Paint f57969c;

    /* renamed from: d  reason: collision with root package name */
    public int f57970d;

    /* renamed from: e  reason: collision with root package name */
    public int f57971e;

    public DividerView(Context context) {
        this(context, null);
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ksad_DividerView, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashGap, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashLength, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DividerView_ksad_dashThickness, 3);
            this.f57971e = obtainStyledAttributes.getColor(R.styleable.ksad_DividerView_ksad_color, -16777216);
            this.f57970d = obtainStyledAttributes.getInt(R.styleable.ksad_DividerView_ksad_orientation, a);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.f57969c = paint;
            paint.setAntiAlias(true);
            this.f57969c.setColor(this.f57971e);
            this.f57969c.setStyle(Paint.Style.STROKE);
            this.f57969c.setStrokeWidth(dimensionPixelSize3);
            this.f57969c.setPathEffect(new DashPathEffect(new float[]{dimensionPixelSize2, dimensionPixelSize}, 0.0f));
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
        if (this.f57970d == a) {
            height = getHeight() * 0.5f;
            f3 = 0.0f;
            width = getWidth();
            paint = this.f57969c;
            canvas2 = canvas;
            f2 = height;
        } else {
            width = getWidth() * 0.5f;
            f2 = 0.0f;
            height = getHeight();
            paint = this.f57969c;
            canvas2 = canvas;
            f3 = width;
        }
        canvas2.drawLine(f3, f2, width, height, paint);
    }

    public void setDividerColor(int i2) {
        this.f57971e = i2;
        this.f57969c.setColor(i2);
        postInvalidate();
    }
}
