package com.kwad.sdk.emotion.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class c extends ImageSpan {

    /* renamed from: a  reason: collision with root package name */
    public Paint.FontMetricsInt f35360a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<Drawable> f35361b;

    public c(Drawable drawable, String str, View view) {
        super(drawable, str);
        this.f35360a = new Paint.FontMetricsInt();
        drawable.setCallback(view);
    }

    private Drawable a() {
        WeakReference<Drawable> weakReference = this.f35361b;
        if (weakReference == null || weakReference.get() == null) {
            this.f35361b = new WeakReference<>(getDrawable());
        }
        return this.f35361b.get();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable a2 = a();
        if (paint instanceof TextPaint) {
            a2.setState(((TextPaint) paint).drawableState);
        }
        int fontMetricsInt = paint.getFontMetricsInt(this.f35360a);
        canvas.save();
        canvas.translate(f2, i5 + this.f35360a.ascent + ((fontMetricsInt - (a2.getBounds().bottom - a2.getBounds().top)) / 2));
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = a().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i4 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i5 = (bounds.bottom - bounds.top) / 2;
            int i6 = i4 / 4;
            int i7 = i5 - i6;
            int i8 = -(i5 + i6);
            fontMetricsInt.ascent = i8;
            fontMetricsInt.top = i8;
            fontMetricsInt.bottom = i7;
            fontMetricsInt.descent = i7;
        }
        return (int) (bounds.right * 1.1d);
    }
}
