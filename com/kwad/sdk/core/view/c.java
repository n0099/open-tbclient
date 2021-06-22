package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class c extends ImageSpan {

    /* renamed from: a  reason: collision with root package name */
    public boolean f34996a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f34997b;

    /* renamed from: c  reason: collision with root package name */
    public Paint.FontMetricsInt f34998c;

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Drawable> f34999d;

    public c(Drawable drawable, String str) {
        super(drawable, str, 1);
        this.f34996a = true;
        this.f34998c = new Paint.FontMetricsInt();
    }

    private Drawable a(Paint paint) {
        WeakReference<Drawable> weakReference = this.f34999d;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            drawable = getDrawable();
            if (this.f34996a) {
                int fontMetricsInt = paint.getFontMetricsInt(null);
                drawable.setBounds(0, 0, fontMetricsInt, fontMetricsInt);
            } else {
                Rect rect = this.f34997b;
                if (rect != null) {
                    drawable.setBounds(rect);
                }
            }
            this.f34999d = new WeakReference<>(drawable);
        }
        return drawable;
    }

    public c a(int i2, int i3) {
        this.f34996a = false;
        this.f34997b = new Rect(0, 0, i2, i3);
        return this;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, @NonNull Paint paint) {
        Drawable a2 = a(paint);
        if (paint instanceof TextPaint) {
            a2.setState(((TextPaint) paint).drawableState);
        }
        int fontMetricsInt = paint.getFontMetricsInt(this.f34998c);
        canvas.save();
        canvas.translate(f2, i5 + this.f34998c.ascent + ((fontMetricsInt - (a2.getBounds().bottom - a2.getBounds().top)) / 2));
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
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
