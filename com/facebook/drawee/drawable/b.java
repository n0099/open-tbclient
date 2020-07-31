package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes9.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean mUx;
    float mUy;
    private boolean mUz;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mUy = 0.0f;
        this.mUz = false;
        this.mInterval = i;
        this.mUx = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.mUy;
        if (!this.mUx) {
            f = 360.0f - this.mUy;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dEh();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mUz = false;
        this.mUy += dEi();
        invalidateSelf();
    }

    private void dEh() {
        if (!this.mUz) {
            this.mUz = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dEi() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
