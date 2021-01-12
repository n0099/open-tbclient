package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class f extends a {
    private static boolean psv = true;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;
    private final Drawable[] pse;
    int psq;
    int[] psr;
    int[] pss;
    boolean[] pst;
    int psu;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.pse = drawableArr;
        this.psr = new int[drawableArr.length];
        this.pss = new int[drawableArr.length];
        this.mAlpha = 255;
        this.pst = new boolean[drawableArr.length];
        this.psu = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.psu == 0) {
            super.invalidateSelf();
        }
    }

    public void erT() {
        this.psu++;
    }

    public void erU() {
        this.psu--;
        invalidateSelf();
    }

    public void OM(int i) {
        this.mDurationMs = i;
        if (this.psq == 1) {
            this.psq = 0;
        }
    }

    private void resetInternal() {
        this.psq = 2;
        Arrays.fill(this.psr, 0);
        this.psr[0] = 255;
        Arrays.fill(this.pss, 0);
        this.pss[0] = 255;
        Arrays.fill(this.pst, false);
        this.pst[0] = true;
    }

    public void ON(int i) {
        this.psq = 0;
        this.pst[i] = true;
        invalidateSelf();
    }

    public void OO(int i) {
        this.psq = 0;
        this.pst[i] = false;
        invalidateSelf();
    }

    public void erV() {
        this.psq = 0;
        Arrays.fill(this.pst, true);
        invalidateSelf();
    }

    public void erW() {
        this.psq = 2;
        for (int i = 0; i < this.pse.length; i++) {
            this.pss[i] = this.pst[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bE(float f) {
        boolean z = true;
        for (int i = 0; i < this.pse.length; i++) {
            this.pss[i] = (int) (((this.pst[i] ? 1 : -1) * 255 * f) + this.psr[i]);
            if (this.pss[i] < 0) {
                this.pss[i] = 0;
            }
            if (this.pss[i] > 255) {
                this.pss[i] = 255;
            }
            if (this.pst[i] && this.pss[i] < 255) {
                z = false;
            }
            if (!this.pst[i] && this.pss[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.psq) {
            case 0:
                System.arraycopy(this.pss, 0, this.psr, 0, this.pse.length);
                this.mStartTimeMs = erX();
                if (psv && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bE = bE(r0);
                this.psq = bE ? 2 : 1;
                z = bE;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bE2 = bE(psv ? ((float) (erX() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.psq = bE2 ? 2 : 1;
                z = bE2;
                break;
        }
        for (int i = 0; i < this.pse.length; i++) {
            a(canvas, this.pse[i], (this.pss[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.psu++;
            drawable.mutate().setAlpha(i);
            this.psu--;
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
