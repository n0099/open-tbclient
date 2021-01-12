package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes3.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean psk;
    float psl;
    private boolean psm;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.psl = 0.0f;
        this.psm = false;
        this.mInterval = i;
        this.psk = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.psl;
        if (!this.psk) {
            f = 360.0f - this.psl;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        erR();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.psm = false;
        this.psl += erS();
        invalidateSelf();
    }

    private void erR() {
        if (!this.psm) {
            this.psm = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int erS() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
