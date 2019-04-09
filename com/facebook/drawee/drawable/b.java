package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes2.dex */
public class b extends g implements Runnable {
    private int Ev;
    private boolean jCo;
    float jCp;
    private boolean jCq;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.jCp = 0.0f;
        this.jCq = false;
        this.Ev = i;
        this.jCo = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.jCp;
        if (!this.jCo) {
            f = 360.0f - this.jCp;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        cvj();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jCq = false;
        this.jCp += cvk();
        invalidateSelf();
    }

    private void cvj() {
        if (!this.jCq) {
            this.jCq = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int cvk() {
        return (int) ((20.0f / this.Ev) * 360.0f);
    }
}
