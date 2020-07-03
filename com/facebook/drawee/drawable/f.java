package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean mMx = true;
    int mAlpha;
    private final Drawable[] mMf;
    int mMr;
    int mMs;
    int[] mMt;
    int[] mMu;
    boolean[] mMv;
    int mMw;
    long mStartTimeMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.mMf = drawableArr;
        this.mMt = new int[drawableArr.length];
        this.mMu = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mMv = new boolean[drawableArr.length];
        this.mMw = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mMw == 0) {
            super.invalidateSelf();
        }
    }

    public void dAT() {
        this.mMw++;
    }

    public void dAU() {
        this.mMw--;
        invalidateSelf();
    }

    public void Ii(int i) {
        this.mMs = i;
        if (this.mMr == 1) {
            this.mMr = 0;
        }
    }

    private void resetInternal() {
        this.mMr = 2;
        Arrays.fill(this.mMt, 0);
        this.mMt[0] = 255;
        Arrays.fill(this.mMu, 0);
        this.mMu[0] = 255;
        Arrays.fill(this.mMv, false);
        this.mMv[0] = true;
    }

    public void Ij(int i) {
        this.mMr = 0;
        this.mMv[i] = true;
        invalidateSelf();
    }

    public void Ik(int i) {
        this.mMr = 0;
        this.mMv[i] = false;
        invalidateSelf();
    }

    public void dAV() {
        this.mMr = 0;
        Arrays.fill(this.mMv, true);
        invalidateSelf();
    }

    public void dAW() {
        this.mMr = 2;
        for (int i = 0; i < this.mMf.length; i++) {
            this.mMu[i] = this.mMv[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aG(float f) {
        boolean z = true;
        for (int i = 0; i < this.mMf.length; i++) {
            this.mMu[i] = (int) (((this.mMv[i] ? 1 : -1) * 255 * f) + this.mMt[i]);
            if (this.mMu[i] < 0) {
                this.mMu[i] = 0;
            }
            if (this.mMu[i] > 255) {
                this.mMu[i] = 255;
            }
            if (this.mMv[i] && this.mMu[i] < 255) {
                z = false;
            }
            if (!this.mMv[i] && this.mMu[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.mMr) {
            case 0:
                System.arraycopy(this.mMu, 0, this.mMt, 0, this.mMf.length);
                this.mStartTimeMs = dAX();
                if (mMx && this.mMs != 0) {
                    r0 = 0.0f;
                }
                boolean aG = aG(r0);
                this.mMr = aG ? 2 : 1;
                z = aG;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mMs > 0);
                boolean aG2 = aG(mMx ? ((float) (dAX() - this.mStartTimeMs)) / this.mMs : 1.0f);
                this.mMr = aG2 ? 2 : 1;
                z = aG2;
                break;
        }
        for (int i = 0; i < this.mMf.length; i++) {
            a(canvas, this.mMf[i], (this.mMu[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.mMw++;
            drawable.mutate().setAlpha(i);
            this.mMw--;
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

    protected long dAX() {
        return SystemClock.uptimeMillis();
    }
}
