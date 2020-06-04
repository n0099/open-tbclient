package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes13.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean mqm;
    float mqn;
    private boolean mqo;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mqn = 0.0f;
        this.mqo = false;
        this.mInterval = i;
        this.mqm = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.mqn;
        if (!this.mqm) {
            f = 360.0f - this.mqn;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dwo();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mqo = false;
        this.mqn += dwp();
        invalidateSelf();
    }

    private void dwo() {
        if (!this.mqo) {
            this.mqo = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dwp() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
