package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes13.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean mMo;
    float mMp;
    private boolean mMq;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mMp = 0.0f;
        this.mMq = false;
        this.mInterval = i;
        this.mMo = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.mMp;
        if (!this.mMo) {
            f = 360.0f - this.mMp;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dAV();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mMq = false;
        this.mMp += dAW();
        invalidateSelf();
    }

    private void dAV() {
        if (!this.mMq) {
            this.mMq = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dAW() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
