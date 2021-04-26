package com.facebook.widget.text.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes6.dex */
public class BetterImageSpan extends ReplacementSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    public final int mAlignment;
    public Rect mBounds;
    public final Drawable mDrawable;
    public final Paint.FontMetricsInt mFontMetricsInt;
    public int mHeight;
    public int mWidth;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface BetterImageSpanAlignment {
    }

    public BetterImageSpan(Drawable drawable) {
        this(drawable, 1);
    }

    private int getOffsetAboveBaseline(Paint.FontMetricsInt fontMetricsInt) {
        int i2 = this.mAlignment;
        if (i2 != 0) {
            if (i2 != 2) {
                return -this.mHeight;
            }
            int i3 = fontMetricsInt.descent;
            int i4 = fontMetricsInt.ascent;
            return i4 + (((i3 - i4) - this.mHeight) / 2);
        }
        return fontMetricsInt.descent - this.mHeight;
    }

    public static final int normalizeAlignment(int i2) {
        if (i2 != 0) {
            return i2 != 2 ? 1 : 2;
        }
        return 0;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        paint.getFontMetricsInt(this.mFontMetricsInt);
        int offsetAboveBaseline = i5 + getOffsetAboveBaseline(this.mFontMetricsInt);
        canvas.translate(f2, offsetAboveBaseline);
        this.mDrawable.draw(canvas);
        canvas.translate(-f2, -offsetAboveBaseline);
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        updateBounds();
        if (fontMetricsInt == null) {
            return this.mWidth;
        }
        int offsetAboveBaseline = getOffsetAboveBaseline(fontMetricsInt);
        int i4 = this.mHeight + offsetAboveBaseline;
        if (offsetAboveBaseline < fontMetricsInt.ascent) {
            fontMetricsInt.ascent = offsetAboveBaseline;
        }
        if (offsetAboveBaseline < fontMetricsInt.top) {
            fontMetricsInt.top = offsetAboveBaseline;
        }
        if (i4 > fontMetricsInt.descent) {
            fontMetricsInt.descent = i4;
        }
        if (i4 > fontMetricsInt.bottom) {
            fontMetricsInt.bottom = i4;
        }
        return this.mWidth;
    }

    public void updateBounds() {
        Rect bounds = this.mDrawable.getBounds();
        this.mBounds = bounds;
        this.mWidth = bounds.width();
        this.mHeight = this.mBounds.height();
    }

    public BetterImageSpan(Drawable drawable, int i2) {
        this.mFontMetricsInt = new Paint.FontMetricsInt();
        this.mDrawable = drawable;
        this.mAlignment = i2;
        updateBounds();
    }
}
