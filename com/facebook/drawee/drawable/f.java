package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] ilS;
    int ime;
    int imf;
    long imh;
    int[] imi;
    int[] imj;
    boolean[] imk;
    int iml;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.ilS = drawableArr;
        this.imi = new int[drawableArr.length];
        this.imj = new int[drawableArr.length];
        this.mAlpha = 255;
        this.imk = new boolean[drawableArr.length];
        this.iml = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.iml == 0) {
            super.invalidateSelf();
        }
    }

    public void bVy() {
        this.iml++;
    }

    public void bVz() {
        this.iml--;
        invalidateSelf();
    }

    public void yp(int i) {
        this.imf = i;
        if (this.ime == 1) {
            this.ime = 0;
        }
    }

    private void resetInternal() {
        this.ime = 2;
        Arrays.fill(this.imi, 0);
        this.imi[0] = 255;
        Arrays.fill(this.imj, 0);
        this.imj[0] = 255;
        Arrays.fill(this.imk, false);
        this.imk[0] = true;
    }

    public void yq(int i) {
        this.ime = 0;
        this.imk[i] = true;
        invalidateSelf();
    }

    public void yr(int i) {
        this.ime = 0;
        this.imk[i] = false;
        invalidateSelf();
    }

    public void bVA() {
        this.ime = 0;
        Arrays.fill(this.imk, true);
        invalidateSelf();
    }

    public void bVB() {
        this.ime = 2;
        for (int i = 0; i < this.ilS.length; i++) {
            this.imj[i] = this.imk[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aH(float f) {
        boolean z = true;
        for (int i = 0; i < this.ilS.length; i++) {
            this.imj[i] = (int) (((this.imk[i] ? 1 : -1) * 255 * f) + this.imi[i]);
            if (this.imj[i] < 0) {
                this.imj[i] = 0;
            }
            if (this.imj[i] > 255) {
                this.imj[i] = 255;
            }
            if (this.imk[i] && this.imj[i] < 255) {
                z = false;
            }
            if (!this.imk[i] && this.imj[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.ime) {
            case 0:
                System.arraycopy(this.imj, 0, this.imi, 0, this.ilS.length);
                this.imh = bVC();
                boolean aH = aH(this.imf == 0 ? 1.0f : 0.0f);
                this.ime = aH ? 2 : 1;
                z = aH;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.imf > 0);
                boolean aH2 = aH(((float) (bVC() - this.imh)) / this.imf);
                this.ime = aH2 ? 2 : 1;
                z = aH2;
                break;
        }
        for (int i = 0; i < this.ilS.length; i++) {
            a(canvas, this.ilS[i], (this.imj[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.iml++;
            drawable.mutate().setAlpha(i);
            this.iml--;
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

    protected long bVC() {
        return SystemClock.uptimeMillis();
    }
}
