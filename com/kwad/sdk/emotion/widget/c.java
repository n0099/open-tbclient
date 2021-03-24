package com.kwad.sdk.emotion.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class c extends ImageSpan {

    /* renamed from: a  reason: collision with root package name */
    public Paint.FontMetricsInt f34702a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Drawable> f34703b;

    public c(Drawable drawable, String str, View view) {
        super(drawable, str);
        this.f34702a = new Paint.FontMetricsInt();
        drawable.setCallback(view);
    }

    private Drawable a() {
        WeakReference<Drawable> weakReference = this.f34703b;
        if (weakReference == null || weakReference.get() == null) {
            this.f34703b = new WeakReference<>(getDrawable());
        }
        return this.f34703b.get();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        Drawable a2 = a();
        if (paint instanceof TextPaint) {
            a2.setState(((TextPaint) paint).drawableState);
        }
        int fontMetricsInt = paint.getFontMetricsInt(this.f34702a);
        canvas.save();
        canvas.translate(f2, i4 + this.f34702a.ascent + ((fontMetricsInt - (a2.getBounds().bottom - a2.getBounds().top)) / 2));
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = a().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i4 = (bounds.bottom - bounds.top) / 2;
            int i5 = i3 / 4;
            int i6 = i4 - i5;
            int i7 = -(i4 + i5);
            fontMetricsInt.ascent = i7;
            fontMetricsInt.top = i7;
            fontMetricsInt.bottom = i6;
            fontMetricsInt.descent = i6;
        }
        double d2 = bounds.right;
        Double.isNaN(d2);
        return (int) (d2 * 1.1d);
    }
}
