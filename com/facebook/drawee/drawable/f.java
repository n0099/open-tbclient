package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] jCh;
    int jCt;
    int jCu;
    long jCv;
    int[] jCw;
    int[] jCx;
    boolean[] jCy;
    int jCz;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.jCh = drawableArr;
        this.jCw = new int[drawableArr.length];
        this.jCx = new int[drawableArr.length];
        this.mAlpha = 255;
        this.jCy = new boolean[drawableArr.length];
        this.jCz = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jCz == 0) {
            super.invalidateSelf();
        }
    }

    public void cvl() {
        this.jCz++;
    }

    public void cvm() {
        this.jCz--;
        invalidateSelf();
    }

    public void BU(int i) {
        this.jCu = i;
        if (this.jCt == 1) {
            this.jCt = 0;
        }
    }

    private void resetInternal() {
        this.jCt = 2;
        Arrays.fill(this.jCw, 0);
        this.jCw[0] = 255;
        Arrays.fill(this.jCx, 0);
        this.jCx[0] = 255;
        Arrays.fill(this.jCy, false);
        this.jCy[0] = true;
    }

    public void BV(int i) {
        this.jCt = 0;
        this.jCy[i] = true;
        invalidateSelf();
    }

    public void BW(int i) {
        this.jCt = 0;
        this.jCy[i] = false;
        invalidateSelf();
    }

    public void cvn() {
        this.jCt = 0;
        Arrays.fill(this.jCy, true);
        invalidateSelf();
    }

    public void cvo() {
        this.jCt = 2;
        for (int i = 0; i < this.jCh.length; i++) {
            this.jCx[i] = this.jCy[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aU(float f) {
        boolean z = true;
        for (int i = 0; i < this.jCh.length; i++) {
            this.jCx[i] = (int) (((this.jCy[i] ? 1 : -1) * 255 * f) + this.jCw[i]);
            if (this.jCx[i] < 0) {
                this.jCx[i] = 0;
            }
            if (this.jCx[i] > 255) {
                this.jCx[i] = 255;
            }
            if (this.jCy[i] && this.jCx[i] < 255) {
                z = false;
            }
            if (!this.jCy[i] && this.jCx[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.jCt) {
            case 0:
                System.arraycopy(this.jCx, 0, this.jCw, 0, this.jCh.length);
                this.jCv = cvp();
                boolean aU = aU(this.jCu == 0 ? 1.0f : 0.0f);
                this.jCt = aU ? 2 : 1;
                z = aU;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.jCu > 0);
                boolean aU2 = aU(((float) (cvp() - this.jCv)) / this.jCu);
                this.jCt = aU2 ? 2 : 1;
                z = aU2;
                break;
        }
        for (int i = 0; i < this.jCh.length; i++) {
            a(canvas, this.jCh[i], (this.jCx[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.jCz++;
            drawable.mutate().setAlpha(i);
            this.jCz--;
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
