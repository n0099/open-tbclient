package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes11.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean nyF;
    float nyG;
    private boolean nyH;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.nyG = 0.0f;
        this.nyH = false;
        this.mInterval = i;
        this.nyF = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.nyG;
        if (!this.nyF) {
            f = 360.0f - this.nyG;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dUp();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.nyH = false;
        this.nyG += dUq();
        invalidateSelf();
    }

    private void dUp() {
        if (!this.nyH) {
            this.nyH = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dUq() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
