package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes15.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean pCu;
    float pCv;
    private boolean pCw;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.pCv = 0.0f;
        this.pCw = false;
        this.mInterval = i;
        this.pCu = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.pCv;
        if (!this.pCu) {
            f = 360.0f - this.pCv;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        euj();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pCw = false;
        this.pCv += euk();
        invalidateSelf();
    }

    private void euj() {
        if (!this.pCw) {
            this.pCw = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int euk() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
