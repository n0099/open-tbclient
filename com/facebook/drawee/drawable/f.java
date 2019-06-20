package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    long aej;
    private final Drawable[] jVb;
    int jVn;
    int jVo;
    int[] jVp;
    int[] jVq;
    boolean[] jVr;
    int jVs;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.jVb = drawableArr;
        this.jVp = new int[drawableArr.length];
        this.jVq = new int[drawableArr.length];
        this.mAlpha = 255;
        this.jVr = new boolean[drawableArr.length];
        this.jVs = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jVs == 0) {
            super.invalidateSelf();
        }
    }

    public void cDi() {
        this.jVs++;
    }

    public void cDj() {
        this.jVs--;
        invalidateSelf();
    }

    public void CY(int i) {
        this.jVo = i;
        if (this.jVn == 1) {
            this.jVn = 0;
        }
    }

    private void resetInternal() {
        this.jVn = 2;
        Arrays.fill(this.jVp, 0);
        this.jVp[0] = 255;
        Arrays.fill(this.jVq, 0);
        this.jVq[0] = 255;
        Arrays.fill(this.jVr, false);
        this.jVr[0] = true;
    }

    public void CZ(int i) {
        this.jVn = 0;
        this.jVr[i] = true;
        invalidateSelf();
    }

    public void Da(int i) {
        this.jVn = 0;
        this.jVr[i] = false;
        invalidateSelf();
    }

    public void cDk() {
        this.jVn = 0;
        Arrays.fill(this.jVr, true);
        invalidateSelf();
    }

    public void cDl() {
        this.jVn = 2;
        for (int i = 0; i < this.jVb.length; i++) {
            this.jVq[i] = this.jVr[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aY(float f) {
        boolean z = true;
        for (int i = 0; i < this.jVb.length; i++) {
            this.jVq[i] = (int) (((this.jVr[i] ? 1 : -1) * 255 * f) + this.jVp[i]);
            if (this.jVq[i] < 0) {
                this.jVq[i] = 0;
            }
            if (this.jVq[i] > 255) {
                this.jVq[i] = 255;
            }
            if (this.jVr[i] && this.jVq[i] < 255) {
                z = false;
            }
            if (!this.jVr[i] && this.jVq[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.jVn) {
            case 0:
                System.arraycopy(this.jVq, 0, this.jVp, 0, this.jVb.length);
                this.aej = cDm();
                boolean aY = aY(this.jVo == 0 ? 1.0f : 0.0f);
                this.jVn = aY ? 2 : 1;
                z = aY;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.jVo > 0);
                boolean aY2 = aY(((float) (cDm() - this.aej)) / this.jVo);
                this.jVn = aY2 ? 2 : 1;
                z = aY2;
                break;
        }
        for (int i = 0; i < this.jVb.length; i++) {
            a(canvas, this.jVb[i], (this.jVq[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.jVs++;
            drawable.mutate().setAlpha(i);
            this.jVs--;
            drawable.draw(canvas);
        }
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.mAlpha != i) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    protected long cDm() {
        return SystemClock.uptimeMillis();
    }
}
