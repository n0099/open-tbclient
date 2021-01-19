package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class f extends a {
    private static boolean psw = true;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;
    private final Drawable[] psf;
    int psr;
    int[] pss;
    int[] pst;
    boolean[] psu;
    int psv;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.psf = drawableArr;
        this.pss = new int[drawableArr.length];
        this.pst = new int[drawableArr.length];
        this.mAlpha = 255;
        this.psu = new boolean[drawableArr.length];
        this.psv = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.psv == 0) {
            super.invalidateSelf();
        }
    }

    public void erT() {
        this.psv++;
    }

    public void erU() {
        this.psv--;
        invalidateSelf();
    }

    public void OM(int i) {
        this.mDurationMs = i;
        if (this.psr == 1) {
            this.psr = 0;
        }
    }

    private void resetInternal() {
        this.psr = 2;
        Arrays.fill(this.pss, 0);
        this.pss[0] = 255;
        Arrays.fill(this.pst, 0);
        this.pst[0] = 255;
        Arrays.fill(this.psu, false);
        this.psu[0] = true;
    }

    public void ON(int i) {
        this.psr = 0;
        this.psu[i] = true;
        invalidateSelf();
    }

    public void OO(int i) {
        this.psr = 0;
        this.psu[i] = false;
        invalidateSelf();
    }

    public void erV() {
        this.psr = 0;
        Arrays.fill(this.psu, true);
        invalidateSelf();
    }

    public void erW() {
        this.psr = 2;
        for (int i = 0; i < this.psf.length; i++) {
            this.pst[i] = this.psu[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bE(float f) {
        boolean z = true;
        for (int i = 0; i < this.psf.length; i++) {
            this.pst[i] = (int) (((this.psu[i] ? 1 : -1) * 255 * f) + this.pss[i]);
            if (this.pst[i] < 0) {
                this.pst[i] = 0;
            }
            if (this.pst[i] > 255) {
                this.pst[i] = 255;
            }
            if (this.psu[i] && this.pst[i] < 255) {
                z = false;
            }
            if (!this.psu[i] && this.pst[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.psr) {
            case 0:
                System.arraycopy(this.pst, 0, this.pss, 0, this.psf.length);
                this.mStartTimeMs = erX();
                if (psw && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bE = bE(r0);
                this.psr = bE ? 2 : 1;
                z = bE;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bE2 = bE(psw ? ((float) (erX() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.psr = bE2 ? 2 : 1;
                z = bE2;
                break;
        }
        for (int i = 0; i < this.psf.length; i++) {
            a(canvas, this.psf[i], (this.pst[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.psv++;
            drawable.mutate().setAlpha(i);
            this.psv--;
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

    protected long erX() {
        return SystemClock.uptimeMillis();
    }
}
