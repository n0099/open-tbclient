package com.kwad.sdk.core.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
/* loaded from: classes6.dex */
public class a extends GradientDrawable {

    /* renamed from: a  reason: collision with root package name */
    public Drawable f34636a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable f34637b;

    /* renamed from: c  reason: collision with root package name */
    public float f34638c;

    public void a(float f2) {
        this.f34638c = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f34638c == 0.0f) {
            this.f34637b.setBounds(getBounds());
            this.f34637b.draw(canvas);
        } else {
            if (this.f34636a.getBounds().width() != getBounds().width()) {
                this.f34636a.setBounds(getBounds());
            }
            if (this.f34637b.getBounds().width() != getBounds().width()) {
                this.f34637b.setBounds(getBounds());
            }
            canvas.save();
            int width = (int) (getBounds().width() * this.f34638c);
            canvas.clipRect(0, 0, width, getBounds().height());
            this.f34636a.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.clipRect(width, 0, getBounds().width(), getBounds().height());
            this.f34637b.draw(canvas);
            canvas.restore();
        }
        super.draw(canvas);
    }
}
