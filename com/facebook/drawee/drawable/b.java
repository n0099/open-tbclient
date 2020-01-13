package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes12.dex */
public class b extends g implements Runnable {
    private boolean lLg;
    float lLh;
    private boolean lLi;
    private int mInterval;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lLh = 0.0f;
        this.lLi = false;
        this.mInterval = i;
        this.lLg = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.lLh;
        if (!this.lLg) {
            f = 360.0f - this.lLh;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dlb();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.lLi = false;
        this.lLh += dlc();
        invalidateSelf();
    }

    private void dlb() {
        if (!this.lLi) {
            this.lLi = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dlc() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
