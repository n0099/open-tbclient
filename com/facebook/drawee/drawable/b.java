package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes4.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean pwM;
    float pwN;
    private boolean pwO;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pwN = 0.0f;
        this.pwO = false;
        this.mInterval = i;
        this.pwM = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.pwN;
        if (!this.pwM) {
            f = 360.0f - this.pwN;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        evK();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pwO = false;
        this.pwN += evL();
        invalidateSelf();
    }

    private void evK() {
        if (!this.pwO) {
            this.pwO = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int evL() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
