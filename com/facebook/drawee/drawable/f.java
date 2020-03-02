package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean lMf = true;
    private final Drawable[] lLO;
    int lMa;
    int[] lMb;
    int[] lMc;
    boolean[] lMd;
    int lMe;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.lLO = drawableArr;
        this.lMb = new int[drawableArr.length];
        this.lMc = new int[drawableArr.length];
        this.mAlpha = 255;
        this.lMd = new boolean[drawableArr.length];
        this.lMe = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.lMe == 0) {
            super.invalidateSelf();
        }
    }

    public void dmu() {
        this.lMe++;
    }

    public void dmv() {
        this.lMe--;
        invalidateSelf();
    }

    public void HG(int i) {
        this.mDurationMs = i;
        if (this.lMa == 1) {
            this.lMa = 0;
        }
    }

    private void resetInternal() {
        this.lMa = 2;
        Arrays.fill(this.lMb, 0);
        this.lMb[0] = 255;
        Arrays.fill(this.lMc, 0);
        this.lMc[0] = 255;
        Arrays.fill(this.lMd, false);
        this.lMd[0] = true;
    }

    public void HH(int i) {
        this.lMa = 0;
        this.lMd[i] = true;
        invalidateSelf();
    }

    public void HI(int i) {
        this.lMa = 0;
        this.lMd[i] = false;
        invalidateSelf();
    }

    public void dmw() {
        this.lMa = 0;
        Arrays.fill(this.lMd, true);
        invalidateSelf();
    }

    public void dmx() {
        this.lMa = 2;
        for (int i = 0; i < this.lLO.length; i++) {
            this.lMc[i] = this.lMd[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bl(float f) {
        boolean z = true;
        for (int i = 0; i < this.lLO.length; i++) {
            this.lMc[i] = (int) (((this.lMd[i] ? 1 : -1) * 255 * f) + this.lMb[i]);
            if (this.lMc[i] < 0) {
                this.lMc[i] = 0;
            }
            if (this.lMc[i] > 255) {
                this.lMc[i] = 255;
            }
            if (this.lMd[i] && this.lMc[i] < 255) {
                z = false;
            }
            if (!this.lMd[i] && this.lMc[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.lMa) {
            case 0:
                System.arraycopy(this.lMc, 0, this.lMb, 0, this.lLO.length);
                this.mStartTimeMs = dmy();
                if (lMf && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bl = bl(r0);
                this.lMa = bl ? 2 : 1;
                z = bl;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bl2 = bl(lMf ? ((float) (dmy() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.lMa = bl2 ? 2 : 1;
                z = bl2;
                break;
        }
        for (int i = 0; i < this.lLO.length; i++) {
            a(canvas, this.lLO[i], (this.lMc[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.lMe++;
            drawable.mutate().setAlpha(i);
            this.lMe--;
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

    protected long dmy() {
        return SystemClock.uptimeMillis();
    }
}
