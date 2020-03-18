package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes13.dex */
public class b extends g implements Runnable {
    private boolean lNL;
    float lNM;
    private boolean lNN;
    private int mInterval;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lNM = 0.0f;
        this.lNN = false;
        this.mInterval = i;
        this.lNL = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.lNM;
        if (!this.lNL) {
            f = 360.0f - this.lNM;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dmQ();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.lNN = false;
        this.lNM += dmR();
        invalidateSelf();
    }

    private void dmQ() {
        if (!this.lNN) {
            this.lNN = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dmR() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
