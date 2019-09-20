package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    long aeG;
    private final Drawable[] kfJ;
    int kfV;
    int kfW;
    int[] kfX;
    int[] kfY;
    boolean[] kfZ;
    int kga;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.kfJ = drawableArr;
        this.kfX = new int[drawableArr.length];
        this.kfY = new int[drawableArr.length];
        this.mAlpha = 255;
        this.kfZ = new boolean[drawableArr.length];
        this.kga = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.kga == 0) {
            super.invalidateSelf();
        }
    }

    public void cHt() {
        this.kga++;
    }

    public void cHu() {
        this.kga--;
        invalidateSelf();
    }

    public void DL(int i) {
        this.kfW = i;
        if (this.kfV == 1) {
            this.kfV = 0;
        }
    }

    private void resetInternal() {
        this.kfV = 2;
        Arrays.fill(this.kfX, 0);
        this.kfX[0] = 255;
        Arrays.fill(this.kfY, 0);
        this.kfY[0] = 255;
        Arrays.fill(this.kfZ, false);
        this.kfZ[0] = true;
    }

    public void DM(int i) {
        this.kfV = 0;
        this.kfZ[i] = true;
        invalidateSelf();
    }

    public void DN(int i) {
        this.kfV = 0;
        this.kfZ[i] = false;
        invalidateSelf();
    }

    public void cHv() {
        this.kfV = 0;
        Arrays.fill(this.kfZ, true);
        invalidateSelf();
    }

    public void cHw() {
        this.kfV = 2;
        for (int i = 0; i < this.kfJ.length; i++) {
            this.kfY[i] = this.kfZ[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean ba(float f) {
        boolean z = true;
        for (int i = 0; i < this.kfJ.length; i++) {
            this.kfY[i] = (int) (((this.kfZ[i] ? 1 : -1) * 255 * f) + this.kfX[i]);
            if (this.kfY[i] < 0) {
                this.kfY[i] = 0;
            }
            if (this.kfY[i] > 255) {
                this.kfY[i] = 255;
            }
            if (this.kfZ[i] && this.kfY[i] < 255) {
                z = false;
            }
            if (!this.kfZ[i] && this.kfY[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.kfV) {
            case 0:
                System.arraycopy(this.kfY, 0, this.kfX, 0, this.kfJ.length);
                this.aeG = cHx();
                boolean ba = ba(this.kfW == 0 ? 1.0f : 0.0f);
                this.kfV = ba ? 2 : 1;
                z = ba;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.kfW > 0);
                boolean ba2 = ba(((float) (cHx() - this.aeG)) / this.kfW);
                this.kfV = ba2 ? 2 : 1;
                z = ba2;
                break;
        }
        for (int i = 0; i < this.kfJ.length; i++) {
            a(canvas, this.kfJ[i], (this.kfY[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.kga++;
            drawable.mutate().setAlpha(i);
            this.kga--;
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

    protected long cHx() {
        return SystemClock.uptimeMillis();
    }
}
