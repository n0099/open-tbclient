package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class c extends ImageSpan {

    /* renamed from: a  reason: collision with root package name */
    private boolean f9526a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f9527b;
    private Paint.FontMetricsInt c;
    private WeakReference<Drawable> d;

    public c(Drawable drawable, String str) {
        super(drawable, str, 1);
        this.f9526a = true;
        this.c = new Paint.FontMetricsInt();
    }

    private Drawable a(Paint paint) {
        WeakReference<Drawable> weakReference = this.d;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            drawable = getDrawable();
            if (this.f9526a) {
                int fontMetricsInt = paint.getFontMetricsInt(null);
                drawable.setBounds(0, 0, fontMetricsInt, fontMetricsInt);
            } else if (this.f9527b != null) {
                drawable.setBounds(this.f9527b);
            }
            this.d = new WeakReference<>(drawable);
        }
        return drawable;
    }

    public c a(int i, int i2) {
        this.f9526a = false;
        this.f9527b = new Rect(0, 0, i, i2);
        return this;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Drawable a2 = a(paint);
        if (paint instanceof TextPaint) {
            a2.setState(((TextPaint) paint).drawableState);
        }
        int fontMetricsInt = (paint.getFontMetricsInt(this.c) - (a2.getBounds().bottom - a2.getBounds().top)) / 2;
        canvas.save();
        canvas.translate(f, fontMetricsInt + this.c.ascent + i4);
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = a(paint).getBounds();
        if (fontMetricsInt != null) {
            paint.getFontMetricsInt(fontMetricsInt);
            fontMetricsInt.ascent = fontMetricsInt.ascent;
            fontMetricsInt.descent = fontMetricsInt.descent;
            fontMetricsInt.top = fontMetricsInt.top;
            fontMetricsInt.bottom = fontMetricsInt.bottom;
        }
        return bounds.right;
    }
}
