package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes8.dex */
public class f extends a {
    private static boolean pfI = true;
    int mAlpha;
    long mStartTimeMs;
    int pfC;
    int pfD;
    int[] pfE;
    int[] pfF;
    boolean[] pfG;
    int pfH;
    private final Drawable[] pfq;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.pfq = drawableArr;
        this.pfE = new int[drawableArr.length];
        this.pfF = new int[drawableArr.length];
        this.mAlpha = 255;
        this.pfG = new boolean[drawableArr.length];
        this.pfH = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.pfH == 0) {
            super.invalidateSelf();
        }
    }

    public void erC() {
        this.pfH++;
    }

    public void erD() {
        this.pfH--;
        invalidateSelf();
    }

    public void Qf(int i) {
        this.pfD = i;
        if (this.pfC == 1) {
            this.pfC = 0;
        }
    }

    private void resetInternal() {
        this.pfC = 2;
        Arrays.fill(this.pfE, 0);
        this.pfE[0] = 255;
        Arrays.fill(this.pfF, 0);
        this.pfF[0] = 255;
        Arrays.fill(this.pfG, false);
        this.pfG[0] = true;
    }

    public void Qg(int i) {
        this.pfC = 0;
        this.pfG[i] = true;
        invalidateSelf();
    }

    public void Qh(int i) {
        this.pfC = 0;
        this.pfG[i] = false;
        invalidateSelf();
    }

    public void erE() {
        this.pfC = 0;
        Arrays.fill(this.pfG, true);
        invalidateSelf();
    }

    public void erF() {
        this.pfC = 2;
        for (int i = 0; i < this.pfq.length; i++) {
            this.pfF[i] = this.pfG[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bs(float f) {
        boolean z = true;
        for (int i = 0; i < this.pfq.length; i++) {
            this.pfF[i] = (int) (((this.pfG[i] ? 1 : -1) * 255 * f) + this.pfE[i]);
            if (this.pfF[i] < 0) {
                this.pfF[i] = 0;
            }
            if (this.pfF[i] > 255) {
                this.pfF[i] = 255;
            }
            if (this.pfG[i] && this.pfF[i] < 255) {
                z = false;
            }
            if (!this.pfG[i] && this.pfF[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.pfC) {
            case 0:
                System.arraycopy(this.pfF, 0, this.pfE, 0, this.pfq.length);
                this.mStartTimeMs = erG();
                if (pfI && this.pfD != 0) {
                    r0 = 0.0f;
                }
                boolean bs = bs(r0);
                this.pfC = bs ? 2 : 1;
                z = bs;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.pfD > 0);
                boolean bs2 = bs(pfI ? ((float) (erG() - this.mStartTimeMs)) / this.pfD : 1.0f);
                this.pfC = bs2 ? 2 : 1;
                z = bs2;
                break;
        }
        for (int i = 0; i < this.pfq.length; i++) {
            a(canvas, this.pfq[i], (this.pfF[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.pfH++;
            drawable.mutate().setAlpha(i);
            this.pfH--;
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

    protected long erG() {
        return SystemClock.uptimeMillis();
    }
}
