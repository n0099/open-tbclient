package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] hZK;
    int hZW;
    int hZX;
    long hZY;
    int[] hZZ;
    int[] iaa;
    boolean[] iab;
    int iac;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.hZK = drawableArr;
        this.hZZ = new int[drawableArr.length];
        this.iaa = new int[drawableArr.length];
        this.mAlpha = 255;
        this.iab = new boolean[drawableArr.length];
        this.iac = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.iac == 0) {
            super.invalidateSelf();
        }
    }

    public void bTh() {
        this.iac++;
    }

    public void bTi() {
        this.iac--;
        invalidateSelf();
    }

    public void xm(int i) {
        this.hZX = i;
        if (this.hZW == 1) {
            this.hZW = 0;
        }
    }

    private void resetInternal() {
        this.hZW = 2;
        Arrays.fill(this.hZZ, 0);
        this.hZZ[0] = 255;
        Arrays.fill(this.iaa, 0);
        this.iaa[0] = 255;
        Arrays.fill(this.iab, false);
        this.iab[0] = true;
    }

    public void xn(int i) {
        this.hZW = 0;
        this.iab[i] = true;
        invalidateSelf();
    }

    public void xo(int i) {
        this.hZW = 0;
        this.iab[i] = false;
        invalidateSelf();
    }

    public void bTj() {
        this.hZW = 0;
        Arrays.fill(this.iab, true);
        invalidateSelf();
    }

    public void bTk() {
        this.hZW = 2;
        for (int i = 0; i < this.hZK.length; i++) {
            this.iaa[i] = this.iab[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aF(float f) {
        boolean z = true;
        for (int i = 0; i < this.hZK.length; i++) {
            this.iaa[i] = (int) (((this.iab[i] ? 1 : -1) * 255 * f) + this.hZZ[i]);
            if (this.iaa[i] < 0) {
                this.iaa[i] = 0;
            }
            if (this.iaa[i] > 255) {
                this.iaa[i] = 255;
            }
            if (this.iab[i] && this.iaa[i] < 255) {
                z = false;
            }
            if (!this.iab[i] && this.iaa[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.hZW) {
            case 0:
                System.arraycopy(this.iaa, 0, this.hZZ, 0, this.hZK.length);
                this.hZY = bTl();
                boolean aF = aF(this.hZX == 0 ? 1.0f : 0.0f);
                this.hZW = aF ? 2 : 1;
                z = aF;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.hZX > 0);
                boolean aF2 = aF(((float) (bTl() - this.hZY)) / this.hZX);
                this.hZW = aF2 ? 2 : 1;
                z = aF2;
                break;
        }
        for (int i = 0; i < this.hZK.length; i++) {
            a(canvas, this.hZK[i], (this.iaa[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.iac++;
            drawable.mutate().setAlpha(i);
            this.iac--;
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

    protected long bTl() {
        return SystemClock.uptimeMillis();
    }
}
