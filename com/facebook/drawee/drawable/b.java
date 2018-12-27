package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Ew;
    private boolean ilY;
    float ilZ;
    private boolean ima;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.ilZ = 0.0f;
        this.ima = false;
        this.Ew = i;
        this.ilY = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.ilZ;
        if (!this.ilY) {
            f = 360.0f - this.ilZ;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        bVw();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ima = false;
        this.ilZ += bVx();
        invalidateSelf();
    }

    private void bVw() {
        if (!this.ima) {
            this.ima = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int bVx() {
        return (int) ((20.0f / this.Ew) * 360.0f);
    }
}
