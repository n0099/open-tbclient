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
    public TextPaint f33786a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f33787b;

    /* renamed from: c  reason: collision with root package name */
    public float f33788c;

    /* renamed from: d  reason: collision with root package name */
    public StaticLayout f33789d;

    /* renamed from: e  reason: collision with root package name */
    public int f33790e;

    public e() {
        TextPaint textPaint = new TextPaint(1);
        this.f33786a = textPaint;
        textPaint.setColor(-1);
        this.f33786a.setTextAlign(Paint.Align.CENTER);
    }

    public void a(float f2) {
        this.f33786a.setTextSize(f2);
    }

    public void a(int i) {
        this.f33786a.setColor(i);
    }

    public void a(CharSequence charSequence) {
        this.f33787b = charSequence;
        if (!TextUtils.isEmpty(charSequence)) {
            this.f33788c = this.f33786a.measureText((String) this.f33787b);
        }
        this.f33789d = new StaticLayout(this.f33787b, this.f33786a, 200, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
    }

    public void b(int i) {
        this.f33790e = i;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        canvas.save();
        int width = bounds.width();
        int i = this.f33790e;
        canvas.translate(width >= i ? bounds.right - (i / 2) : bounds.left + (i / 2), bounds.centerY() - (this.f33788c / 2.0f));
        this.f33789d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f33790e;
    }
}
