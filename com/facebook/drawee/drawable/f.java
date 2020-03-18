package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean lNW = true;
    private final Drawable[] lNF;
    int lNR;
    int[] lNS;
    int[] lNT;
    boolean[] lNU;
    int lNV;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.lNF = drawableArr;
        this.lNS = new int[drawableArr.length];
        this.lNT = new int[drawableArr.length];
        this.mAlpha = 255;
        this.lNU = new boolean[drawableArr.length];
        this.lNV = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.lNV == 0) {
            super.invalidateSelf();
        }
    }

    public void dmS() {
        this.lNV++;
    }

    public void dmT() {
        this.lNV--;
        invalidateSelf();
    }

    public void HM(int i) {
        this.mDurationMs = i;
        if (this.lNR == 1) {
            this.lNR = 0;
        }
    }

    private void resetInternal() {
        this.lNR = 2;
        Arrays.fill(this.lNS, 0);
        this.lNS[0] = 255;
        Arrays.fill(this.lNT, 0);
        this.lNT[0] = 255;
        Arrays.fill(this.lNU, false);
        this.lNU[0] = true;
    }

    public void HN(int i) {
        this.lNR = 0;
        this.lNU[i] = true;
        invalidateSelf();
    }

    public void HO(int i) {
        this.lNR = 0;
        this.lNU[i] = false;
        invalidateSelf();
    }

    public void dmU() {
        this.lNR = 0;
        Arrays.fill(this.lNU, true);
        invalidateSelf();
    }

    public void dmV() {
        this.lNR = 2;
        for (int i = 0; i < this.lNF.length; i++) {
            this.lNT[i] = this.lNU[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bl(float f) {
        boolean z = true;
        for (int i = 0; i < this.lNF.length; i++) {
            this.lNT[i] = (int) (((this.lNU[i] ? 1 : -1) * 255 * f) + this.lNS[i]);
            if (this.lNT[i] < 0) {
                this.lNT[i] = 0;
            }
            if (this.lNT[i] > 255) {
                this.lNT[i] = 255;
            }
            if (this.lNU[i] && this.lNT[i] < 255) {
                z = false;
            }
            if (!this.lNU[i] && this.lNT[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.lNR) {
            case 0:
                System.arraycopy(this.lNT, 0, this.lNS, 0, this.lNF.length);
                this.mStartTimeMs = dmW();
                if (lNW && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bl = bl(r0);
                this.lNR = bl ? 2 : 1;
                z = bl;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bl2 = bl(lNW ? ((float) (dmW() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.lNR = bl2 ? 2 : 1;
                z = bl2;
                break;
        }
        for (int i = 0; i < this.lNF.length; i++) {
            a(canvas, this.lNF[i], (this.lNT[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.lNV++;
            drawable.mutate().setAlpha(i);
            this.lNV--;
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

    protected long dmW() {
        return SystemClock.uptimeMillis();
    }
}
