package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private boolean kdX;
    float kdY;
    private boolean kdZ;
    private int mInterval;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.kdY = 0.0f;
        this.kdZ = false;
        this.mInterval = i;
        this.kdX = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.kdY;
        if (!this.kdX) {
            f = 360.0f - this.kdY;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cEp();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.kdZ = false;
        this.kdY += cEq();
        invalidateSelf();
    }

    private void cEp() {
        if (!this.kdZ) {
            this.kdZ = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cEq() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
