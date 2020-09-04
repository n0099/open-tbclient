package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class f extends a {
    private static boolean noT = true;
    int mAlpha;
    long mStartTimeMs;
    private final Drawable[] noB;
    int noN;
    int noO;
    int[] noP;
    int[] noQ;
    boolean[] noR;
    int noS;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.noB = drawableArr;
        this.noP = new int[drawableArr.length];
        this.noQ = new int[drawableArr.length];
        this.mAlpha = 255;
        this.noR = new boolean[drawableArr.length];
        this.noS = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.noS == 0) {
            super.invalidateSelf();
        }
    }

    public void dQt() {
        this.noS++;
    }

    public void dQu() {
        this.noS--;
        invalidateSelf();
    }

    public void Lh(int i) {
        this.noO = i;
        if (this.noN == 1) {
            this.noN = 0;
        }
    }

    private void resetInternal() {
        this.noN = 2;
        Arrays.fill(this.noP, 0);
        this.noP[0] = 255;
        Arrays.fill(this.noQ, 0);
        this.noQ[0] = 255;
        Arrays.fill(this.noR, false);
        this.noR[0] = true;
    }

    public void Li(int i) {
        this.noN = 0;
        this.noR[i] = true;
        invalidateSelf();
    }

    public void Lj(int i) {
        this.noN = 0;
        this.noR[i] = false;
        invalidateSelf();
    }

    public void dQv() {
        this.noN = 0;
        Arrays.fill(this.noR, true);
        invalidateSelf();
    }

    public void dQw() {
        this.noN = 2;
        for (int i = 0; i < this.noB.length; i++) {
            this.noQ[i] = this.noR[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aL(float f) {
        boolean z = true;
        for (int i = 0; i < this.noB.length; i++) {
            this.noQ[i] = (int) (((this.noR[i] ? 1 : -1) * 255 * f) + this.noP[i]);
            if (this.noQ[i] < 0) {
                this.noQ[i] = 0;
            }
            if (this.noQ[i] > 255) {
                this.noQ[i] = 255;
            }
            if (this.noR[i] && this.noQ[i] < 255) {
                z = false;
            }
            if (!this.noR[i] && this.noQ[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.noN) {
            case 0:
                System.arraycopy(this.noQ, 0, this.noP, 0, this.noB.length);
                this.mStartTimeMs = dQx();
                if (noT && this.noO != 0) {
                    r0 = 0.0f;
                }
                boolean aL = aL(r0);
                this.noN = aL ? 2 : 1;
                z = aL;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.noO > 0);
                boolean aL2 = aL(noT ? ((float) (dQx() - this.mStartTimeMs)) / this.noO : 1.0f);
                this.noN = aL2 ? 2 : 1;
                z = aL2;
                break;
        }
        for (int i = 0; i < this.noB.length; i++) {
            a(canvas, this.noB[i], (this.noQ[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.noS++;
            drawable.mutate().setAlpha(i);
            this.noS--;
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

    protected long dQx() {
        return SystemClock.uptimeMillis();
    }
}
