package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Ev;
    private boolean jCT;
    float jCU;
    private boolean jCV;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jCU = 0.0f;
        this.jCV = false;
        this.Ev = i;
        this.jCT = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.jCU;
        if (!this.jCT) {
            f = 360.0f - this.jCU;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cvq();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jCV = false;
        this.jCU += cvr();
        invalidateSelf();
    }

    private void cvq() {
        if (!this.jCV) {
            this.jCV = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cvr() {
        return (int) ((20.0f / this.Ev) * 360.0f);
    }
}
