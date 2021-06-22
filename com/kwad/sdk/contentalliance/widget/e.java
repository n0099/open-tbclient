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
    public TextPaint f34119a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f34120b;

    /* renamed from: c  reason: collision with root package name */
    public float f34121c;

    /* renamed from: d  reason: collision with root package name */
    public StaticLayout f34122d;

    /* renamed from: e  reason: collision with root package name */
    public int f34123e;

    public e() {
        TextPaint textPaint = new TextPaint(1);
        this.f34119a = textPaint;
        textPaint.setColor(-1);
        this.f34119a.setTextAlign(Paint.Align.CENTER);
    }

    public void a(float f2) {
        this.f34119a.setTextSize(f2);
    }

    public void a(int i2) {
        this.f34119a.setColor(i2);
    }

    public void a(CharSequence charSequence) {
        this.f34120b = charSequence;
        if (!TextUtils.isEmpty(charSequence)) {
            this.f34121c = this.f34119a.measureText((String) this.f34120b);
        }
        this.f34122d = new StaticLayout(this.f34120b, this.f34119a, 200, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
    }

    public void b(int i2) {
        this.f34123e = i2;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        canvas.save();
        int width = bounds.width();
        int i2 = this.f34123e;
        canvas.translate(width >= i2 ? bounds.right - (i2 / 2) : bounds.left + (i2 / 2), bounds.centerY() - (this.f34121c / 2.0f));
        this.f34122d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f34123e;
    }
}
