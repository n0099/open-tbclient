package com.facebook.e.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
/* loaded from: classes13.dex */
public class a extends ReplacementSpan {
    private Rect mBounds;
    private final Drawable mDrawable;
    private int mHeight;
    private int mWidth;
    private final int mYp;
    private final Paint.FontMetricsInt mYq = new Paint.FontMetricsInt();

    public a(Drawable drawable, int i) {
        this.mDrawable = drawable;
        this.mYp = i;
        hh();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        hh();
        if (fontMetricsInt == null) {
            return this.mWidth;
        }
        int a = a(fontMetricsInt);
        int i3 = this.mHeight + a;
        if (a < fontMetricsInt.ascent) {
            fontMetricsInt.ascent = a;
        }
        if (a < fontMetricsInt.top) {
            fontMetricsInt.top = a;
        }
        if (i3 > fontMetricsInt.descent) {
            fontMetricsInt.descent = i3;
        }
        if (i3 > fontMetricsInt.bottom) {
            fontMetricsInt.bottom = i3;
        }
        return this.mWidth;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        paint.getFontMetricsInt(this.mYq);
        int a = a(this.mYq) + i4;
        canvas.translate(f, a);
        this.mDrawable.draw(canvas);
        canvas.translate(-f, -a);
    }

    public void hh() {
        this.mBounds = this.mDrawable.getBounds();
        this.mWidth = this.mBounds.width();
        this.mHeight = this.mBounds.height();
    }

    private int a(Paint.FontMetricsInt fontMetricsInt) {
        switch (this.mYp) {
            case 0:
                return fontMetricsInt.descent - this.mHeight;
            case 1:
            default:
                return -this.mHeight;
            case 2:
                return (((fontMetricsInt.descent - fontMetricsInt.ascent) - this.mHeight) / 2) + fontMetricsInt.ascent;
        }
    }
}
