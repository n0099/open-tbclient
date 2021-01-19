package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes3.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean psl;
    float psm;
    private boolean psn;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.psm = 0.0f;
        this.psn = false;
        this.mInterval = i;
        this.psl = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.psm;
        if (!this.psl) {
            f = 360.0f - this.psm;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        erR();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.psn = false;
        this.psm += erS();
        invalidateSelf();
    }

    private void erR() {
        if (!this.psn) {
            this.psn = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int erS() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
