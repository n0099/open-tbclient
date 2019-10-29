package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    long aye;
    private final Drawable[] kdR;
    int ked;
    int kee;
    int[] kef;
    int[] keg;
    boolean[] keh;
    int kei;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.kdR = drawableArr;
        this.kef = new int[drawableArr.length];
        this.keg = new int[drawableArr.length];
        this.mAlpha = 255;
        this.keh = new boolean[drawableArr.length];
        this.kei = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.kei == 0) {
            super.invalidateSelf();
        }
    }

    public void cEr() {
        this.kei++;
    }

    public void cEs() {
        this.kei--;
        invalidateSelf();
    }

    public void Ch(int i) {
        this.kee = i;
        if (this.ked == 1) {
            this.ked = 0;
        }
    }

    private void resetInternal() {
        this.ked = 2;
        Arrays.fill(this.kef, 0);
        this.kef[0] = 255;
        Arrays.fill(this.keg, 0);
        this.keg[0] = 255;
        Arrays.fill(this.keh, false);
        this.keh[0] = true;
    }

    public void Ci(int i) {
        this.ked = 0;
        this.keh[i] = true;
        invalidateSelf();
    }

    public void Cj(int i) {
        this.ked = 0;
        this.keh[i] = false;
        invalidateSelf();
    }

    public void cEt() {
        this.ked = 0;
        Arrays.fill(this.keh, true);
        invalidateSelf();
    }

    public void cEu() {
        this.ked = 2;
        for (int i = 0; i < this.kdR.length; i++) {
            this.keg[i] = this.keh[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aD(float f) {
        boolean z = true;
        for (int i = 0; i < this.kdR.length; i++) {
            this.keg[i] = (int) (((this.keh[i] ? 1 : -1) * 255 * f) + this.kef[i]);
            if (this.keg[i] < 0) {
                this.keg[i] = 0;
            }
            if (this.keg[i] > 255) {
                this.keg[i] = 255;
            }
            if (this.keh[i] && this.keg[i] < 255) {
                z = false;
            }
            if (!this.keh[i] && this.keg[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.ked) {
            case 0:
                System.arraycopy(this.keg, 0, this.kef, 0, this.kdR.length);
                this.aye = cEv();
                boolean aD = aD(this.kee == 0 ? 1.0f : 0.0f);
                this.ked = aD ? 2 : 1;
                z = aD;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.kee > 0);
                boolean aD2 = aD(((float) (cEv() - this.aye)) / this.kee);
                this.ked = aD2 ? 2 : 1;
                z = aD2;
                break;
        }
        for (int i = 0; i < this.kdR.length; i++) {
            a(canvas, this.kdR[i], (this.keg[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.kei++;
            drawable.mutate().setAlpha(i);
            this.kei--;
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

    protected long cEv() {
        return SystemClock.uptimeMillis();
    }
}
