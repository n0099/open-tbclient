package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
/* loaded from: classes5.dex */
public class a extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f9823a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f9824b;
    private float c;

    public void a(float f) {
        this.c = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.c == 0.0f) {
            this.f9824b.setBounds(getBounds());
            this.f9824b.draw(canvas);
            super.draw(canvas);
            return;
        }
        if (this.f9823a.getBounds().width() != getBounds().width()) {
            this.f9823a.setBounds(getBounds());
        }
        if (this.f9824b.getBounds().width() != getBounds().width()) {
            this.f9824b.setBounds(getBounds());
        }
        canvas.save();
        int width = (int) (getBounds().width() * this.c);
        canvas.clipRect(0, 0, width, getBounds().height());
        this.f9823a.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.clipRect(width, 0, getBounds().width(), getBounds().height());
        this.f9824b.draw(canvas);
        canvas.restore();
        super.draw(canvas);
    }
}
