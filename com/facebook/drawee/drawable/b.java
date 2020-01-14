package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes12.dex */
public class b extends g implements Runnable {
    private boolean lLl;
    float lLm;
    private boolean lLn;
    private int mInterval;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lLm = 0.0f;
        this.lLn = false;
        this.mInterval = i;
        this.lLl = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.lLm;
        if (!this.lLl) {
            f = 360.0f - this.lLm;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dld();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.lLn = false;
        this.lLm += dle();
        invalidateSelf();
    }

    private void dld() {
        if (!this.lLn) {
            this.lLn = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dle() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
