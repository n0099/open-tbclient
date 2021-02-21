package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes15.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean pCU;
    float pCV;
    private boolean pCW;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pCV = 0.0f;
        this.pCW = false;
        this.mInterval = i;
        this.pCU = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.pCV;
        if (!this.pCU) {
            f = 360.0f - this.pCV;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        eur();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pCW = false;
        this.pCV += eus();
        invalidateSelf();
    }

    private void eur() {
        if (!this.pCW) {
            this.pCW = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int eus() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
