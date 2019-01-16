package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] ina;
    int inm;
    int inn;
    long ino;
    int[] inp;
    int[] inq;
    boolean[] inr;

    /* renamed from: int  reason: not valid java name */
    int f1int;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.ina = drawableArr;
        this.inp = new int[drawableArr.length];
        this.inq = new int[drawableArr.length];
        this.mAlpha = 255;
        this.inr = new boolean[drawableArr.length];
        this.f1int = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f1int == 0) {
            super.invalidateSelf();
        }
    }

    public void bWg() {
        this.f1int++;
    }

    public void bWh() {
        this.f1int--;
        invalidateSelf();
    }

    public void yr(int i) {
        this.inn = i;
        if (this.inm == 1) {
            this.inm = 0;
        }
    }

    private void resetInternal() {
        this.inm = 2;
        Arrays.fill(this.inp, 0);
        this.inp[0] = 255;
        Arrays.fill(this.inq, 0);
        this.inq[0] = 255;
        Arrays.fill(this.inr, false);
        this.inr[0] = true;
    }

    public void ys(int i) {
        this.inm = 0;
        this.inr[i] = true;
        invalidateSelf();
    }

    public void yt(int i) {
        this.inm = 0;
        this.inr[i] = false;
        invalidateSelf();
    }

    public void bWi() {
        this.inm = 0;
        Arrays.fill(this.inr, true);
        invalidateSelf();
    }

    public void bWj() {
        this.inm = 2;
        for (int i = 0; i < this.ina.length; i++) {
            this.inq[i] = this.inr[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aH(float f) {
        boolean z = true;
        for (int i = 0; i < this.ina.length; i++) {
            this.inq[i] = (int) (((this.inr[i] ? 1 : -1) * 255 * f) + this.inp[i]);
            if (this.inq[i] < 0) {
                this.inq[i] = 0;
            }
            if (this.inq[i] > 255) {
                this.inq[i] = 255;
            }
            if (this.inr[i] && this.inq[i] < 255) {
                z = false;
            }
            if (!this.inr[i] && this.inq[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.inm) {
            case 0:
                System.arraycopy(this.inq, 0, this.inp, 0, this.ina.length);
                this.ino = bWk();
                boolean aH = aH(this.inn == 0 ? 1.0f : 0.0f);
                this.inm = aH ? 2 : 1;
                z = aH;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.inn > 0);
                boolean aH2 = aH(((float) (bWk() - this.ino)) / this.inn);
                this.inm = aH2 ? 2 : 1;
                z = aH2;
                break;
        }
        for (int i = 0; i < this.ina.length; i++) {
            a(canvas, this.ina[i], (this.inq[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.f1int++;
            drawable.mutate().setAlpha(i);
            this.f1int--;
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

    protected long bWk() {
        return SystemClock.uptimeMillis();
    }
}
