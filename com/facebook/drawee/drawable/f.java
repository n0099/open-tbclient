package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    int ibH;
    int ibI;
    long ibJ;
    int[] ibK;
    int[] ibL;
    boolean[] ibM;
    int ibN;
    private final Drawable[] ibv;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.ibv = drawableArr;
        this.ibK = new int[drawableArr.length];
        this.ibL = new int[drawableArr.length];
        this.mAlpha = 255;
        this.ibM = new boolean[drawableArr.length];
        this.ibN = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.ibN == 0) {
            super.invalidateSelf();
        }
    }

    public void bSC() {
        this.ibN++;
    }

    public void bSD() {
        this.ibN--;
        invalidateSelf();
    }

    public void xF(int i) {
        this.ibI = i;
        if (this.ibH == 1) {
            this.ibH = 0;
        }
    }

    private void resetInternal() {
        this.ibH = 2;
        Arrays.fill(this.ibK, 0);
        this.ibK[0] = 255;
        Arrays.fill(this.ibL, 0);
        this.ibL[0] = 255;
        Arrays.fill(this.ibM, false);
        this.ibM[0] = true;
    }

    public void xG(int i) {
        this.ibH = 0;
        this.ibM[i] = true;
        invalidateSelf();
    }

    public void xH(int i) {
        this.ibH = 0;
        this.ibM[i] = false;
        invalidateSelf();
    }

    public void bSE() {
        this.ibH = 0;
        Arrays.fill(this.ibM, true);
        invalidateSelf();
    }

    public void bSF() {
        this.ibH = 2;
        for (int i = 0; i < this.ibv.length; i++) {
            this.ibL[i] = this.ibM[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aH(float f) {
        boolean z = true;
        for (int i = 0; i < this.ibv.length; i++) {
            this.ibL[i] = (int) (((this.ibM[i] ? 1 : -1) * 255 * f) + this.ibK[i]);
            if (this.ibL[i] < 0) {
                this.ibL[i] = 0;
            }
            if (this.ibL[i] > 255) {
                this.ibL[i] = 255;
            }
            if (this.ibM[i] && this.ibL[i] < 255) {
                z = false;
            }
            if (!this.ibM[i] && this.ibL[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.ibH) {
            case 0:
                System.arraycopy(this.ibL, 0, this.ibK, 0, this.ibv.length);
                this.ibJ = bSG();
                boolean aH = aH(this.ibI == 0 ? 1.0f : 0.0f);
                this.ibH = aH ? 2 : 1;
                z = aH;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.ibI > 0);
                boolean aH2 = aH(((float) (bSG() - this.ibJ)) / this.ibI);
                this.ibH = aH2 ? 2 : 1;
                z = aH2;
                break;
        }
        for (int i = 0; i < this.ibv.length; i++) {
            a(canvas, this.ibv[i], (this.ibL[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.ibN++;
            drawable.mutate().setAlpha(i);
            this.ibN--;
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

    protected long bSG() {
        return SystemClock.uptimeMillis();
    }
}
