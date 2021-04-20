package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
/* loaded from: classes6.dex */
public class a extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f34541a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f34542b;

    /* renamed from: c  reason: collision with root package name */
    public float f34543c;

    public void a(float f2) {
        this.f34543c = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f34543c == 0.0f) {
            this.f34542b.setBounds(getBounds());
            this.f34542b.draw(canvas);
        } else {
            if (this.f34541a.getBounds().width() != getBounds().width()) {
                this.f34541a.setBounds(getBounds());
            }
            if (this.f34542b.getBounds().width() != getBounds().width()) {
                this.f34542b.setBounds(getBounds());
            }
            canvas.save();
            int width = (int) (getBounds().width() * this.f34543c);
            canvas.clipRect(0, 0, width, getBounds().height());
            this.f34541a.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.clipRect(width, 0, getBounds().width(), getBounds().height());
            this.f34542b.draw(canvas);
            canvas.restore();
        }
        super.draw(canvas);
    }
}
