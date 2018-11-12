package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Ew;
    private boolean ibB;
    float ibC;
    private boolean ibD;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.ibC = 0.0f;
        this.ibD = false;
        this.Ew = i;
        this.ibB = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.ibC;
        if (!this.ibB) {
            f = 360.0f - this.ibC;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        bSA();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ibD = false;
        this.ibC += bSB();
        invalidateSelf();
    }

    private void bSA() {
        if (!this.ibD) {
            this.ibD = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int bSB() {
        return (int) ((20.0f / this.Ew) * 360.0f);
    }
}
