package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class f extends a {
    private static boolean pfK = true;
    int mAlpha;
    long mStartTimeMs;
    int pfE;
    int pfF;
    int[] pfG;
    int[] pfH;
    boolean[] pfI;
    int pfJ;
    private final Drawable[] pfs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.pfs = drawableArr;
        this.pfG = new int[drawableArr.length];
        this.pfH = new int[drawableArr.length];
        this.mAlpha = 255;
        this.pfI = new boolean[drawableArr.length];
        this.pfJ = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.pfJ == 0) {
            super.invalidateSelf();
        }
    }

    public void erD() {
        this.pfJ++;
    }

    public void erE() {
        this.pfJ--;
        invalidateSelf();
    }

    public void Qf(int i) {
        this.pfF = i;
        if (this.pfE == 1) {
            this.pfE = 0;
        }
    }

    private void resetInternal() {
        this.pfE = 2;
        Arrays.fill(this.pfG, 0);
        this.pfG[0] = 255;
        Arrays.fill(this.pfH, 0);
        this.pfH[0] = 255;
        Arrays.fill(this.pfI, false);
        this.pfI[0] = true;
    }

    public void Qg(int i) {
        this.pfE = 0;
        this.pfI[i] = true;
        invalidateSelf();
    }

    public void Qh(int i) {
        this.pfE = 0;
        this.pfI[i] = false;
        invalidateSelf();
    }

    public void erF() {
        this.pfE = 0;
        Arrays.fill(this.pfI, true);
        invalidateSelf();
    }

    public void erG() {
        this.pfE = 2;
        for (int i = 0; i < this.pfs.length; i++) {
            this.pfH[i] = this.pfI[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bs(float f) {
        boolean z = true;
        for (int i = 0; i < this.pfs.length; i++) {
            this.pfH[i] = (int) (((this.pfI[i] ? 1 : -1) * 255 * f) + this.pfG[i]);
            if (this.pfH[i] < 0) {
                this.pfH[i] = 0;
            }
            if (this.pfH[i] > 255) {
                this.pfH[i] = 255;
            }
            if (this.pfI[i] && this.pfH[i] < 255) {
                z = false;
            }
            if (!this.pfI[i] && this.pfH[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.pfE) {
            case 0:
                System.arraycopy(this.pfH, 0, this.pfG, 0, this.pfs.length);
                this.mStartTimeMs = erH();
                if (pfK && this.pfF != 0) {
                    r0 = 0.0f;
                }
                boolean bs = bs(r0);
                this.pfE = bs ? 2 : 1;
                z = bs;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.pfF > 0);
                boolean bs2 = bs(pfK ? ((float) (erH() - this.mStartTimeMs)) / this.pfF : 1.0f);
                this.pfE = bs2 ? 2 : 1;
                z = bs2;
                break;
        }
        for (int i = 0; i < this.pfs.length; i++) {
            a(canvas, this.pfs[i], (this.pfH[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.pfJ++;
            drawable.mutate().setAlpha(i);
            this.pfJ--;
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

    protected long erH() {
        return SystemClock.uptimeMillis();
    }
}
