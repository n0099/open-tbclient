package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private boolean kdg;
    float kdh;
    private boolean kdi;
    private int mInterval;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.kdh = 0.0f;
        this.kdi = false;
        this.mInterval = i;
        this.kdg = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.kdh;
        if (!this.kdg) {
            f = 360.0f - this.kdh;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cEn();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.kdi = false;
        this.kdh += cEo();
        invalidateSelf();
    }

    private void cEn() {
        if (!this.kdi) {
            this.kdi = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cEo() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
