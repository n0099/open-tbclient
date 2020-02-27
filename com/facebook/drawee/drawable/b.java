package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes13.dex */
public class b extends g implements Runnable {
    private boolean lLS;
    float lLT;
    private boolean lLU;
    private int mInterval;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.lLT = 0.0f;
        this.lLU = false;
        this.mInterval = i;
        this.lLS = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.lLT;
        if (!this.lLS) {
            f = 360.0f - this.lLT;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dmq();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.lLU = false;
        this.lLT += dmr();
        invalidateSelf();
    }

    private void dmq() {
        if (!this.lLU) {
            this.lLU = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dmr() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
