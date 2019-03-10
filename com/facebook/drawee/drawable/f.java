package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] jCV;
    int jDh;
    int jDi;
    long jDj;
    int[] jDk;
    int[] jDl;
    boolean[] jDm;
    int jDn;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.jCV = drawableArr;
        this.jDk = new int[drawableArr.length];
        this.jDl = new int[drawableArr.length];
        this.mAlpha = 255;
        this.jDm = new boolean[drawableArr.length];
        this.jDn = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jDn == 0) {
            super.invalidateSelf();
        }
    }

    public void cvp() {
        this.jDn++;
    }

    public void cvq() {
        this.jDn--;
        invalidateSelf();
    }

    public void Ce(int i) {
        this.jDi = i;
        if (this.jDh == 1) {
            this.jDh = 0;
        }
    }

    private void resetInternal() {
        this.jDh = 2;
        Arrays.fill(this.jDk, 0);
        this.jDk[0] = 255;
        Arrays.fill(this.jDl, 0);
        this.jDl[0] = 255;
        Arrays.fill(this.jDm, false);
        this.jDm[0] = true;
    }

    public void Cf(int i) {
        this.jDh = 0;
        this.jDm[i] = true;
        invalidateSelf();
    }

    public void Cg(int i) {
        this.jDh = 0;
        this.jDm[i] = false;
        invalidateSelf();
    }

    public void cvr() {
        this.jDh = 0;
        Arrays.fill(this.jDm, true);
        invalidateSelf();
    }

    public void cvs() {
        this.jDh = 2;
        for (int i = 0; i < this.jCV.length; i++) {
            this.jDl[i] = this.jDm[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aU(float f) {
        boolean z = true;
        for (int i = 0; i < this.jCV.length; i++) {
            this.jDl[i] = (int) (((this.jDm[i] ? 1 : -1) * 255 * f) + this.jDk[i]);
            if (this.jDl[i] < 0) {
                this.jDl[i] = 0;
            }
            if (this.jDl[i] > 255) {
                this.jDl[i] = 255;
            }
            if (this.jDm[i] && this.jDl[i] < 255) {
                z = false;
            }
            if (!this.jDm[i] && this.jDl[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.jDh) {
            case 0:
                System.arraycopy(this.jDl, 0, this.jDk, 0, this.jCV.length);
                this.jDj = cvt();
                boolean aU = aU(this.jDi == 0 ? 1.0f : 0.0f);
                this.jDh = aU ? 2 : 1;
                z = aU;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.jDi > 0);
                boolean aU2 = aU(((float) (cvt() - this.jDj)) / this.jDi);
                this.jDh = aU2 ? 2 : 1;
                z = aU2;
                break;
        }
        for (int i = 0; i < this.jCV.length; i++) {
            a(canvas, this.jCV[i], (this.jDl[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.jDn++;
            drawable.mutate().setAlpha(i);
            this.jDn--;
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

    protected long cvt() {
        return SystemClock.uptimeMillis();
    }
}
