package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean mpo = true;
    int mAlpha;
    long mStartTimeMs;
    private final Drawable[] moW;
    int mpi;
    int mpj;
    int[] mpk;
    int[] mpl;
    boolean[] mpm;
    int mpn;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.moW = drawableArr;
        this.mpk = new int[drawableArr.length];
        this.mpl = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mpm = new boolean[drawableArr.length];
        this.mpn = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mpn == 0) {
            super.invalidateSelf();
        }
    }

    public void dwc() {
        this.mpn++;
    }

    public void dwd() {
        this.mpn--;
        invalidateSelf();
    }

    public void GZ(int i) {
        this.mpj = i;
        if (this.mpi == 1) {
            this.mpi = 0;
        }
    }

    private void resetInternal() {
        this.mpi = 2;
        Arrays.fill(this.mpk, 0);
        this.mpk[0] = 255;
        Arrays.fill(this.mpl, 0);
        this.mpl[0] = 255;
        Arrays.fill(this.mpm, false);
        this.mpm[0] = true;
    }

    public void Ha(int i) {
        this.mpi = 0;
        this.mpm[i] = true;
        invalidateSelf();
    }

    public void Hb(int i) {
        this.mpi = 0;
        this.mpm[i] = false;
        invalidateSelf();
    }

    public void dwe() {
        this.mpi = 0;
        Arrays.fill(this.mpm, true);
        invalidateSelf();
    }

    public void dwf() {
        this.mpi = 2;
        for (int i = 0; i < this.moW.length; i++) {
            this.mpl[i] = this.mpm[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aA(float f) {
        boolean z = true;
        for (int i = 0; i < this.moW.length; i++) {
            this.mpl[i] = (int) (((this.mpm[i] ? 1 : -1) * 255 * f) + this.mpk[i]);
            if (this.mpl[i] < 0) {
                this.mpl[i] = 0;
            }
            if (this.mpl[i] > 255) {
                this.mpl[i] = 255;
            }
            if (this.mpm[i] && this.mpl[i] < 255) {
                z = false;
            }
            if (!this.mpm[i] && this.mpl[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.mpi) {
            case 0:
                System.arraycopy(this.mpl, 0, this.mpk, 0, this.moW.length);
                this.mStartTimeMs = dwg();
                if (mpo && this.mpj != 0) {
                    r0 = 0.0f;
                }
                boolean aA = aA(r0);
                this.mpi = aA ? 2 : 1;
                z = aA;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mpj > 0);
                boolean aA2 = aA(mpo ? ((float) (dwg() - this.mStartTimeMs)) / this.mpj : 1.0f);
                this.mpi = aA2 ? 2 : 1;
                z = aA2;
                break;
        }
        for (int i = 0; i < this.moW.length; i++) {
            a(canvas, this.moW[i], (this.mpl[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.mpn++;
            drawable.mutate().setAlpha(i);
            this.mpn--;
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

    protected long dwg() {
        return SystemClock.uptimeMillis();
    }
}
