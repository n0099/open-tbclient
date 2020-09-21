package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class f extends a {
    private static boolean nyR = true;
    int mAlpha;
    long mStartTimeMs;
    int nyL;
    int nyM;
    int[] nyN;
    int[] nyO;
    boolean[] nyP;
    int nyQ;
    private final Drawable[] nyz;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.nyz = drawableArr;
        this.nyN = new int[drawableArr.length];
        this.nyO = new int[drawableArr.length];
        this.mAlpha = 255;
        this.nyP = new boolean[drawableArr.length];
        this.nyQ = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.nyQ == 0) {
            super.invalidateSelf();
        }
    }

    public void dUr() {
        this.nyQ++;
    }

    public void dUs() {
        this.nyQ--;
        invalidateSelf();
    }

    public void LM(int i) {
        this.nyM = i;
        if (this.nyL == 1) {
            this.nyL = 0;
        }
    }

    private void resetInternal() {
        this.nyL = 2;
        Arrays.fill(this.nyN, 0);
        this.nyN[0] = 255;
        Arrays.fill(this.nyO, 0);
        this.nyO[0] = 255;
        Arrays.fill(this.nyP, false);
        this.nyP[0] = true;
    }

    public void LN(int i) {
        this.nyL = 0;
        this.nyP[i] = true;
        invalidateSelf();
    }

    public void LO(int i) {
        this.nyL = 0;
        this.nyP[i] = false;
        invalidateSelf();
    }

    public void dUt() {
        this.nyL = 0;
        Arrays.fill(this.nyP, true);
        invalidateSelf();
    }

    public void dUu() {
        this.nyL = 2;
        for (int i = 0; i < this.nyz.length; i++) {
            this.nyO[i] = this.nyP[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aL(float f) {
        boolean z = true;
        for (int i = 0; i < this.nyz.length; i++) {
            this.nyO[i] = (int) (((this.nyP[i] ? 1 : -1) * 255 * f) + this.nyN[i]);
            if (this.nyO[i] < 0) {
                this.nyO[i] = 0;
            }
            if (this.nyO[i] > 255) {
                this.nyO[i] = 255;
            }
            if (this.nyP[i] && this.nyO[i] < 255) {
                z = false;
            }
            if (!this.nyP[i] && this.nyO[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.nyL) {
            case 0:
                System.arraycopy(this.nyO, 0, this.nyN, 0, this.nyz.length);
                this.mStartTimeMs = dUv();
                if (nyR && this.nyM != 0) {
                    r0 = 0.0f;
                }
                boolean aL = aL(r0);
                this.nyL = aL ? 2 : 1;
                z = aL;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.nyM > 0);
                boolean aL2 = aL(nyR ? ((float) (dUv() - this.mStartTimeMs)) / this.nyM : 1.0f);
                this.nyL = aL2 ? 2 : 1;
                z = aL2;
                break;
        }
        for (int i = 0; i < this.nyz.length; i++) {
            a(canvas, this.nyz[i], (this.nyO[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.nyQ++;
            drawable.mutate().setAlpha(i);
            this.nyQ--;
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

    protected long dUv() {
        return SystemClock.uptimeMillis();
    }
}
