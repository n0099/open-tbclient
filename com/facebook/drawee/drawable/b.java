package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
/* loaded from: classes4.dex */
public class b extends g implements Runnable {
    private int mInterval;
    private boolean non;
    float noo;
    private boolean nop;

    public b(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    public b(Drawable drawable, int i, boolean z) {
        super((Drawable) com.facebook.common.internal.g.checkNotNull(drawable));
        this.noo = 0.0f;
        this.nop = false;
        this.mInterval = i;
        this.non = z;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.noo;
        if (!this.non) {
            f = 360.0f - this.noo;
        }
        canvas.rotate(f, (i / 2) + bounds.left, bounds.top + (i2 / 2));
        super.draw(canvas);
        canvas.restoreToCount(save);
        dQi();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.nop = false;
        this.noo += dQj();
        invalidateSelf();
    }

    private void dQi() {
        if (!this.nop) {
            this.nop = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    private int dQj() {
        return (int) ((20.0f / this.mInterval) * 360.0f);
    }
}
