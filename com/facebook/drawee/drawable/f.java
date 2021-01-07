package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class f extends a {
    private static boolean pwX = true;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;
    private final Drawable[] pwG;
    int pwS;
    int[] pwT;
    int[] pwU;
    boolean[] pwV;
    int pwW;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.pwG = drawableArr;
        this.pwT = new int[drawableArr.length];
        this.pwU = new int[drawableArr.length];
        this.mAlpha = 255;
        this.pwV = new boolean[drawableArr.length];
        this.pwW = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.pwW == 0) {
            super.invalidateSelf();
        }
    }

    public void evM() {
        this.pwW++;
    }

    public void evN() {
        this.pwW--;
        invalidateSelf();
    }

    public void Qt(int i) {
        this.mDurationMs = i;
        if (this.pwS == 1) {
            this.pwS = 0;
        }
    }

    private void resetInternal() {
        this.pwS = 2;
        Arrays.fill(this.pwT, 0);
        this.pwT[0] = 255;
        Arrays.fill(this.pwU, 0);
        this.pwU[0] = 255;
        Arrays.fill(this.pwV, false);
        this.pwV[0] = true;
    }

    public void Qu(int i) {
        this.pwS = 0;
        this.pwV[i] = true;
        invalidateSelf();
    }

    public void Qv(int i) {
        this.pwS = 0;
        this.pwV[i] = false;
        invalidateSelf();
    }

    public void evO() {
        this.pwS = 0;
        Arrays.fill(this.pwV, true);
        invalidateSelf();
    }

    public void evP() {
        this.pwS = 2;
        for (int i = 0; i < this.pwG.length; i++) {
            this.pwU[i] = this.pwV[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bE(float f) {
        boolean z = true;
        for (int i = 0; i < this.pwG.length; i++) {
            this.pwU[i] = (int) (((this.pwV[i] ? 1 : -1) * 255 * f) + this.pwT[i]);
            if (this.pwU[i] < 0) {
                this.pwU[i] = 0;
            }
            if (this.pwU[i] > 255) {
                this.pwU[i] = 255;
            }
            if (this.pwV[i] && this.pwU[i] < 255) {
                z = false;
            }
            if (!this.pwV[i] && this.pwU[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.pwS) {
            case 0:
                System.arraycopy(this.pwU, 0, this.pwT, 0, this.pwG.length);
                this.mStartTimeMs = evQ();
                if (pwX && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bE = bE(r0);
                this.pwS = bE ? 2 : 1;
                z = bE;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bE2 = bE(pwX ? ((float) (evQ() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.pwS = bE2 ? 2 : 1;
                z = bE2;
                break;
        }
        for (int i = 0; i < this.pwG.length; i++) {
            a(canvas, this.pwG[i], (this.pwU[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.pwW++;
            drawable.mutate().setAlpha(i);
            this.pwW--;
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

    protected long evQ() {
        return SystemClock.uptimeMillis();
    }
}
