package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] jCN;
    int jCZ;
    int jDa;
    long jDb;
    int[] jDc;
    int[] jDd;
    boolean[] jDe;
    int jDf;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.jCN = drawableArr;
        this.jDc = new int[drawableArr.length];
        this.jDd = new int[drawableArr.length];
        this.mAlpha = 255;
        this.jDe = new boolean[drawableArr.length];
        this.jDf = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jDf == 0) {
            super.invalidateSelf();
        }
    }

    public void cvs() {
        this.jDf++;
    }

    public void cvt() {
        this.jDf--;
        invalidateSelf();
    }

    public void Ce(int i) {
        this.jDa = i;
        if (this.jCZ == 1) {
            this.jCZ = 0;
        }
    }

    private void resetInternal() {
        this.jCZ = 2;
        Arrays.fill(this.jDc, 0);
        this.jDc[0] = 255;
        Arrays.fill(this.jDd, 0);
        this.jDd[0] = 255;
        Arrays.fill(this.jDe, false);
        this.jDe[0] = true;
    }

    public void Cf(int i) {
        this.jCZ = 0;
        this.jDe[i] = true;
        invalidateSelf();
    }

    public void Cg(int i) {
        this.jCZ = 0;
        this.jDe[i] = false;
        invalidateSelf();
    }

    public void cvu() {
        this.jCZ = 0;
        Arrays.fill(this.jDe, true);
        invalidateSelf();
    }

    public void cvv() {
        this.jCZ = 2;
        for (int i = 0; i < this.jCN.length; i++) {
            this.jDd[i] = this.jDe[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aU(float f) {
        boolean z = true;
        for (int i = 0; i < this.jCN.length; i++) {
            this.jDd[i] = (int) (((this.jDe[i] ? 1 : -1) * 255 * f) + this.jDc[i]);
            if (this.jDd[i] < 0) {
                this.jDd[i] = 0;
            }
            if (this.jDd[i] > 255) {
                this.jDd[i] = 255;
            }
            if (this.jDe[i] && this.jDd[i] < 255) {
                z = false;
            }
            if (!this.jDe[i] && this.jDd[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.jCZ) {
            case 0:
                System.arraycopy(this.jDd, 0, this.jDc, 0, this.jCN.length);
                this.jDb = cvw();
                boolean aU = aU(this.jDa == 0 ? 1.0f : 0.0f);
                this.jCZ = aU ? 2 : 1;
                z = aU;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.jDa > 0);
                boolean aU2 = aU(((float) (cvw() - this.jDb)) / this.jDa);
                this.jCZ = aU2 ? 2 : 1;
                z = aU2;
                break;
        }
        for (int i = 0; i < this.jCN.length; i++) {
            a(canvas, this.jCN[i], (this.jDd[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.jDf++;
            drawable.mutate().setAlpha(i);
            this.jDf--;
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

    protected long cvw() {
        return SystemClock.uptimeMillis();
    }
}
