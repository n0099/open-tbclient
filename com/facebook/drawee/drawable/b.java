package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes15.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean pwF;
    float pwG;
    private boolean pwH;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pwG = 0.0f;
        this.pwH = false;
        this.mInterval = i;
        this.pwF = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.pwG;
        if (!this.pwF) {
            f = 360.0f - this.pwG;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        evD();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pwH = false;
        this.pwG += evE();
        invalidateSelf();
    }

    private void evD() {
        if (!this.pwH) {
            this.pwH = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int evE() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
