package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean lVv = true;
    private final Drawable[] lVd;
    int lVp;
    int lVq;
    int[] lVr;
    int[] lVs;
    boolean[] lVt;
    int lVu;
    int mAlpha;
    long mStartTimeMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.lVd = drawableArr;
        this.lVr = new int[drawableArr.length];
        this.lVs = new int[drawableArr.length];
        this.mAlpha = 255;
        this.lVt = new boolean[drawableArr.length];
        this.lVu = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.lVu == 0) {
            super.invalidateSelf();
        }
    }

    public void doK() {
        this.lVu++;
    }

    public void doL() {
        this.lVu--;
        invalidateSelf();
    }

    public void Gn(int i) {
        this.lVq = i;
        if (this.lVp == 1) {
            this.lVp = 0;
        }
    }

    private void resetInternal() {
        this.lVp = 2;
        Arrays.fill(this.lVr, 0);
        this.lVr[0] = 255;
        Arrays.fill(this.lVs, 0);
        this.lVs[0] = 255;
        Arrays.fill(this.lVt, false);
        this.lVt[0] = true;
    }

    public void Go(int i) {
        this.lVp = 0;
        this.lVt[i] = true;
        invalidateSelf();
    }

    public void Gp(int i) {
        this.lVp = 0;
        this.lVt[i] = false;
        invalidateSelf();
    }

    public void doM() {
        this.lVp = 0;
        Arrays.fill(this.lVt, true);
        invalidateSelf();
    }

    public void doN() {
        this.lVp = 2;
        for (int i = 0; i < this.lVd.length; i++) {
            this.lVs[i] = this.lVt[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aB(float f) {
        boolean z = true;
        for (int i = 0; i < this.lVd.length; i++) {
            this.lVs[i] = (int) (((this.lVt[i] ? 1 : -1) * 255 * f) + this.lVr[i]);
            if (this.lVs[i] < 0) {
                this.lVs[i] = 0;
            }
            if (this.lVs[i] > 255) {
                this.lVs[i] = 255;
            }
            if (this.lVt[i] && this.lVs[i] < 255) {
                z = false;
            }
            if (!this.lVt[i] && this.lVs[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.lVp) {
            case 0:
                System.arraycopy(this.lVs, 0, this.lVr, 0, this.lVd.length);
                this.mStartTimeMs = doO();
                if (lVv && this.lVq != 0) {
                    r0 = 0.0f;
                }
                boolean aB = aB(r0);
                this.lVp = aB ? 2 : 1;
                z = aB;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.lVq > 0);
                boolean aB2 = aB(lVv ? ((float) (doO() - this.mStartTimeMs)) / this.lVq : 1.0f);
                this.lVp = aB2 ? 2 : 1;
                z = aB2;
                break;
        }
        for (int i = 0; i < this.lVd.length; i++) {
            a(canvas, this.lVd[i], (this.lVs[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.lVu++;
            drawable.mutate().setAlpha(i);
            this.lVu--;
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

    protected long doO() {
        return SystemClock.uptimeMillis();
    }
}
