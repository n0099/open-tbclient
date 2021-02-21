package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class f extends a {
    private static boolean pDf = true;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;
    private final Drawable[] pCO;
    int pDa;
    int[] pDb;
    int[] pDc;
    boolean[] pDd;
    int pDe;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.pCO = drawableArr;
        this.pDb = new int[drawableArr.length];
        this.pDc = new int[drawableArr.length];
        this.mAlpha = 255;
        this.pDd = new boolean[drawableArr.length];
        this.pDe = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.pDe == 0) {
            super.invalidateSelf();
        }
    }

    public void eut() {
        this.pDe++;
    }

    public void euu() {
        this.pDe--;
        invalidateSelf();
    }

    public void Pi(int i) {
        this.mDurationMs = i;
        if (this.pDa == 1) {
            this.pDa = 0;
        }
    }

    private void resetInternal() {
        this.pDa = 2;
        Arrays.fill(this.pDb, 0);
        this.pDb[0] = 255;
        Arrays.fill(this.pDc, 0);
        this.pDc[0] = 255;
        Arrays.fill(this.pDd, false);
        this.pDd[0] = true;
    }

    public void Pj(int i) {
        this.pDa = 0;
        this.pDd[i] = true;
        invalidateSelf();
    }

    public void Pk(int i) {
        this.pDa = 0;
        this.pDd[i] = false;
        invalidateSelf();
    }

    public void euv() {
        this.pDa = 0;
        Arrays.fill(this.pDd, true);
        invalidateSelf();
    }

    public void euw() {
        this.pDa = 2;
        for (int i = 0; i < this.pCO.length; i++) {
            this.pDc[i] = this.pDd[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bH(float f) {
        boolean z = true;
        for (int i = 0; i < this.pCO.length; i++) {
            this.pDc[i] = (int) (((this.pDd[i] ? 1 : -1) * 255 * f) + this.pDb[i]);
            if (this.pDc[i] < 0) {
                this.pDc[i] = 0;
            }
            if (this.pDc[i] > 255) {
                this.pDc[i] = 255;
            }
            if (this.pDd[i] && this.pDc[i] < 255) {
                z = false;
            }
            if (!this.pDd[i] && this.pDc[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.pDa) {
            case 0:
                System.arraycopy(this.pDc, 0, this.pDb, 0, this.pCO.length);
                this.mStartTimeMs = eux();
                if (pDf && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bH = bH(r0);
                this.pDa = bH ? 2 : 1;
                z = bH;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bH2 = bH(pDf ? ((float) (eux() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.pDa = bH2 ? 2 : 1;
                z = bH2;
                break;
        }
        for (int i = 0; i < this.pCO.length; i++) {
            a(canvas, this.pCO[i], (this.pDc[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.pDe++;
            drawable.mutate().setAlpha(i);
            this.pDe--;
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

    protected long eux() {
        return SystemClock.uptimeMillis();
    }
}
