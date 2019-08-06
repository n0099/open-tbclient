package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    long aeG;
    int[] kdA;
    boolean[] kdB;
    int kdC;
    private final Drawable[] kdl;
    int kdx;
    int kdy;
    int[] kdz;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.kdl = drawableArr;
        this.kdz = new int[drawableArr.length];
        this.kdA = new int[drawableArr.length];
        this.mAlpha = 255;
        this.kdB = new boolean[drawableArr.length];
        this.kdC = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.kdC == 0) {
            super.invalidateSelf();
        }
    }

    public void cGF() {
        this.kdC++;
    }

    public void cGG() {
        this.kdC--;
        invalidateSelf();
    }

    public void DH(int i) {
        this.kdy = i;
        if (this.kdx == 1) {
            this.kdx = 0;
        }
    }

    private void resetInternal() {
        this.kdx = 2;
        Arrays.fill(this.kdz, 0);
        this.kdz[0] = 255;
        Arrays.fill(this.kdA, 0);
        this.kdA[0] = 255;
        Arrays.fill(this.kdB, false);
        this.kdB[0] = true;
    }

    public void DI(int i) {
        this.kdx = 0;
        this.kdB[i] = true;
        invalidateSelf();
    }

    public void DJ(int i) {
        this.kdx = 0;
        this.kdB[i] = false;
        invalidateSelf();
    }

    public void cGH() {
        this.kdx = 0;
        Arrays.fill(this.kdB, true);
        invalidateSelf();
    }

    public void cGI() {
        this.kdx = 2;
        for (int i = 0; i < this.kdl.length; i++) {
            this.kdA[i] = this.kdB[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aZ(float f) {
        boolean z = true;
        for (int i = 0; i < this.kdl.length; i++) {
            this.kdA[i] = (int) (((this.kdB[i] ? 1 : -1) * 255 * f) + this.kdz[i]);
            if (this.kdA[i] < 0) {
                this.kdA[i] = 0;
            }
            if (this.kdA[i] > 255) {
                this.kdA[i] = 255;
            }
            if (this.kdB[i] && this.kdA[i] < 255) {
                z = false;
            }
            if (!this.kdB[i] && this.kdA[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.kdx) {
            case 0:
                System.arraycopy(this.kdA, 0, this.kdz, 0, this.kdl.length);
                this.aeG = cGJ();
                boolean aZ = aZ(this.kdy == 0 ? 1.0f : 0.0f);
                this.kdx = aZ ? 2 : 1;
                z = aZ;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.kdy > 0);
                boolean aZ2 = aZ(((float) (cGJ() - this.aeG)) / this.kdy);
                this.kdx = aZ2 ? 2 : 1;
                z = aZ2;
                break;
        }
        for (int i = 0; i < this.kdl.length; i++) {
            a(canvas, this.kdl[i], (this.kdA[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.kdC++;
            drawable.mutate().setAlpha(i);
            this.kdC--;
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

    protected long cGJ() {
        return SystemClock.uptimeMillis();
    }
}
