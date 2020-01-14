package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes12.dex */
public class f extends a {
    private static boolean lLw = true;
    long aGp;
    private final Drawable[] lLf;
    int lLr;
    int[] lLs;
    int[] lLt;
    boolean[] lLu;
    int lLv;
    int mAlpha;
    int mDurationMs;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.lLf = drawableArr;
        this.lLs = new int[drawableArr.length];
        this.lLt = new int[drawableArr.length];
        this.mAlpha = 255;
        this.lLu = new boolean[drawableArr.length];
        this.lLv = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.lLv == 0) {
            super.invalidateSelf();
        }
    }

    public void dlf() {
        this.lLv++;
    }

    public void dlg() {
        this.lLv--;
        invalidateSelf();
    }

    public void HB(int i) {
        this.mDurationMs = i;
        if (this.lLr == 1) {
            this.lLr = 0;
        }
    }

    private void resetInternal() {
        this.lLr = 2;
        Arrays.fill(this.lLs, 0);
        this.lLs[0] = 255;
        Arrays.fill(this.lLt, 0);
        this.lLt[0] = 255;
        Arrays.fill(this.lLu, false);
        this.lLu[0] = true;
    }

    public void HC(int i) {
        this.lLr = 0;
        this.lLu[i] = true;
        invalidateSelf();
    }

    public void HD(int i) {
        this.lLr = 0;
        this.lLu[i] = false;
        invalidateSelf();
    }

    public void dlh() {
        this.lLr = 0;
        Arrays.fill(this.lLu, true);
        invalidateSelf();
    }

    public void dli() {
        this.lLr = 2;
        for (int i = 0; i < this.lLf.length; i++) {
            this.lLt[i] = this.lLu[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bm(float f) {
        boolean z = true;
        for (int i = 0; i < this.lLf.length; i++) {
            this.lLt[i] = (int) (((this.lLu[i] ? 1 : -1) * 255 * f) + this.lLs[i]);
            if (this.lLt[i] < 0) {
                this.lLt[i] = 0;
            }
            if (this.lLt[i] > 255) {
                this.lLt[i] = 255;
            }
            if (this.lLu[i] && this.lLt[i] < 255) {
                z = false;
            }
            if (!this.lLu[i] && this.lLt[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.lLr) {
            case 0:
                System.arraycopy(this.lLt, 0, this.lLs, 0, this.lLf.length);
                this.aGp = dlj();
                if (lLw && this.mDurationMs != 0) {
                    r0 = 0.0f;
                }
                boolean bm = bm(r0);
                this.lLr = bm ? 2 : 1;
                z = bm;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.mDurationMs > 0);
                boolean bm2 = bm(lLw ? ((float) (dlj() - this.aGp)) / this.mDurationMs : 1.0f);
                this.lLr = bm2 ? 2 : 1;
                z = bm2;
                break;
        }
        for (int i = 0; i < this.lLf.length; i++) {
            a(canvas, this.lLf[i], (this.lLt[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.lLv++;
            drawable.mutate().setAlpha(i);
            this.lLv--;
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

    protected long dlj() {
        return SystemClock.uptimeMillis();
    }
}
