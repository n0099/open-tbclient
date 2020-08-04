package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes9.dex */
public class b extends g implements Runnable {
    private int mInterval;
    float mUA;
    private boolean mUB;
    private boolean mUz;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.mUA = 0.0f;
        this.mUB = false;
        this.mInterval = i;
        this.mUz = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.mUA;
        if (!this.mUz) {
            f = 360.0f - this.mUA;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dEi();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mUB = false;
        this.mUA += dEj();
        invalidateSelf();
    }

    private void dEi() {
        if (!this.mUB) {
            this.mUB = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dEj() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
