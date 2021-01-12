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
/* loaded from: classes4.dex */
public class e extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private TextPaint f9025a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f9026b;
    private float c;
    private StaticLayout d;
    private int e;

    public e() {
        this.f9025a.setColor(-1);
        this.f9025a.setTextAlign(Paint.Align.CENTER);
    }

    public void a(float f) {
        this.f9025a.setTextSize(f);
    }

    public void a(int i) {
        this.f9025a.setColor(i);
    }

    public void a(CharSequence charSequence) {
        this.f9026b = charSequence;
        if (!TextUtils.isEmpty(this.f9026b)) {
            this.c = this.f9025a.measureText((String) this.f9026b);
        }
        this.d = new StaticLayout(this.f9026b, this.f9025a, 200, Layout.Alignment.ALIGN_NORMAL, 1.0f, 1.0f, true);
    }

    public void b(int i) {
        this.e = i;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        canvas.save();
        canvas.translate(bounds.width() >= this.e ? bounds.right - (this.e / 2) : bounds.left + (this.e / 2), bounds.centerY() - (this.c / 2.0f));
        this.d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.e;
    }
}
