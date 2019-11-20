package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    long axM;
    private final Drawable[] kda;
    int kdm;
    int kdn;
    int[] kdo;
    int[] kdp;
    boolean[] kdq;
    int kdr;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.kda = drawableArr;
        this.kdo = new int[drawableArr.length];
        this.kdp = new int[drawableArr.length];
        this.mAlpha = 255;
        this.kdq = new boolean[drawableArr.length];
        this.kdr = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.kdr == 0) {
            super.invalidateSelf();
        }
    }

    public void cEp() {
        this.kdr++;
    }

    public void cEq() {
        this.kdr--;
        invalidateSelf();
    }

    public void Cg(int i) {
        this.kdn = i;
        if (this.kdm == 1) {
            this.kdm = 0;
        }
    }

    private void resetInternal() {
        this.kdm = 2;
        Arrays.fill(this.kdo, 0);
        this.kdo[0] = 255;
        Arrays.fill(this.kdp, 0);
        this.kdp[0] = 255;
        Arrays.fill(this.kdq, false);
        this.kdq[0] = true;
    }

    public void Ch(int i) {
        this.kdm = 0;
        this.kdq[i] = true;
        invalidateSelf();
    }

    public void Ci(int i) {
        this.kdm = 0;
        this.kdq[i] = false;
        invalidateSelf();
    }

    public void cEr() {
        this.kdm = 0;
        Arrays.fill(this.kdq, true);
        invalidateSelf();
    }

    public void cEs() {
        this.kdm = 2;
        for (int i = 0; i < this.kda.length; i++) {
            this.kdp[i] = this.kdq[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aD(float f) {
        boolean z = true;
        for (int i = 0; i < this.kda.length; i++) {
            this.kdp[i] = (int) (((this.kdq[i] ? 1 : -1) * 255 * f) + this.kdo[i]);
            if (this.kdp[i] < 0) {
                this.kdp[i] = 0;
            }
            if (this.kdp[i] > 255) {
                this.kdp[i] = 255;
            }
            if (this.kdq[i] && this.kdp[i] < 255) {
                z = false;
            }
            if (!this.kdq[i] && this.kdp[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.kdm) {
            case 0:
                System.arraycopy(this.kdp, 0, this.kdo, 0, this.kda.length);
                this.axM = cEt();
                boolean aD = aD(this.kdn == 0 ? 1.0f : 0.0f);
                this.kdm = aD ? 2 : 1;
                z = aD;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.kdn > 0);
                boolean aD2 = aD(((float) (cEt() - this.axM)) / this.kdn);
                this.kdm = aD2 ? 2 : 1;
                z = aD2;
                break;
        }
        for (int i = 0; i < this.kda.length; i++) {
            a(canvas, this.kda[i], (this.kdp[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.kdr++;
            drawable.mutate().setAlpha(i);
            this.kdr--;
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

    protected long cEt() {
        return SystemClock.uptimeMillis();
    }
}
