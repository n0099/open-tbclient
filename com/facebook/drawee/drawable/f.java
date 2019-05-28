package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    long aej;
    private final Drawable[] jUY;
    int jVk;
    int jVl;
    int[] jVm;
    int[] jVn;
    boolean[] jVo;
    int jVp;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.jUY = drawableArr;
        this.jVm = new int[drawableArr.length];
        this.jVn = new int[drawableArr.length];
        this.mAlpha = 255;
        this.jVo = new boolean[drawableArr.length];
        this.jVp = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jVp == 0) {
            super.invalidateSelf();
        }
    }

    public void cDj() {
        this.jVp++;
    }

    public void cDk() {
        this.jVp--;
        invalidateSelf();
    }

    public void CY(int i) {
        this.jVl = i;
        if (this.jVk == 1) {
            this.jVk = 0;
        }
    }

    private void resetInternal() {
        this.jVk = 2;
        Arrays.fill(this.jVm, 0);
        this.jVm[0] = 255;
        Arrays.fill(this.jVn, 0);
        this.jVn[0] = 255;
        Arrays.fill(this.jVo, false);
        this.jVo[0] = true;
    }

    public void CZ(int i) {
        this.jVk = 0;
        this.jVo[i] = true;
        invalidateSelf();
    }

    public void Da(int i) {
        this.jVk = 0;
        this.jVo[i] = false;
        invalidateSelf();
    }

    public void cDl() {
        this.jVk = 0;
        Arrays.fill(this.jVo, true);
        invalidateSelf();
    }

    public void cDm() {
        this.jVk = 2;
        for (int i = 0; i < this.jUY.length; i++) {
            this.jVn[i] = this.jVo[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aY(float f) {
        boolean z = true;
        for (int i = 0; i < this.jUY.length; i++) {
            this.jVn[i] = (int) (((this.jVo[i] ? 1 : -1) * 255 * f) + this.jVm[i]);
            if (this.jVn[i] < 0) {
                this.jVn[i] = 0;
            }
            if (this.jVn[i] > 255) {
                this.jVn[i] = 255;
            }
            if (this.jVo[i] && this.jVn[i] < 255) {
                z = false;
            }
            if (!this.jVo[i] && this.jVn[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.jVk) {
            case 0:
                System.arraycopy(this.jVn, 0, this.jVm, 0, this.jUY.length);
                this.aej = cDn();
                boolean aY = aY(this.jVl == 0 ? 1.0f : 0.0f);
                this.jVk = aY ? 2 : 1;
                z = aY;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.jVl > 0);
                boolean aY2 = aY(((float) (cDn() - this.aej)) / this.jVl);
                this.jVk = aY2 ? 2 : 1;
                z = aY2;
                break;
        }
        for (int i = 0; i < this.jUY.length; i++) {
            a(canvas, this.jUY[i], (this.jVn[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.jVp++;
            drawable.mutate().setAlpha(i);
            this.jVp--;
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

    protected long cDn() {
        return SystemClock.uptimeMillis();
    }
}
