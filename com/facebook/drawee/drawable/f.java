package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    long aej;
    private final Drawable[] jUX;
    int jVj;
    int jVk;
    int[] jVl;
    int[] jVm;
    boolean[] jVn;
    int jVo;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.jUX = drawableArr;
        this.jVl = new int[drawableArr.length];
        this.jVm = new int[drawableArr.length];
        this.mAlpha = 255;
        this.jVn = new boolean[drawableArr.length];
        this.jVo = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jVo == 0) {
            super.invalidateSelf();
        }
    }

    public void cDh() {
        this.jVo++;
    }

    public void cDi() {
        this.jVo--;
        invalidateSelf();
    }

    public void CY(int i) {
        this.jVk = i;
        if (this.jVj == 1) {
            this.jVj = 0;
        }
    }

    private void resetInternal() {
        this.jVj = 2;
        Arrays.fill(this.jVl, 0);
        this.jVl[0] = 255;
        Arrays.fill(this.jVm, 0);
        this.jVm[0] = 255;
        Arrays.fill(this.jVn, false);
        this.jVn[0] = true;
    }

    public void CZ(int i) {
        this.jVj = 0;
        this.jVn[i] = true;
        invalidateSelf();
    }

    public void Da(int i) {
        this.jVj = 0;
        this.jVn[i] = false;
        invalidateSelf();
    }

    public void cDj() {
        this.jVj = 0;
        Arrays.fill(this.jVn, true);
        invalidateSelf();
    }

    public void cDk() {
        this.jVj = 2;
        for (int i = 0; i < this.jUX.length; i++) {
            this.jVm[i] = this.jVn[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aY(float f) {
        boolean z = true;
        for (int i = 0; i < this.jUX.length; i++) {
            this.jVm[i] = (int) (((this.jVn[i] ? 1 : -1) * 255 * f) + this.jVl[i]);
            if (this.jVm[i] < 0) {
                this.jVm[i] = 0;
            }
            if (this.jVm[i] > 255) {
                this.jVm[i] = 255;
            }
            if (this.jVn[i] && this.jVm[i] < 255) {
                z = false;
            }
            if (!this.jVn[i] && this.jVm[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.jVj) {
            case 0:
                System.arraycopy(this.jVm, 0, this.jVl, 0, this.jUX.length);
                this.aej = cDl();
                boolean aY = aY(this.jVk == 0 ? 1.0f : 0.0f);
                this.jVj = aY ? 2 : 1;
                z = aY;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.jVk > 0);
                boolean aY2 = aY(((float) (cDl() - this.aej)) / this.jVk);
                this.jVj = aY2 ? 2 : 1;
                z = aY2;
                break;
        }
        for (int i = 0; i < this.jUX.length; i++) {
            a(canvas, this.jUX[i], (this.jVm[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.jVo++;
            drawable.mutate().setAlpha(i);
            this.jVo--;
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

    protected long cDl() {
        return SystemClock.uptimeMillis();
    }
}
