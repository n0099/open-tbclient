package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes14.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean oQo;
    float oQp;
    private boolean oQq;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.oQp = 0.0f;
        this.oQq = false;
        this.mInterval = i;
        this.oQo = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.oQp;
        if (!this.oQo) {
            f = 360.0f - this.oQp;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        elL();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.oQq = false;
        this.oQp += elM();
        invalidateSelf();
    }

    private void elL() {
        if (!this.oQq) {
            this.oQq = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int elM() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
