package com.kwad.sdk.emotion.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c extends ImageSpan {

    /* renamed from: a  reason: collision with root package name */
    private Paint.FontMetricsInt f10064a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Drawable> f10065b;

    public c(Drawable drawable, String str, View view) {
        super(drawable, str);
        this.f10064a = new Paint.FontMetricsInt();
        drawable.setCallback(view);
    }

    private Drawable a() {
        if (this.f10065b == null || this.f10065b.get() == null) {
            this.f10065b = new WeakReference<>(getDrawable());
        }
        return this.f10065b.get();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable a2 = a();
        if (paint instanceof TextPaint) {
            a2.setState(((TextPaint) paint).drawableState);
        }
        int fontMetricsInt = (paint.getFontMetricsInt(this.f10064a) - (a2.getBounds().bottom - a2.getBounds().top)) / 2;
        canvas.save();
        canvas.translate(f, fontMetricsInt + this.f10064a.ascent + i4);
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = a().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i4 = bounds.bottom - bounds.top;
            int i5 = (i4 / 2) - (i3 / 4);
            int i6 = (i3 / 4) + (i4 / 2);
            fontMetricsInt.ascent = -i6;
            fontMetricsInt.top = -i6;
            fontMetricsInt.bottom = i5;
            fontMetricsInt.descent = i5;
        }
        return (int) (bounds.right * 1.1d);
    }
}
