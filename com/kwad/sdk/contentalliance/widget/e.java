package com.kwad.sdk.contentalliance.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class e extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    public TextPaint f33401a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f33402b;

    /* renamed from: c  reason: collision with root package name */
    public float f33403c;

    /* renamed from: d  reason: collision with root package name */
    public StaticLayout f33404d;

    /* renamed from: e  reason: collision with root package name */
    public int f33405e;

    public e() {
        TextPaint textPaint = new TextPaint(1);
        this.f33401a = textPaint;
        textPaint.setColor(-1);
        this.f33401a.setTextAlign(Paint.Align.CENTER);
    }

    public void a(float f2) {
        this.f33401a.setTextSize(f2);
    }

    public void a(int i) {
        this.f33401a.setColor(i);
    }

    public void a(CharSequence charSequence) {
        this.f33402b = charSequence;
        if (!TextUtils.isEmpty(charSequence)) {
            this.f33403c = this.f33401a.measureText((String) this.f33402b);
        }
        this.f33404d = new StaticLayout(this.f33402b, this.f33401a, 200, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
    }

    public void b(int i) {
        this.f33405e = i;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        canvas.save();
        int width = bounds.width();
        int i = this.f33405e;
        canvas.translate(width >= i ? bounds.right - (i / 2) : bounds.left + (i / 2), bounds.centerY() - (this.f33403c / 2.0f));
        this.f33404d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f33405e;
    }
}
