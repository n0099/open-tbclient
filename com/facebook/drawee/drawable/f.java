package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class f extends a {
    private static boolean pFk = true;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;
    private final Drawable[] pET;
    int pFf;
    int[] pFg;
    int[] pFh;
    boolean[] pFi;
    int pFj;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.pET = drawableArr;
        this.pFg = new int[drawableArr.length];
        this.pFh = new int[drawableArr.length];
        this.mAlpha = 255;
        this.pFi = new boolean[drawableArr.length];
        this.pFj = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.pFj == 0) {
            super.invalidateSelf();
        }
    }

    public void euC() {
        this.pFj++;
    }

    public void euD() {
        this.pFj--;
        invalidateSelf();
    }

    public void Pm(int i) {
        this.mDurationMs = i;
        if (this.pFf == 1) {
            this.pFf = 0;
        }
    }

    private void resetInternal() {
        this.pFf = 2;
        Arrays.fill(this.pFg, 0);
        this.pFg[0] = 255;
        Arrays.fill(this.pFh, 0);
        this.pFh[0] = 255;
        Arrays.fill(this.pFi, false);
        this.pFi[0] = true;
    }

    public void Pn(int i) {
        this.pFf = 0;
        this.pFi[i] = true;
        invalidateSelf();
    }

    public void Po(int i) {
        this.pFf = 0;
        this.pFi[i] = false;
        invalidateSelf();
    }

    public void euE() {
        this.pFf = 0;
        Arrays.fill(this.pFi, true);
        invalidateSelf();
    }

    public void euF() {
        this.pFf = 2;
        for (int i = 0; i < this.pET.length; i++) {
            this.pFh[i] = this.pFi[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bL(float f) {
        boolean z = true;
        for (int i = 0; i < this.pET.length; i++) {
            this.pFh[i] = (int) (((this.pFi[i] ? 1 : -1) * 255 * f) + this.pFg[i]);
            if (this.pFh[i] < 0) {
                this.pFh[i] = 0;
            }
            if (this.pFh[i] > 255) {
                this.pFh[i] = 255;
            }
            if (this.pFi[i] && this.pFh[i] < 255) {
                z = false;
            }
            if (!this.pFi[i] && this.pFh[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.pFf) {
            case 0:
                System.arraycopy(this.pFh, 0, this.pFg, 0, this.pET.length);
                this.mStartTimeMs = euG();
                if (pFk && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bL = bL(r0);
                this.pFf = bL ? 2 : 1;
                z = bL;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bL2 = bL(pFk ? ((float) (euG() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.pFf = bL2 ? 2 : 1;
                z = bL2;
                break;
        }
        for (int i = 0; i < this.pET.length; i++) {
            a(canvas, this.pET[i], (this.pFh[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.pFj++;
            drawable.mutate().setAlpha(i);
            this.pFj--;
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

    protected long euG() {
        return SystemClock.uptimeMillis();
    }
}
