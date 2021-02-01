package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class f extends a {
    private static boolean pCF = true;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;
    int pCA;
    int[] pCB;
    int[] pCC;
    boolean[] pCD;
    int pCE;
    private final Drawable[] pCo;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.pCo = drawableArr;
        this.pCB = new int[drawableArr.length];
        this.pCC = new int[drawableArr.length];
        this.mAlpha = 255;
        this.pCD = new boolean[drawableArr.length];
        this.pCE = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.pCE == 0) {
            super.invalidateSelf();
        }
    }

    public void eul() {
        this.pCE++;
    }

    public void eum() {
        this.pCE--;
        invalidateSelf();
    }

    public void Ph(int i) {
        this.mDurationMs = i;
        if (this.pCA == 1) {
            this.pCA = 0;
        }
    }

    private void resetInternal() {
        this.pCA = 2;
        Arrays.fill(this.pCB, 0);
        this.pCB[0] = 255;
        Arrays.fill(this.pCC, 0);
        this.pCC[0] = 255;
        Arrays.fill(this.pCD, false);
        this.pCD[0] = true;
    }

    public void Pi(int i) {
        this.pCA = 0;
        this.pCD[i] = true;
        invalidateSelf();
    }

    public void Pj(int i) {
        this.pCA = 0;
        this.pCD[i] = false;
        invalidateSelf();
    }

    public void eun() {
        this.pCA = 0;
        Arrays.fill(this.pCD, true);
        invalidateSelf();
    }

    public void euo() {
        this.pCA = 2;
        for (int i = 0; i < this.pCo.length; i++) {
            this.pCC[i] = this.pCD[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bH(float f) {
        boolean z = true;
        for (int i = 0; i < this.pCo.length; i++) {
            this.pCC[i] = (int) (((this.pCD[i] ? 1 : -1) * 255 * f) + this.pCB[i]);
            if (this.pCC[i] < 0) {
                this.pCC[i] = 0;
            }
            if (this.pCC[i] > 255) {
                this.pCC[i] = 255;
            }
            if (this.pCD[i] && this.pCC[i] < 255) {
                z = false;
            }
            if (!this.pCD[i] && this.pCC[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.pCA) {
            case 0:
                System.arraycopy(this.pCC, 0, this.pCB, 0, this.pCo.length);
                this.mStartTimeMs = eup();
                if (pCF && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bH = bH(r0);
                this.pCA = bH ? 2 : 1;
                z = bH;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bH2 = bH(pCF ? ((float) (eup() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.pCA = bH2 ? 2 : 1;
                z = bH2;
                break;
        }
        for (int i = 0; i < this.pCo.length; i++) {
            a(canvas, this.pCo[i], (this.pCC[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.pCE++;
            drawable.mutate().setAlpha(i);
            this.pCE--;
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

    protected long eup() {
        return SystemClock.uptimeMillis();
    }
}
