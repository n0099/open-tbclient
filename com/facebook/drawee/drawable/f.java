package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean lMq = true;
    private final Drawable[] lLZ;
    int lMl;
    int[] lMm;
    int[] lMn;
    boolean[] lMo;
    int lMp;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.lLZ = drawableArr;
        this.lMm = new int[drawableArr.length];
        this.lMn = new int[drawableArr.length];
        this.mAlpha = 255;
        this.lMo = new boolean[drawableArr.length];
        this.lMp = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.lMp == 0) {
            super.invalidateSelf();
        }
    }

    public void dmv() {
        this.lMp++;
    }

    public void dmw() {
        this.lMp--;
        invalidateSelf();
    }

    public void HG(int i) {
        this.mDurationMs = i;
        if (this.lMl == 1) {
            this.lMl = 0;
        }
    }

    private void resetInternal() {
        this.lMl = 2;
        Arrays.fill(this.lMm, 0);
        this.lMm[0] = 255;
        Arrays.fill(this.lMn, 0);
        this.lMn[0] = 255;
        Arrays.fill(this.lMo, false);
        this.lMo[0] = true;
    }

    public void HH(int i) {
        this.lMl = 0;
        this.lMo[i] = true;
        invalidateSelf();
    }

    public void HI(int i) {
        this.lMl = 0;
        this.lMo[i] = false;
        invalidateSelf();
    }

    public void dmx() {
        this.lMl = 0;
        Arrays.fill(this.lMo, true);
        invalidateSelf();
    }

    public void dmy() {
        this.lMl = 2;
        for (int i = 0; i < this.lLZ.length; i++) {
            this.lMn[i] = this.lMo[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bl(float f) {
        boolean z = true;
        for (int i = 0; i < this.lLZ.length; i++) {
            this.lMn[i] = (int) (((this.lMo[i] ? 1 : -1) * 255 * f) + this.lMm[i]);
            if (this.lMn[i] < 0) {
                this.lMn[i] = 0;
            }
            if (this.lMn[i] > 255) {
                this.lMn[i] = 255;
            }
            if (this.lMo[i] && this.lMn[i] < 255) {
                z = false;
            }
            if (!this.lMo[i] && this.lMn[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.lMl) {
            case 0:
                System.arraycopy(this.lMn, 0, this.lMm, 0, this.lLZ.length);
                this.mStartTimeMs = dmz();
                if (lMq && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bl = bl(r0);
                this.lMl = bl ? 2 : 1;
                z = bl;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bl2 = bl(lMq ? ((float) (dmz() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.lMl = bl2 ? 2 : 1;
                z = bl2;
                break;
        }
        for (int i = 0; i < this.lLZ.length; i++) {
            a(canvas, this.lLZ[i], (this.lMn[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.lMp++;
            drawable.mutate().setAlpha(i);
            this.lMp--;
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

    protected long dmz() {
        return SystemClock.uptimeMillis();
    }
}
