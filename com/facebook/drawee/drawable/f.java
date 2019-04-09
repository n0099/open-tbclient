package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    int jCA;
    private final Drawable[] jCi;
    int jCu;
    int jCv;
    long jCw;
    int[] jCx;
    int[] jCy;
    boolean[] jCz;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.jCi = drawableArr;
        this.jCx = new int[drawableArr.length];
        this.jCy = new int[drawableArr.length];
        this.mAlpha = 255;
        this.jCz = new boolean[drawableArr.length];
        this.jCA = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jCA == 0) {
            super.invalidateSelf();
        }
    }

    public void cvl() {
        this.jCA++;
    }

    public void cvm() {
        this.jCA--;
        invalidateSelf();
    }

    public void BU(int i) {
        this.jCv = i;
        if (this.jCu == 1) {
            this.jCu = 0;
        }
    }

    private void resetInternal() {
        this.jCu = 2;
        Arrays.fill(this.jCx, 0);
        this.jCx[0] = 255;
        Arrays.fill(this.jCy, 0);
        this.jCy[0] = 255;
        Arrays.fill(this.jCz, false);
        this.jCz[0] = true;
    }

    public void BV(int i) {
        this.jCu = 0;
        this.jCz[i] = true;
        invalidateSelf();
    }

    public void BW(int i) {
        this.jCu = 0;
        this.jCz[i] = false;
        invalidateSelf();
    }

    public void cvn() {
        this.jCu = 0;
        Arrays.fill(this.jCz, true);
        invalidateSelf();
    }

    public void cvo() {
        this.jCu = 2;
        for (int i = 0; i < this.jCi.length; i++) {
            this.jCy[i] = this.jCz[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aU(float f) {
        boolean z = true;
        for (int i = 0; i < this.jCi.length; i++) {
            this.jCy[i] = (int) (((this.jCz[i] ? 1 : -1) * 255 * f) + this.jCx[i]);
            if (this.jCy[i] < 0) {
                this.jCy[i] = 0;
            }
            if (this.jCy[i] > 255) {
                this.jCy[i] = 255;
            }
            if (this.jCz[i] && this.jCy[i] < 255) {
                z = false;
            }
            if (!this.jCz[i] && this.jCy[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.jCu) {
            case 0:
                System.arraycopy(this.jCy, 0, this.jCx, 0, this.jCi.length);
                this.jCw = cvp();
                boolean aU = aU(this.jCv == 0 ? 1.0f : 0.0f);
                this.jCu = aU ? 2 : 1;
                z = aU;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.jCv > 0);
                boolean aU2 = aU(((float) (cvp() - this.jCw)) / this.jCv);
                this.jCu = aU2 ? 2 : 1;
                z = aU2;
                break;
        }
        for (int i = 0; i < this.jCi.length; i++) {
            a(canvas, this.jCi[i], (this.jCy[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.jCA++;
            drawable.mutate().setAlpha(i);
            this.jCA--;
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

    protected long cvp() {
        return SystemClock.uptimeMillis();
    }
}
