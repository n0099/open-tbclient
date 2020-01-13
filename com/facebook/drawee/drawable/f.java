package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes12.dex */
public class f extends a {
    private static boolean lLr = true;
    long aGp;
    private final Drawable[] lLa;
    int lLm;
    int[] lLn;
    int[] lLo;
    boolean[] lLp;
    int lLq;
    int mAlpha;
    int mDurationMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.lLa = drawableArr;
        this.lLn = new int[drawableArr.length];
        this.lLo = new int[drawableArr.length];
        this.mAlpha = 255;
        this.lLp = new boolean[drawableArr.length];
        this.lLq = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.lLq == 0) {
            super.invalidateSelf();
        }
    }

    public void dld() {
        this.lLq++;
    }

    public void dle() {
        this.lLq--;
        invalidateSelf();
    }

    public void HB(int i) {
        this.mDurationMs = i;
        if (this.lLm == 1) {
            this.lLm = 0;
        }
    }

    private void resetInternal() {
        this.lLm = 2;
        Arrays.fill(this.lLn, 0);
        this.lLn[0] = 255;
        Arrays.fill(this.lLo, 0);
        this.lLo[0] = 255;
        Arrays.fill(this.lLp, false);
        this.lLp[0] = true;
    }

    public void HC(int i) {
        this.lLm = 0;
        this.lLp[i] = true;
        invalidateSelf();
    }

    public void HD(int i) {
        this.lLm = 0;
        this.lLp[i] = false;
        invalidateSelf();
    }

    public void dlf() {
        this.lLm = 0;
        Arrays.fill(this.lLp, true);
        invalidateSelf();
    }

    public void dlg() {
        this.lLm = 2;
        for (int i = 0; i < this.lLa.length; i++) {
            this.lLo[i] = this.lLp[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bm(float f) {
        boolean z = true;
        for (int i = 0; i < this.lLa.length; i++) {
            this.lLo[i] = (int) (((this.lLp[i] ? 1 : -1) * 255 * f) + this.lLn[i]);
            if (this.lLo[i] < 0) {
                this.lLo[i] = 0;
            }
            if (this.lLo[i] > 255) {
                this.lLo[i] = 255;
            }
            if (this.lLp[i] && this.lLo[i] < 255) {
                z = false;
            }
            if (!this.lLp[i] && this.lLo[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.lLm) {
            case 0:
                System.arraycopy(this.lLo, 0, this.lLn, 0, this.lLa.length);
                this.aGp = dlh();
                if (lLr && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bm = bm(r0);
                this.lLm = bm ? 2 : 1;
                z = bm;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bm2 = bm(lLr ? ((float) (dlh() - this.aGp)) / this.mDurationMs : 1.0f);
                this.lLm = bm2 ? 2 : 1;
                z = bm2;
                break;
        }
        for (int i = 0; i < this.lLa.length; i++) {
            a(canvas, this.lLa[i], (this.lLo[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.lLq++;
            drawable.mutate().setAlpha(i);
            this.lLq--;
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

    protected long dlh() {
        return SystemClock.uptimeMillis();
    }
}
