package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class f extends a {
    private static boolean oOW = true;
    int mAlpha;
    long mStartTimeMs;
    private final Drawable[] oOE;
    int oOQ;
    int oOR;
    int[] oOS;
    int[] oOT;
    boolean[] oOU;
    int oOV;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.oOE = drawableArr;
        this.oOS = new int[drawableArr.length];
        this.oOT = new int[drawableArr.length];
        this.mAlpha = 255;
        this.oOU = new boolean[drawableArr.length];
        this.oOV = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.oOV == 0) {
            super.invalidateSelf();
        }
    }

    public void elP() {
        this.oOV++;
    }

    public void elQ() {
        this.oOV--;
        invalidateSelf();
    }

    public void OE(int i) {
        this.oOR = i;
        if (this.oOQ == 1) {
            this.oOQ = 0;
        }
    }

    private void resetInternal() {
        this.oOQ = 2;
        Arrays.fill(this.oOS, 0);
        this.oOS[0] = 255;
        Arrays.fill(this.oOT, 0);
        this.oOT[0] = 255;
        Arrays.fill(this.oOU, false);
        this.oOU[0] = true;
    }

    public void OF(int i) {
        this.oOQ = 0;
        this.oOU[i] = true;
        invalidateSelf();
    }

    public void OG(int i) {
        this.oOQ = 0;
        this.oOU[i] = false;
        invalidateSelf();
    }

    public void elR() {
        this.oOQ = 0;
        Arrays.fill(this.oOU, true);
        invalidateSelf();
    }

    public void elS() {
        this.oOQ = 2;
        for (int i = 0; i < this.oOE.length; i++) {
            this.oOT[i] = this.oOU[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bk(float f) {
        boolean z = true;
        for (int i = 0; i < this.oOE.length; i++) {
            this.oOT[i] = (int) (((this.oOU[i] ? 1 : -1) * 255 * f) + this.oOS[i]);
            if (this.oOT[i] < 0) {
                this.oOT[i] = 0;
            }
            if (this.oOT[i] > 255) {
                this.oOT[i] = 255;
            }
            if (this.oOU[i] && this.oOT[i] < 255) {
                z = false;
            }
            if (!this.oOU[i] && this.oOT[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.oOQ) {
            case 0:
                System.arraycopy(this.oOT, 0, this.oOS, 0, this.oOE.length);
                this.mStartTimeMs = elT();
                if (oOW && this.oOR != 0) {
                    r0 = 0.0f;
                }
                boolean bk = bk(r0);
                this.oOQ = bk ? 2 : 1;
                z = bk;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.oOR > 0);
                boolean bk2 = bk(oOW ? ((float) (elT() - this.mStartTimeMs)) / this.oOR : 1.0f);
                this.oOQ = bk2 ? 2 : 1;
                z = bk2;
                break;
        }
        for (int i = 0; i < this.oOE.length; i++) {
            a(canvas, this.oOE[i], (this.oOT[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.oOV++;
            drawable.mutate().setAlpha(i);
            this.oOV--;
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

    protected long elT() {
        return SystemClock.uptimeMillis();
    }
}
