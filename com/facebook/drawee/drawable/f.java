package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class f extends a {
    private static boolean noB = true;
    int mAlpha;
    long mStartTimeMs;
    int noA;
    private final Drawable[] noh;
    int nou;
    int nov;
    int[] nox;
    int[] noy;
    boolean[] noz;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.noh = drawableArr;
        this.nox = new int[drawableArr.length];
        this.noy = new int[drawableArr.length];
        this.mAlpha = 255;
        this.noz = new boolean[drawableArr.length];
        this.noA = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.noA == 0) {
            super.invalidateSelf();
        }
    }

    public void dQk() {
        this.noA++;
    }

    public void dQl() {
        this.noA--;
        invalidateSelf();
    }

    public void Lh(int i) {
        this.nov = i;
        if (this.nou == 1) {
            this.nou = 0;
        }
    }

    private void resetInternal() {
        this.nou = 2;
        Arrays.fill(this.nox, 0);
        this.nox[0] = 255;
        Arrays.fill(this.noy, 0);
        this.noy[0] = 255;
        Arrays.fill(this.noz, false);
        this.noz[0] = true;
    }

    public void Li(int i) {
        this.nou = 0;
        this.noz[i] = true;
        invalidateSelf();
    }

    public void Lj(int i) {
        this.nou = 0;
        this.noz[i] = false;
        invalidateSelf();
    }

    public void dQm() {
        this.nou = 0;
        Arrays.fill(this.noz, true);
        invalidateSelf();
    }

    public void dQn() {
        this.nou = 2;
        for (int i = 0; i < this.noh.length; i++) {
            this.noy[i] = this.noz[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean aL(float f) {
        boolean z = true;
        for (int i = 0; i < this.noh.length; i++) {
            this.noy[i] = (int) (((this.noz[i] ? 1 : -1) * 255 * f) + this.nox[i]);
            if (this.noy[i] < 0) {
                this.noy[i] = 0;
            }
            if (this.noy[i] > 255) {
                this.noy[i] = 255;
            }
            if (this.noz[i] && this.noy[i] < 255) {
                z = false;
            }
            if (!this.noz[i] && this.noy[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.nou) {
            case 0:
                System.arraycopy(this.noy, 0, this.nox, 0, this.noh.length);
                this.mStartTimeMs = dQo();
                if (noB && this.nov != 0) {
                    r0 = 0.0f;
                }
                boolean aL = aL(r0);
                this.nou = aL ? 2 : 1;
                z = aL;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.nov > 0);
                boolean aL2 = aL(noB ? ((float) (dQo() - this.mStartTimeMs)) / this.nov : 1.0f);
                this.nou = aL2 ? 2 : 1;
                z = aL2;
                break;
        }
        for (int i = 0; i < this.noh.length; i++) {
            a(canvas, this.noh[i], (this.noy[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.noA++;
            drawable.mutate().setAlpha(i);
            this.noA--;
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

    protected long dQo() {
        return SystemClock.uptimeMillis();
    }
}
