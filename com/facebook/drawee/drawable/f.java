package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean lVr = true;
    private final Drawable[] lUZ;
    int lVl;
    int lVm;
    int[] lVn;
    int[] lVo;
    boolean[] lVp;
    int lVq;
    int mAlpha;
    long mStartTimeMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.lUZ = drawableArr;
        this.lVn = new int[drawableArr.length];
        this.lVo = new int[drawableArr.length];
        this.mAlpha = 255;
        this.lVp = new boolean[drawableArr.length];
        this.lVq = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.lVq == 0) {
            super.invalidateSelf();
        }
    }

    public void doM() {
        this.lVq++;
    }

    public void doN() {
        this.lVq--;
        invalidateSelf();
    }

    public void Gn(int i) {
        this.lVm = i;
        if (this.lVl == 1) {
            this.lVl = 0;
        }
    }

    private void resetInternal() {
        this.lVl = 2;
        Arrays.fill(this.lVn, 0);
        this.lVn[0] = 255;
        Arrays.fill(this.lVo, 0);
        this.lVo[0] = 255;
        Arrays.fill(this.lVp, false);
        this.lVp[0] = true;
    }

    public void Go(int i) {
        this.lVl = 0;
        this.lVp[i] = true;
        invalidateSelf();
    }

    public void Gp(int i) {
        this.lVl = 0;
        this.lVp[i] = false;
        invalidateSelf();
    }

    public void doO() {
        this.lVl = 0;
        Arrays.fill(this.lVp, true);
        invalidateSelf();
    }

    public void doP() {
        this.lVl = 2;
        for (int i = 0; i < this.lUZ.length; i++) {
            this.lVo[i] = this.lVp[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aB(float f) {
        boolean z = true;
        for (int i = 0; i < this.lUZ.length; i++) {
            this.lVo[i] = (int) (((this.lVp[i] ? 1 : -1) * 255 * f) + this.lVn[i]);
            if (this.lVo[i] < 0) {
                this.lVo[i] = 0;
            }
            if (this.lVo[i] > 255) {
                this.lVo[i] = 255;
            }
            if (this.lVp[i] && this.lVo[i] < 255) {
                z = false;
            }
            if (!this.lVp[i] && this.lVo[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.lVl) {
            case 0:
                System.arraycopy(this.lVo, 0, this.lVn, 0, this.lUZ.length);
                this.mStartTimeMs = doQ();
                if (lVr && this.lVm != 0) {
                    r0 = 0.0f;
                }
                boolean aB = aB(r0);
                this.lVl = aB ? 2 : 1;
                z = aB;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.lVm > 0);
                boolean aB2 = aB(lVr ? ((float) (doQ() - this.mStartTimeMs)) / this.lVm : 1.0f);
                this.lVl = aB2 ? 2 : 1;
                z = aB2;
                break;
        }
        for (int i = 0; i < this.lUZ.length; i++) {
            a(canvas, this.lUZ[i], (this.lVo[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.lVq++;
            drawable.mutate().setAlpha(i);
            this.lVq--;
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

    protected long doQ() {
        return SystemClock.uptimeMillis();
    }
}
