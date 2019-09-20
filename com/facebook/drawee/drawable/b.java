package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Cj;
    private boolean kfP;
    float kfQ;
    private boolean kfR;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.kfQ = 0.0f;
        this.kfR = false;
        this.Cj = i;
        this.kfP = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.kfQ;
        if (!this.kfP) {
            f = 360.0f - this.kfQ;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cHr();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.kfR = false;
        this.kfQ += cHs();
        invalidateSelf();
    }

    private void cHr() {
        if (!this.kfR) {
            this.kfR = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cHs() {
        return (int) ((20.0f / this.Cj) * 360.0f);
    }
}
