package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Cd;
    private boolean jVh;
    float jVi;
    private boolean jVj;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jVi = 0.0f;
        this.jVj = false;
        this.Cd = i;
        this.jVh = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.jVi;
        if (!this.jVh) {
            f = 360.0f - this.jVi;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cDg();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jVj = false;
        this.jVi += cDh();
        invalidateSelf();
    }

    private void cDg() {
        if (!this.jVj) {
            this.jVj = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cDh() {
        return (int) ((20.0f / this.Cd) * 360.0f);
    }
}
