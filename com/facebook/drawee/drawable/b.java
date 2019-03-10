package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Ev;
    private boolean jDb;
    float jDc;
    private boolean jDd;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jDc = 0.0f;
        this.jDd = false;
        this.Ev = i;
        this.jDb = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.jDc;
        if (!this.jDb) {
            f = 360.0f - this.jDc;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cvn();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jDd = false;
        this.jDc += cvo();
        invalidateSelf();
    }

    private void cvn() {
        if (!this.jDd) {
            this.jDd = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cvo() {
        return (int) ((20.0f / this.Ev) * 360.0f);
    }
}
