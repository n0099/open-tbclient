package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class f extends a {
    private static boolean lHT = true;
    long aFx;
    private final Drawable[] lHC;
    int lHO;
    int[] lHP;
    int[] lHQ;
    boolean[] lHR;
    int lHS;
    int mAlpha;
    int mDurationMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.lHC = drawableArr;
        this.lHP = new int[drawableArr.length];
        this.lHQ = new int[drawableArr.length];
        this.mAlpha = 255;
        this.lHR = new boolean[drawableArr.length];
        this.lHS = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.lHS == 0) {
            super.invalidateSelf();
        }
    }

    public void dkc() {
        this.lHS++;
    }

    public void dkd() {
        this.lHS--;
        invalidateSelf();
    }

    public void Hw(int i) {
        this.mDurationMs = i;
        if (this.lHO == 1) {
            this.lHO = 0;
        }
    }

    private void resetInternal() {
        this.lHO = 2;
        Arrays.fill(this.lHP, 0);
        this.lHP[0] = 255;
        Arrays.fill(this.lHQ, 0);
        this.lHQ[0] = 255;
        Arrays.fill(this.lHR, false);
        this.lHR[0] = true;
    }

    public void Hx(int i) {
        this.lHO = 0;
        this.lHR[i] = true;
        invalidateSelf();
    }

    public void Hy(int i) {
        this.lHO = 0;
        this.lHR[i] = false;
        invalidateSelf();
    }

    public void dke() {
        this.lHO = 0;
        Arrays.fill(this.lHR, true);
        invalidateSelf();
    }

    public void dkf() {
        this.lHO = 2;
        for (int i = 0; i < this.lHC.length; i++) {
            this.lHQ[i] = this.lHR[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bn(float f) {
        boolean z = true;
        for (int i = 0; i < this.lHC.length; i++) {
            this.lHQ[i] = (int) (((this.lHR[i] ? 1 : -1) * 255 * f) + this.lHP[i]);
            if (this.lHQ[i] < 0) {
                this.lHQ[i] = 0;
            }
            if (this.lHQ[i] > 255) {
                this.lHQ[i] = 255;
            }
            if (this.lHR[i] && this.lHQ[i] < 255) {
                z = false;
            }
            if (!this.lHR[i] && this.lHQ[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.lHO) {
            case 0:
                System.arraycopy(this.lHQ, 0, this.lHP, 0, this.lHC.length);
                this.aFx = dkg();
                if (lHT && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bn = bn(r0);
                this.lHO = bn ? 2 : 1;
                z = bn;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bn2 = bn(lHT ? ((float) (dkg() - this.aFx)) / this.mDurationMs : 1.0f);
                this.lHO = bn2 ? 2 : 1;
                z = bn2;
                break;
        }
        for (int i = 0; i < this.lHC.length; i++) {
            a(canvas, this.lHC[i], (this.lHQ[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.lHS++;
            drawable.mutate().setAlpha(i);
            this.lHS--;
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

    protected long dkg() {
        return SystemClock.uptimeMillis();
    }
}
