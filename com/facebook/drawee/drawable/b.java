package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Ce;
    private boolean jVd;
    float jVe;
    private boolean jVf;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jVe = 0.0f;
        this.jVf = false;
        this.Ce = i;
        this.jVd = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.jVe;
        if (!this.jVd) {
            f = 360.0f - this.jVe;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cDf();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jVf = false;
        this.jVe += cDg();
        invalidateSelf();
    }

    private void cDf() {
        if (!this.jVf) {
            this.jVf = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cDg() {
        return (int) ((20.0f / this.Ce) * 360.0f);
    }
}
