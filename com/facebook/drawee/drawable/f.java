package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean lMd = true;
    private final Drawable[] lLM;
    int lLY;
    int[] lLZ;
    int[] lMa;
    boolean[] lMb;
    int lMc;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.lLM = drawableArr;
        this.lLZ = new int[drawableArr.length];
        this.lMa = new int[drawableArr.length];
        this.mAlpha = 255;
        this.lMb = new boolean[drawableArr.length];
        this.lMc = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.lMc == 0) {
            super.invalidateSelf();
        }
    }

    public void dms() {
        this.lMc++;
    }

    public void dmt() {
        this.lMc--;
        invalidateSelf();
    }

    public void HG(int i) {
        this.mDurationMs = i;
        if (this.lLY == 1) {
            this.lLY = 0;
        }
    }

    private void resetInternal() {
        this.lLY = 2;
        Arrays.fill(this.lLZ, 0);
        this.lLZ[0] = 255;
        Arrays.fill(this.lMa, 0);
        this.lMa[0] = 255;
        Arrays.fill(this.lMb, false);
        this.lMb[0] = true;
    }

    public void HH(int i) {
        this.lLY = 0;
        this.lMb[i] = true;
        invalidateSelf();
    }

    public void HI(int i) {
        this.lLY = 0;
        this.lMb[i] = false;
        invalidateSelf();
    }

    public void dmu() {
        this.lLY = 0;
        Arrays.fill(this.lMb, true);
        invalidateSelf();
    }

    public void dmv() {
        this.lLY = 2;
        for (int i = 0; i < this.lLM.length; i++) {
            this.lMa[i] = this.lMb[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bl(float f) {
        boolean z = true;
        for (int i = 0; i < this.lLM.length; i++) {
            this.lMa[i] = (int) (((this.lMb[i] ? 1 : -1) * 255 * f) + this.lLZ[i]);
            if (this.lMa[i] < 0) {
                this.lMa[i] = 0;
            }
            if (this.lMa[i] > 255) {
                this.lMa[i] = 255;
            }
            if (this.lMb[i] && this.lMa[i] < 255) {
                z = false;
            }
            if (!this.lMb[i] && this.lMa[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.lLY) {
            case 0:
                System.arraycopy(this.lMa, 0, this.lLZ, 0, this.lLM.length);
                this.mStartTimeMs = dmw();
                if (lMd && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bl = bl(r0);
                this.lLY = bl ? 2 : 1;
                z = bl;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bl2 = bl(lMd ? ((float) (dmw() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.lLY = bl2 ? 2 : 1;
                z = bl2;
                break;
        }
        for (int i = 0; i < this.lLM.length; i++) {
            a(canvas, this.lLM[i], (this.lMa[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.lMc++;
            drawable.mutate().setAlpha(i);
            this.lMc--;
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

    protected long dmw() {
        return SystemClock.uptimeMillis();
    }
}
