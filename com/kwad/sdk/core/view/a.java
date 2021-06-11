package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
/* loaded from: classes7.dex */
public class a extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f34894a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f34895b;

    /* renamed from: c  reason: collision with root package name */
    public float f34896c;

    public void a(float f2) {
        this.f34896c = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f34896c == 0.0f) {
            this.f34895b.setBounds(getBounds());
            this.f34895b.draw(canvas);
        } else {
            if (this.f34894a.getBounds().width() != getBounds().width()) {
                this.f34894a.setBounds(getBounds());
            }
            if (this.f34895b.getBounds().width() != getBounds().width()) {
                this.f34895b.setBounds(getBounds());
            }
            canvas.save();
            int width = (int) (getBounds().width() * this.f34896c);
            canvas.clipRect(0, 0, width, getBounds().height());
            this.f34894a.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.clipRect(width, 0, getBounds().width(), getBounds().height());
            this.f34895b.draw(canvas);
            canvas.restore();
        }
        super.draw(canvas);
    }
}
