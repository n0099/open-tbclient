package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes13.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean mpc;
    float mpd;
    private boolean mpe;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mpd = 0.0f;
        this.mpe = false;
        this.mInterval = i;
        this.mpc = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.mpd;
        if (!this.mpc) {
            f = 360.0f - this.mpd;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dwa();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mpe = false;
        this.mpd += dwb();
        invalidateSelf();
    }

    private void dwa() {
        if (!this.mpe) {
            this.mpe = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dwb() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
