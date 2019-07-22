package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    long aeG;
    private final Drawable[] kcf;
    int kcr;
    int kcs;
    int[] kct;
    int[] kcu;
    boolean[] kcv;
    int kcw;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.kcf = drawableArr;
        this.kct = new int[drawableArr.length];
        this.kcu = new int[drawableArr.length];
        this.mAlpha = 255;
        this.kcv = new boolean[drawableArr.length];
        this.kcw = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.kcw == 0) {
            super.invalidateSelf();
        }
    }

    public void cGk() {
        this.kcw++;
    }

    public void cGl() {
        this.kcw--;
        invalidateSelf();
    }

    public void DF(int i) {
        this.kcs = i;
        if (this.kcr == 1) {
            this.kcr = 0;
        }
    }

    private void resetInternal() {
        this.kcr = 2;
        Arrays.fill(this.kct, 0);
        this.kct[0] = 255;
        Arrays.fill(this.kcu, 0);
        this.kcu[0] = 255;
        Arrays.fill(this.kcv, false);
        this.kcv[0] = true;
    }

    public void DG(int i) {
        this.kcr = 0;
        this.kcv[i] = true;
        invalidateSelf();
    }

    public void DH(int i) {
        this.kcr = 0;
        this.kcv[i] = false;
        invalidateSelf();
    }

    public void cGm() {
        this.kcr = 0;
        Arrays.fill(this.kcv, true);
        invalidateSelf();
    }

    public void cGn() {
        this.kcr = 2;
        for (int i = 0; i < this.kcf.length; i++) {
            this.kcu[i] = this.kcv[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aZ(float f) {
        boolean z = true;
        for (int i = 0; i < this.kcf.length; i++) {
            this.kcu[i] = (int) (((this.kcv[i] ? 1 : -1) * 255 * f) + this.kct[i]);
            if (this.kcu[i] < 0) {
                this.kcu[i] = 0;
            }
            if (this.kcu[i] > 255) {
                this.kcu[i] = 255;
            }
            if (this.kcv[i] && this.kcu[i] < 255) {
                z = false;
            }
            if (!this.kcv[i] && this.kcu[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.kcr) {
            case 0:
                System.arraycopy(this.kcu, 0, this.kct, 0, this.kcf.length);
                this.aeG = cGo();
                boolean aZ = aZ(this.kcs == 0 ? 1.0f : 0.0f);
                this.kcr = aZ ? 2 : 1;
                z = aZ;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.kcs > 0);
                boolean aZ2 = aZ(((float) (cGo() - this.aeG)) / this.kcs);
                this.kcr = aZ2 ? 2 : 1;
                z = aZ2;
                break;
        }
        for (int i = 0; i < this.kcf.length; i++) {
            a(canvas, this.kcf[i], (this.kcu[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.kcw++;
            drawable.mutate().setAlpha(i);
            this.kcw--;
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

    protected long cGo() {
        return SystemClock.uptimeMillis();
    }
}
