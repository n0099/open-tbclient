package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes13.dex */
public class f extends a {
    private static boolean mqy = true;
    int mAlpha;
    long mStartTimeMs;
    private final Drawable[] mqg;
    int mqs;
    int mqt;
    int[] mqu;
    int[] mqv;
    boolean[] mqw;
    int mqx;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.mqg = drawableArr;
        this.mqu = new int[drawableArr.length];
        this.mqv = new int[drawableArr.length];
        this.mAlpha = 255;
        this.mqw = new boolean[drawableArr.length];
        this.mqx = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.mqx == 0) {
            super.invalidateSelf();
        }
    }

    public void dwq() {
        this.mqx++;
    }

    public void dwr() {
        this.mqx--;
        invalidateSelf();
    }

    public void Hb(int i) {
        this.mqt = i;
        if (this.mqs == 1) {
            this.mqs = 0;
        }
    }

    private void resetInternal() {
        this.mqs = 2;
        Arrays.fill(this.mqu, 0);
        this.mqu[0] = 255;
        Arrays.fill(this.mqv, 0);
        this.mqv[0] = 255;
        Arrays.fill(this.mqw, false);
        this.mqw[0] = true;
    }

    public void Hc(int i) {
        this.mqs = 0;
        this.mqw[i] = true;
        invalidateSelf();
    }

    public void Hd(int i) {
        this.mqs = 0;
        this.mqw[i] = false;
        invalidateSelf();
    }

    public void dws() {
        this.mqs = 0;
        Arrays.fill(this.mqw, true);
        invalidateSelf();
    }

    public void dwt() {
        this.mqs = 2;
        for (int i = 0; i < this.mqg.length; i++) {
            this.mqv[i] = this.mqw[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aA(float f) {
        boolean z = true;
        for (int i = 0; i < this.mqg.length; i++) {
            this.mqv[i] = (int) (((this.mqw[i] ? 1 : -1) * 255 * f) + this.mqu[i]);
            if (this.mqv[i] < 0) {
                this.mqv[i] = 0;
            }
            if (this.mqv[i] > 255) {
                this.mqv[i] = 255;
            }
            if (this.mqw[i] && this.mqv[i] < 255) {
                z = false;
            }
            if (!this.mqw[i] && this.mqv[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.mqs) {
            case 0:
                System.arraycopy(this.mqv, 0, this.mqu, 0, this.mqg.length);
                this.mStartTimeMs = dwu();
                if (mqy && this.mqt != 0) {
                    r0 = 0.0f;
                }
                boolean aA = aA(r0);
                this.mqs = aA ? 2 : 1;
                z = aA;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mqt > 0);
                boolean aA2 = aA(mqy ? ((float) (dwu() - this.mStartTimeMs)) / this.mqt : 1.0f);
                this.mqs = aA2 ? 2 : 1;
                z = aA2;
                break;
        }
        for (int i = 0; i < this.mqg.length; i++) {
            a(canvas, this.mqg[i], (this.mqv[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.mqx++;
            drawable.mutate().setAlpha(i);
            this.mqx--;
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

    protected long dwu() {
        return SystemClock.uptimeMillis();
    }
}
