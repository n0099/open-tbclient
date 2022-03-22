package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class DividerView extends View {
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f41417b = 1;

    /* renamed from: c  reason: collision with root package name */
    public Paint f41418c;

    /* renamed from: d  reason: collision with root package name */
    public int f41419d;

    /* renamed from: e  reason: collision with root package name */
    public int f41420e;

    public DividerView(Context context) {
        this(context, null);
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04030b, R.attr.obfuscated_res_0x7f04030c, R.attr.obfuscated_res_0x7f04030d, R.attr.obfuscated_res_0x7f04030e, R.attr.obfuscated_res_0x7f04031b}, 0, 0);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 5);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(2, 5);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(3, 3);
            this.f41420e = obtainStyledAttributes.getColor(0, -16777216);
            this.f41419d = obtainStyledAttributes.getInt(4, a);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.f41418c = paint;
            paint.setAntiAlias(true);
            this.f41418c.setColor(this.f41420e);
            this.f41418c.setStyle(Paint.Style.STROKE);
            this.f41418c.setStrokeWidth(dimensionPixelSize3);
            this.f41418c.setPathEffect(new DashPathEffect(new float[]{dimensionPixelSize2, dimensionPixelSize}, 0.0f));
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
        if (this.f41419d == a) {
            height = getHeight() * 0.5f;
            f3 = 0.0f;
            width = getWidth();
            paint = this.f41418c;
            canvas2 = canvas;
            f2 = height;
        } else {
            width = getWidth() * 0.5f;
            f2 = 0.0f;
            height = getHeight();
            paint = this.f41418c;
            canvas2 = canvas;
            f3 = width;
        }
        canvas2.drawLine(f3, f2, width, height, paint);
    }

    public void setDividerColor(int i) {
        this.f41420e = i;
        this.f41418c.setColor(i);
        postInvalidate();
    }
}
