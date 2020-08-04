package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes9.dex */
public class f extends a {
    private static boolean mUL = true;
    int mAlpha;
    long mStartTimeMs;
    int mUF;
    int mUG;
    int[] mUH;
    int[] mUI;
    boolean[] mUJ;
    int mUK;
    private final Drawable[] mUt;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.mUt = drawableArr;
        this.mUH = new int[drawableArr.length];
        this.mUI = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mUJ = new boolean[drawableArr.length];
        this.mUK = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mUK == 0) {
            super.invalidateSelf();
        }
    }

    public void dEk() {
        this.mUK++;
    }

    public void dEl() {
        this.mUK--;
        invalidateSelf();
    }

    public void ID(int i) {
        this.mUG = i;
        if (this.mUF == 1) {
            this.mUF = 0;
        }
    }

    private void resetInternal() {
        this.mUF = 2;
        Arrays.fill(this.mUH, 0);
        this.mUH[0] = 255;
        Arrays.fill(this.mUI, 0);
        this.mUI[0] = 255;
        Arrays.fill(this.mUJ, false);
        this.mUJ[0] = true;
    }

    public void IE(int i) {
        this.mUF = 0;
        this.mUJ[i] = true;
        invalidateSelf();
    }

    public void IF(int i) {
        this.mUF = 0;
        this.mUJ[i] = false;
        invalidateSelf();
    }

    public void dEm() {
        this.mUF = 0;
        Arrays.fill(this.mUJ, true);
        invalidateSelf();
    }

    public void dEn() {
        this.mUF = 2;
        for (int i = 0; i < this.mUt.length; i++) {
            this.mUI[i] = this.mUJ[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aF(float f) {
        boolean z = true;
        for (int i = 0; i < this.mUt.length; i++) {
            this.mUI[i] = (int) (((this.mUJ[i] ? 1 : -1) * 255 * f) + this.mUH[i]);
            if (this.mUI[i] < 0) {
                this.mUI[i] = 0;
            }
            if (this.mUI[i] > 255) {
                this.mUI[i] = 255;
            }
            if (this.mUJ[i] && this.mUI[i] < 255) {
                z = false;
            }
            if (!this.mUJ[i] && this.mUI[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.mUF) {
            case 0:
                System.arraycopy(this.mUI, 0, this.mUH, 0, this.mUt.length);
                this.mStartTimeMs = dEo();
                if (mUL && this.mUG != 0) {
                    r0 = 0.0f;
                }
                boolean aF = aF(r0);
                this.mUF = aF ? 2 : 1;
                z = aF;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mUG > 0);
                boolean aF2 = aF(mUL ? ((float) (dEo() - this.mStartTimeMs)) / this.mUG : 1.0f);
                this.mUF = aF2 ? 2 : 1;
                z = aF2;
                break;
        }
        for (int i = 0; i < this.mUt.length; i++) {
            a(canvas, this.mUt[i], (this.mUI[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.mUK++;
            drawable.mutate().setAlpha(i);
            this.mUK--;
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

    protected long dEo() {
        return SystemClock.uptimeMillis();
    }
}
