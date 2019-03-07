package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] jCC;
    int jCO;
    int jCP;
    long jCQ;
    int[] jCR;
    int[] jCS;
    boolean[] jCT;
    int jCU;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.jCC = drawableArr;
        this.jCR = new int[drawableArr.length];
        this.jCS = new int[drawableArr.length];
        this.mAlpha = 255;
        this.jCT = new boolean[drawableArr.length];
        this.jCU = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jCU == 0) {
            super.invalidateSelf();
        }
    }

    public void cvf() {
        this.jCU++;
    }

    public void cvg() {
        this.jCU--;
        invalidateSelf();
    }

    public void Cd(int i) {
        this.jCP = i;
        if (this.jCO == 1) {
            this.jCO = 0;
        }
    }

    private void resetInternal() {
        this.jCO = 2;
        Arrays.fill(this.jCR, 0);
        this.jCR[0] = 255;
        Arrays.fill(this.jCS, 0);
        this.jCS[0] = 255;
        Arrays.fill(this.jCT, false);
        this.jCT[0] = true;
    }

    public void Ce(int i) {
        this.jCO = 0;
        this.jCT[i] = true;
        invalidateSelf();
    }

    public void Cf(int i) {
        this.jCO = 0;
        this.jCT[i] = false;
        invalidateSelf();
    }

    public void cvh() {
        this.jCO = 0;
        Arrays.fill(this.jCT, true);
        invalidateSelf();
    }

    public void cvi() {
        this.jCO = 2;
        for (int i = 0; i < this.jCC.length; i++) {
            this.jCS[i] = this.jCT[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aU(float f) {
        boolean z = true;
        for (int i = 0; i < this.jCC.length; i++) {
            this.jCS[i] = (int) (((this.jCT[i] ? 1 : -1) * 255 * f) + this.jCR[i]);
            if (this.jCS[i] < 0) {
                this.jCS[i] = 0;
            }
            if (this.jCS[i] > 255) {
                this.jCS[i] = 255;
            }
            if (this.jCT[i] && this.jCS[i] < 255) {
                z = false;
            }
            if (!this.jCT[i] && this.jCS[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.jCO) {
            case 0:
                System.arraycopy(this.jCS, 0, this.jCR, 0, this.jCC.length);
                this.jCQ = cvj();
                boolean aU = aU(this.jCP == 0 ? 1.0f : 0.0f);
                this.jCO = aU ? 2 : 1;
                z = aU;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.jCP > 0);
                boolean aU2 = aU(((float) (cvj() - this.jCQ)) / this.jCP);
                this.jCO = aU2 ? 2 : 1;
                z = aU2;
                break;
        }
        for (int i = 0; i < this.jCC.length; i++) {
            a(canvas, this.jCC[i], (this.jCS[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.jCU++;
            drawable.mutate().setAlpha(i);
            this.jCU--;
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

    protected long cvj() {
        return SystemClock.uptimeMillis();
    }
}
