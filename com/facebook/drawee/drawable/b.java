package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Cj;
    private boolean kdr;
    float kds;
    private boolean kdt;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.kds = 0.0f;
        this.kdt = false;
        this.Cj = i;
        this.kdr = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.kds;
        if (!this.kdr) {
            f = 360.0f - this.kds;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cGD();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.kdt = false;
        this.kds += cGE();
        invalidateSelf();
    }

    private void cGD() {
        if (!this.kdt) {
            this.kdt = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cGE() {
        return (int) ((20.0f / this.Cj) * 360.0f);
    }
}
