package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] iiI;
    int iiU;
    int iiV;
    long iiW;
    int[] iiX;
    int[] iiY;
    boolean[] iiZ;
    int ija;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.iiI = drawableArr;
        this.iiX = new int[drawableArr.length];
        this.iiY = new int[drawableArr.length];
        this.mAlpha = 255;
        this.iiZ = new boolean[drawableArr.length];
        this.ija = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.ija == 0) {
            super.invalidateSelf();
        }
    }

    public void bUI() {
        this.ija++;
    }

    public void bUJ() {
        this.ija--;
        invalidateSelf();
    }

    public void yc(int i) {
        this.iiV = i;
        if (this.iiU == 1) {
            this.iiU = 0;
        }
    }

    private void resetInternal() {
        this.iiU = 2;
        Arrays.fill(this.iiX, 0);
        this.iiX[0] = 255;
        Arrays.fill(this.iiY, 0);
        this.iiY[0] = 255;
        Arrays.fill(this.iiZ, false);
        this.iiZ[0] = true;
    }

    public void yd(int i) {
        this.iiU = 0;
        this.iiZ[i] = true;
        invalidateSelf();
    }

    public void ye(int i) {
        this.iiU = 0;
        this.iiZ[i] = false;
        invalidateSelf();
    }

    public void bUK() {
        this.iiU = 0;
        Arrays.fill(this.iiZ, true);
        invalidateSelf();
    }

    public void bUL() {
        this.iiU = 2;
        for (int i = 0; i < this.iiI.length; i++) {
            this.iiY[i] = this.iiZ[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aH(float f) {
        boolean z = true;
        for (int i = 0; i < this.iiI.length; i++) {
            this.iiY[i] = (int) (((this.iiZ[i] ? 1 : -1) * 255 * f) + this.iiX[i]);
            if (this.iiY[i] < 0) {
                this.iiY[i] = 0;
            }
            if (this.iiY[i] > 255) {
                this.iiY[i] = 255;
            }
            if (this.iiZ[i] && this.iiY[i] < 255) {
                z = false;
            }
            if (!this.iiZ[i] && this.iiY[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.iiU) {
            case 0:
                System.arraycopy(this.iiY, 0, this.iiX, 0, this.iiI.length);
                this.iiW = bUM();
                boolean aH = aH(this.iiV == 0 ? 1.0f : 0.0f);
                this.iiU = aH ? 2 : 1;
                z = aH;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.iiV > 0);
                boolean aH2 = aH(((float) (bUM() - this.iiW)) / this.iiV);
                this.iiU = aH2 ? 2 : 1;
                z = aH2;
                break;
        }
        for (int i = 0; i < this.iiI.length; i++) {
            a(canvas, this.iiI[i], (this.iiY[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.ija++;
            drawable.mutate().setAlpha(i);
            this.ija--;
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

    protected long bUM() {
        return SystemClock.uptimeMillis();
    }
}
