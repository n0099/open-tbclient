package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class f extends a {
    private static boolean nOk = true;
    int mAlpha;
    long mStartTimeMs;
    private final Drawable[] nNS;
    int nOe;
    int nOf;
    int[] nOg;
    int[] nOh;
    boolean[] nOi;
    int nOj;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.nNS = drawableArr;
        this.nOg = new int[drawableArr.length];
        this.nOh = new int[drawableArr.length];
        this.mAlpha = 255;
        this.nOi = new boolean[drawableArr.length];
        this.nOj = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.nOj == 0) {
            super.invalidateSelf();
        }
    }

    public void dYc() {
        this.nOj++;
    }

    public void dYd() {
        this.nOj--;
        invalidateSelf();
    }

    public void Ms(int i) {
        this.nOf = i;
        if (this.nOe == 1) {
            this.nOe = 0;
        }
    }

    private void resetInternal() {
        this.nOe = 2;
        Arrays.fill(this.nOg, 0);
        this.nOg[0] = 255;
        Arrays.fill(this.nOh, 0);
        this.nOh[0] = 255;
        Arrays.fill(this.nOi, false);
        this.nOi[0] = true;
    }

    public void Mt(int i) {
        this.nOe = 0;
        this.nOi[i] = true;
        invalidateSelf();
    }

    public void Mu(int i) {
        this.nOe = 0;
        this.nOi[i] = false;
        invalidateSelf();
    }

    public void dYe() {
        this.nOe = 0;
        Arrays.fill(this.nOi, true);
        invalidateSelf();
    }

    public void dYf() {
        this.nOe = 2;
        for (int i = 0; i < this.nNS.length; i++) {
            this.nOh[i] = this.nOi[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aR(float f) {
        boolean z = true;
        for (int i = 0; i < this.nNS.length; i++) {
            this.nOh[i] = (int) (((this.nOi[i] ? 1 : -1) * 255 * f) + this.nOg[i]);
            if (this.nOh[i] < 0) {
                this.nOh[i] = 0;
            }
            if (this.nOh[i] > 255) {
                this.nOh[i] = 255;
            }
            if (this.nOi[i] && this.nOh[i] < 255) {
                z = false;
            }
            if (!this.nOi[i] && this.nOh[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.nOe) {
            case 0:
                System.arraycopy(this.nOh, 0, this.nOg, 0, this.nNS.length);
                this.mStartTimeMs = dYg();
                if (nOk && this.nOf != 0) {
                    r0 = 0.0f;
                }
                boolean aR = aR(r0);
                this.nOe = aR ? 2 : 1;
                z = aR;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.nOf > 0);
                boolean aR2 = aR(nOk ? ((float) (dYg() - this.mStartTimeMs)) / this.nOf : 1.0f);
                this.nOe = aR2 ? 2 : 1;
                z = aR2;
                break;
        }
        for (int i = 0; i < this.nNS.length; i++) {
            a(canvas, this.nNS[i], (this.nOh[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.nOj++;
            drawable.mutate().setAlpha(i);
            this.nOj--;
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

    protected long dYg() {
        return SystemClock.uptimeMillis();
    }
}
