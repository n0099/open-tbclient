package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Es;
    private boolean hZR;
    float hZS;
    private boolean hZT;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.hZS = 0.0f;
        this.hZT = false;
        this.Es = i;
        this.hZR = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.hZS;
        if (!this.hZR) {
            f = 360.0f - this.hZS;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        bTf();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hZT = false;
        this.hZS += bTg();
        invalidateSelf();
    }

    private void bTf() {
        if (!this.hZT) {
            this.hZT = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int bTg() {
        return (int) ((20.0f / this.Es) * 360.0f);
    }
}
