package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class f extends a {
    private final Drawable[] hZL;
    int hZX;
    int hZY;
    long hZZ;
    int[] iaa;
    int[] iab;
    boolean[] iac;
    int iad;
    int mAlpha;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.c(drawableArr.length >= 1, "At least one layer required!");
        this.hZL = drawableArr;
        this.iaa = new int[drawableArr.length];
        this.iab = new int[drawableArr.length];
        this.mAlpha = 255;
        this.iac = new boolean[drawableArr.length];
        this.iad = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.iad == 0) {
            super.invalidateSelf();
        }
    }

    public void bTh() {
        this.iad++;
    }

    public void bTi() {
        this.iad--;
        invalidateSelf();
    }

    public void xm(int i) {
        this.hZY = i;
        if (this.hZX == 1) {
            this.hZX = 0;
        }
    }

    private void resetInternal() {
        this.hZX = 2;
        Arrays.fill(this.iaa, 0);
        this.iaa[0] = 255;
        Arrays.fill(this.iab, 0);
        this.iab[0] = 255;
        Arrays.fill(this.iac, false);
        this.iac[0] = true;
    }

    public void xn(int i) {
        this.hZX = 0;
        this.iac[i] = true;
        invalidateSelf();
    }

    public void xo(int i) {
        this.hZX = 0;
        this.iac[i] = false;
        invalidateSelf();
    }

    public void bTj() {
        this.hZX = 0;
        Arrays.fill(this.iac, true);
        invalidateSelf();
    }

    public void bTk() {
        this.hZX = 2;
        for (int i = 0; i < this.hZL.length; i++) {
            this.iab[i] = this.iac[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aF(float f) {
        boolean z = true;
        for (int i = 0; i < this.hZL.length; i++) {
            this.iab[i] = (int) (((this.iac[i] ? 1 : -1) * 255 * f) + this.iaa[i]);
            if (this.iab[i] < 0) {
                this.iab[i] = 0;
            }
            if (this.iab[i] > 255) {
                this.iab[i] = 255;
            }
            if (this.iac[i] && this.iab[i] < 255) {
                z = false;
            }
            if (!this.iac[i] && this.iab[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.hZX) {
            case 0:
                System.arraycopy(this.iab, 0, this.iaa, 0, this.hZL.length);
                this.hZZ = bTl();
                boolean aF = aF(this.hZY == 0 ? 1.0f : 0.0f);
                this.hZX = aF ? 2 : 1;
                z = aF;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.hZY > 0);
                boolean aF2 = aF(((float) (bTl() - this.hZZ)) / this.hZY);
                this.hZX = aF2 ? 2 : 1;
                z = aF2;
                break;
        }
        for (int i = 0; i < this.hZL.length; i++) {
            a(canvas, this.hZL[i], (this.iab[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.iad++;
            drawable.mutate().setAlpha(i);
            this.iad--;
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

    protected long bTl() {
        return SystemClock.uptimeMillis();
    }
}
