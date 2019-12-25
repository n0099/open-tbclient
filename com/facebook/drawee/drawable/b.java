package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes11.dex */
public class b extends g implements Runnable {
    private boolean lHI;
    float lHJ;
    private boolean lHK;
    private int mInterval;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lHJ = 0.0f;
        this.lHK = false;
        this.mInterval = i;
        this.lHI = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.lHJ;
        if (!this.lHI) {
            f = 360.0f - this.lHJ;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dka();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.lHK = false;
        this.lHJ += dkb();
        invalidateSelf();
    }

    private void dka() {
        if (!this.lHK) {
            this.lHK = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dkb() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
