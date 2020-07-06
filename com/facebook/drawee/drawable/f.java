package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean mMA = true;
    int mAlpha;
    private final Drawable[] mMi;
    int mMu;
    int mMv;
    int[] mMw;
    int[] mMx;
    boolean[] mMy;
    int mMz;
    long mStartTimeMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.mMi = drawableArr;
        this.mMw = new int[drawableArr.length];
        this.mMx = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mMy = new boolean[drawableArr.length];
        this.mMz = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mMz == 0) {
            super.invalidateSelf();
        }
    }

    public void dAX() {
        this.mMz++;
    }

    public void dAY() {
        this.mMz--;
        invalidateSelf();
    }

    public void Ii(int i) {
        this.mMv = i;
        if (this.mMu == 1) {
            this.mMu = 0;
        }
    }

    private void resetInternal() {
        this.mMu = 2;
        Arrays.fill(this.mMw, 0);
        this.mMw[0] = 255;
        Arrays.fill(this.mMx, 0);
        this.mMx[0] = 255;
        Arrays.fill(this.mMy, false);
        this.mMy[0] = true;
    }

    public void Ij(int i) {
        this.mMu = 0;
        this.mMy[i] = true;
        invalidateSelf();
    }

    public void Ik(int i) {
        this.mMu = 0;
        this.mMy[i] = false;
        invalidateSelf();
    }

    public void dAZ() {
        this.mMu = 0;
        Arrays.fill(this.mMy, true);
        invalidateSelf();
    }

    public void dBa() {
        this.mMu = 2;
        for (int i = 0; i < this.mMi.length; i++) {
            this.mMx[i] = this.mMy[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aG(float f) {
        boolean z = true;
        for (int i = 0; i < this.mMi.length; i++) {
            this.mMx[i] = (int) (((this.mMy[i] ? 1 : -1) * 255 * f) + this.mMw[i]);
            if (this.mMx[i] < 0) {
                this.mMx[i] = 0;
            }
            if (this.mMx[i] > 255) {
                this.mMx[i] = 255;
            }
            if (this.mMy[i] && this.mMx[i] < 255) {
                z = false;
            }
            if (!this.mMy[i] && this.mMx[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.mMu) {
            case 0:
                System.arraycopy(this.mMx, 0, this.mMw, 0, this.mMi.length);
                this.mStartTimeMs = dBb();
                if (mMA && this.mMv != 0) {
                    r0 = 0.0f;
                }
                boolean aG = aG(r0);
                this.mMu = aG ? 2 : 1;
                z = aG;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mMv > 0);
                boolean aG2 = aG(mMA ? ((float) (dBb() - this.mStartTimeMs)) / this.mMv : 1.0f);
                this.mMu = aG2 ? 2 : 1;
                z = aG2;
                break;
        }
        for (int i = 0; i < this.mMi.length; i++) {
            a(canvas, this.mMi[i], (this.mMx[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.mMz++;
            drawable.mutate().setAlpha(i);
            this.mMz--;
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

    protected long dBb() {
        return SystemClock.uptimeMillis();
    }
}
