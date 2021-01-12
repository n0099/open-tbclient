package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
/* loaded from: classes4.dex */
public class a extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f9523a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f9524b;
    private float c;

    public void a(float f) {
        this.c = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.c == 0.0f) {
            this.f9524b.setBounds(getBounds());
            this.f9524b.draw(canvas);
            super.draw(canvas);
            return;
        }
        if (this.f9523a.getBounds().width() != getBounds().width()) {
            this.f9523a.setBounds(getBounds());
        }
        if (this.f9524b.getBounds().width() != getBounds().width()) {
            this.f9524b.setBounds(getBounds());
        }
        canvas.save();
        int width = (int) (getBounds().width() * this.c);
        canvas.clipRect(0, 0, width, getBounds().height());
        this.f9523a.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.clipRect(width, 0, getBounds().width(), getBounds().height());
        this.f9524b.draw(canvas);
        canvas.restore();
        super.draw(canvas);
    }
}
