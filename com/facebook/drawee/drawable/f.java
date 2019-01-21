package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] inb;
    int inn;
    int ino;
    long inp;
    int[] inq;
    int[] inr;

    /* renamed from: int  reason: not valid java name */
    boolean[] f1int;
    int inu;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.inb = drawableArr;
        this.inq = new int[drawableArr.length];
        this.inr = new int[drawableArr.length];
        this.mAlpha = 255;
        this.f1int = new boolean[drawableArr.length];
        this.inu = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.inu == 0) {
            super.invalidateSelf();
        }
    }

    public void bWg() {
        this.inu++;
    }

    public void bWh() {
        this.inu--;
        invalidateSelf();
    }

    public void yr(int i) {
        this.ino = i;
        if (this.inn == 1) {
            this.inn = 0;
        }
    }

    private void resetInternal() {
        this.inn = 2;
        Arrays.fill(this.inq, 0);
        this.inq[0] = 255;
        Arrays.fill(this.inr, 0);
        this.inr[0] = 255;
        Arrays.fill(this.f1int, false);
        this.f1int[0] = true;
    }

    public void ys(int i) {
        this.inn = 0;
        this.f1int[i] = true;
        invalidateSelf();
    }

    public void yt(int i) {
        this.inn = 0;
        this.f1int[i] = false;
        invalidateSelf();
    }

    public void bWi() {
        this.inn = 0;
        Arrays.fill(this.f1int, true);
        invalidateSelf();
    }

    public void bWj() {
        this.inn = 2;
        for (int i = 0; i < this.inb.length; i++) {
            this.inr[i] = this.f1int[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aH(float f) {
        boolean z = true;
        for (int i = 0; i < this.inb.length; i++) {
            this.inr[i] = (int) (((this.f1int[i] ? 1 : -1) * 255 * f) + this.inq[i]);
            if (this.inr[i] < 0) {
                this.inr[i] = 0;
            }
            if (this.inr[i] > 255) {
                this.inr[i] = 255;
            }
            if (this.f1int[i] && this.inr[i] < 255) {
                z = false;
            }
            if (!this.f1int[i] && this.inr[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.inn) {
            case 0:
                System.arraycopy(this.inr, 0, this.inq, 0, this.inb.length);
                this.inp = bWk();
                boolean aH = aH(this.ino == 0 ? 1.0f : 0.0f);
                this.inn = aH ? 2 : 1;
                z = aH;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.ino > 0);
                boolean aH2 = aH(((float) (bWk() - this.inp)) / this.ino);
                this.inn = aH2 ? 2 : 1;
                z = aH2;
                break;
        }
        for (int i = 0; i < this.inb.length; i++) {
            a(canvas, this.inb[i], (this.inr[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.inu++;
            drawable.mutate().setAlpha(i);
            this.inu--;
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
