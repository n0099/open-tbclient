package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes9.dex */
public class f extends a {
    private static boolean mUJ = true;
    int mAlpha;
    long mStartTimeMs;
    int mUD;
    int mUE;
    int[] mUF;
    int[] mUG;
    boolean[] mUH;
    int mUI;
    private final Drawable[] mUr;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.mUr = drawableArr;
        this.mUF = new int[drawableArr.length];
        this.mUG = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mUH = new boolean[drawableArr.length];
        this.mUI = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mUI == 0) {
            super.invalidateSelf();
        }
    }

    public void dEj() {
        this.mUI++;
    }

    public void dEk() {
        this.mUI--;
        invalidateSelf();
    }

    public void ID(int i) {
        this.mUE = i;
        if (this.mUD == 1) {
            this.mUD = 0;
        }
    }

    private void resetInternal() {
        this.mUD = 2;
        Arrays.fill(this.mUF, 0);
        this.mUF[0] = 255;
        Arrays.fill(this.mUG, 0);
        this.mUG[0] = 255;
        Arrays.fill(this.mUH, false);
        this.mUH[0] = true;
    }

    public void IE(int i) {
        this.mUD = 0;
        this.mUH[i] = true;
        invalidateSelf();
    }

    public void IF(int i) {
        this.mUD = 0;
        this.mUH[i] = false;
        invalidateSelf();
    }

    public void dEl() {
        this.mUD = 0;
        Arrays.fill(this.mUH, true);
        invalidateSelf();
    }

    public void dEm() {
        this.mUD = 2;
        for (int i = 0; i < this.mUr.length; i++) {
            this.mUG[i] = this.mUH[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aF(float f) {
        boolean z = true;
        for (int i = 0; i < this.mUr.length; i++) {
            this.mUG[i] = (int) (((this.mUH[i] ? 1 : -1) * 255 * f) + this.mUF[i]);
            if (this.mUG[i] < 0) {
                this.mUG[i] = 0;
            }
            if (this.mUG[i] > 255) {
                this.mUG[i] = 255;
            }
            if (this.mUH[i] && this.mUG[i] < 255) {
                z = false;
            }
            if (!this.mUH[i] && this.mUG[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.mUD) {
            case 0:
                System.arraycopy(this.mUG, 0, this.mUF, 0, this.mUr.length);
                this.mStartTimeMs = dEn();
                if (mUJ && this.mUE != 0) {
                    r0 = 0.0f;
                }
                boolean aF = aF(r0);
                this.mUD = aF ? 2 : 1;
                z = aF;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mUE > 0);
                boolean aF2 = aF(mUJ ? ((float) (dEn() - this.mStartTimeMs)) / this.mUE : 1.0f);
                this.mUD = aF2 ? 2 : 1;
                z = aF2;
                break;
        }
        for (int i = 0; i < this.mUr.length; i++) {
            a(canvas, this.mUr[i], (this.mUG[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.mUI++;
            drawable.mutate().setAlpha(i);
            this.mUI--;
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

    protected long dEn() {
        return SystemClock.uptimeMillis();
    }
}
