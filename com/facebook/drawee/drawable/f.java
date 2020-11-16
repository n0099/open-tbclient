package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes14.dex */
public class f extends a {
    private static boolean oQA = true;
    int mAlpha;
    long mStartTimeMs;
    private final Drawable[] oQi;
    int oQu;
    int oQv;
    int[] oQw;
    int[] oQx;
    boolean[] oQy;
    int oQz;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.oQi = drawableArr;
        this.oQw = new int[drawableArr.length];
        this.oQx = new int[drawableArr.length];
        this.mAlpha = 255;
        this.oQy = new boolean[drawableArr.length];
        this.oQz = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.oQz == 0) {
            super.invalidateSelf();
        }
    }

    public void elN() {
        this.oQz++;
    }

    public void elO() {
        this.oQz--;
        invalidateSelf();
    }

    public void Ph(int i) {
        this.oQv = i;
        if (this.oQu == 1) {
            this.oQu = 0;
        }
    }

    private void resetInternal() {
        this.oQu = 2;
        Arrays.fill(this.oQw, 0);
        this.oQw[0] = 255;
        Arrays.fill(this.oQx, 0);
        this.oQx[0] = 255;
        Arrays.fill(this.oQy, false);
        this.oQy[0] = true;
    }

    public void Pi(int i) {
        this.oQu = 0;
        this.oQy[i] = true;
        invalidateSelf();
    }

    public void Pj(int i) {
        this.oQu = 0;
        this.oQy[i] = false;
        invalidateSelf();
    }

    public void elP() {
        this.oQu = 0;
        Arrays.fill(this.oQy, true);
        invalidateSelf();
    }

    public void elQ() {
        this.oQu = 2;
        for (int i = 0; i < this.oQi.length; i++) {
            this.oQx[i] = this.oQy[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean br(float f) {
        boolean z = true;
        for (int i = 0; i < this.oQi.length; i++) {
            this.oQx[i] = (int) (((this.oQy[i] ? 1 : -1) * 255 * f) + this.oQw[i]);
            if (this.oQx[i] < 0) {
                this.oQx[i] = 0;
            }
            if (this.oQx[i] > 255) {
                this.oQx[i] = 255;
            }
            if (this.oQy[i] && this.oQx[i] < 255) {
                z = false;
            }
            if (!this.oQy[i] && this.oQx[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.oQu) {
            case 0:
                System.arraycopy(this.oQx, 0, this.oQw, 0, this.oQi.length);
                this.mStartTimeMs = elR();
                if (oQA && this.oQv != 0) {
                    r0 = 0.0f;
                }
                boolean br = br(r0);
                this.oQu = br ? 2 : 1;
                z = br;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.oQv > 0);
                boolean br2 = br(oQA ? ((float) (elR() - this.mStartTimeMs)) / this.oQv : 1.0f);
                this.oQu = br2 ? 2 : 1;
                z = br2;
                break;
        }
        for (int i = 0; i < this.oQi.length; i++) {
            a(canvas, this.oQi[i], (this.oQx[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.oQz++;
            drawable.mutate().setAlpha(i);
            this.oQz--;
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

    protected long elR() {
        return SystemClock.uptimeMillis();
    }
}
