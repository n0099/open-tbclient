package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes15.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean oOK;
    float oOL;
    private boolean oOM;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.oOL = 0.0f;
        this.oOM = false;
        this.mInterval = i;
        this.oOK = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.oOL;
        if (!this.oOK) {
            f = 360.0f - this.oOL;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        elN();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.oOM = false;
        this.oOL += elO();
        invalidateSelf();
    }

    private void elN() {
        if (!this.oOM) {
            this.oOM = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int elO() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
