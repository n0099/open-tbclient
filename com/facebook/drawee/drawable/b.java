package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Ce;
    private boolean jVe;
    float jVf;
    private boolean jVg;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jVf = 0.0f;
        this.jVg = false;
        this.Ce = i;
        this.jVe = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.jVf;
        if (!this.jVe) {
            f = 360.0f - this.jVf;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cDh();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jVg = false;
        this.jVf += cDi();
        invalidateSelf();
    }

    private void cDh() {
        if (!this.jVg) {
            this.jVg = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cDi() {
        return (int) ((20.0f / this.Ce) * 360.0f);
    }
}
