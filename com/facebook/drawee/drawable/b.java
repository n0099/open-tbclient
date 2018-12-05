package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Ew;
    private boolean iiO;
    float iiP;
    private boolean iiQ;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.iiP = 0.0f;
        this.iiQ = false;
        this.Ew = i;
        this.iiO = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.iiP;
        if (!this.iiO) {
            f = 360.0f - this.iiP;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        bUG();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.iiQ = false;
        this.iiP += bUH();
        invalidateSelf();
    }

    private void bUG() {
        if (!this.iiQ) {
            this.iiQ = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int bUH() {
        return (int) ((20.0f / this.Ew) * 360.0f);
    }
}
