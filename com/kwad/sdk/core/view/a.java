package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
/* loaded from: classes3.dex */
public class a extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f6313a;
    private Drawable b;
    private float c;

    public void a(float f) {
        this.c = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.c == 0.0f) {
            this.b.setBounds(getBounds());
            this.b.draw(canvas);
            super.draw(canvas);
            return;
        }
        if (this.f6313a.getBounds().width() != getBounds().width()) {
            this.f6313a.setBounds(getBounds());
        }
        if (this.b.getBounds().width() != getBounds().width()) {
            this.b.setBounds(getBounds());
        }
        canvas.save();
        int width = (int) (getBounds().width() * this.c);
        canvas.clipRect(0, 0, width, getBounds().height());
        this.f6313a.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.clipRect(width, 0, getBounds().width(), getBounds().height());
        this.b.draw(canvas);
        canvas.restore();
        super.draw(canvas);
    }
}
