package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class f extends a {
    private static boolean pwQ = true;
    int mAlpha;
    int mDurationMs;
    long mStartTimeMs;
    int pwL;
    int[] pwM;
    int[] pwN;
    boolean[] pwO;
    int pwP;
    private final Drawable[] pwz;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.checkState(drawableArr.length >= 1, "At least one layer required!");
        this.pwz = drawableArr;
        this.pwM = new int[drawableArr.length];
        this.pwN = new int[drawableArr.length];
        this.mAlpha = 255;
        this.pwO = new boolean[drawableArr.length];
        this.pwP = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.pwP == 0) {
            super.invalidateSelf();
        }
    }

    public void evF() {
        this.pwP++;
    }

    public void evG() {
        this.pwP--;
        invalidateSelf();
    }

    public void Qo(int i) {
        this.mDurationMs = i;
        if (this.pwL == 1) {
            this.pwL = 0;
        }
    }

    private void resetInternal() {
        this.pwL = 2;
        Arrays.fill(this.pwM, 0);
        this.pwM[0] = 255;
        Arrays.fill(this.pwN, 0);
        this.pwN[0] = 255;
        Arrays.fill(this.pwO, false);
        this.pwO[0] = true;
    }

    public void Qp(int i) {
        this.pwL = 0;
        this.pwO[i] = true;
        invalidateSelf();
    }

    public void Qq(int i) {
        this.pwL = 0;
        this.pwO[i] = false;
        invalidateSelf();
    }

    public void evH() {
        this.pwL = 0;
        Arrays.fill(this.pwO, true);
        invalidateSelf();
    }

    public void evI() {
        this.pwL = 2;
        for (int i = 0; i < this.pwz.length; i++) {
            this.pwN[i] = this.pwO[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bE(float f) {
        boolean z = true;
        for (int i = 0; i < this.pwz.length; i++) {
            this.pwN[i] = (int) (((this.pwO[i] ? 1 : -1) * 255 * f) + this.pwM[i]);
            if (this.pwN[i] < 0) {
                this.pwN[i] = 0;
            }
            if (this.pwN[i] > 255) {
                this.pwN[i] = 255;
            }
            if (this.pwO[i] && this.pwN[i] < 255) {
                z = false;
            }
            if (!this.pwO[i] && this.pwN[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.pwL) {
            case 0:
                System.arraycopy(this.pwN, 0, this.pwM, 0, this.pwz.length);
                this.mStartTimeMs = evJ();
                if (pwQ && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bE = bE(r0);
                this.pwL = bE ? 2 : 1;
                z = bE;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bE2 = bE(pwQ ? ((float) (evJ() - this.mStartTimeMs)) / this.mDurationMs : 1.0f);
                this.pwL = bE2 ? 2 : 1;
                z = bE2;
                break;
        }
        for (int i = 0; i < this.pwz.length; i++) {
            a(canvas, this.pwz[i], (this.pwN[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.pwP++;
            drawable.mutate().setAlpha(i);
            this.pwP--;
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

    protected long evJ() {
        return SystemClock.uptimeMillis();
    }
}
