package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes8.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean pfA;
    private boolean pfy;
    float pfz;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pfz = 0.0f;
        this.pfA = false;
        this.mInterval = i;
        this.pfy = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.pfz;
        if (!this.pfy) {
            f = 360.0f - this.pfz;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        erB();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pfA = false;
        this.pfz += erC();
        invalidateSelf();
    }

    private void erB() {
        if (!this.pfA) {
            this.pfA = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int erC() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
