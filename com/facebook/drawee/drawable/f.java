package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Arrays;
/* loaded from: classes15.dex */
public class f extends a {
    private static boolean oFD = true;
    int mAlpha;
    long mStartTimeMs;
    int[] oFA;
    boolean[] oFB;
    int oFC;
    private final Drawable[] oFl;
    int oFx;
    int oFy;
    int[] oFz;

    public f(Drawable[] drawableArr) {
        super(drawableArr);
        com.facebook.common.internal.g.d(drawableArr.length >= 1, "At least one layer required!");
        this.oFl = drawableArr;
        this.oFz = new int[drawableArr.length];
        this.oFA = new int[drawableArr.length];
        this.mAlpha = 255;
        this.oFB = new boolean[drawableArr.length];
        this.oFC = 0;
        resetInternal();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.oFC == 0) {
            super.invalidateSelf();
        }
    }

    public void eia() {
        this.oFC++;
    }

    public void eib() {
        this.oFC--;
        invalidateSelf();
    }

    public void Oj(int i) {
        this.oFy = i;
        if (this.oFx == 1) {
            this.oFx = 0;
        }
    }

    private void resetInternal() {
        this.oFx = 2;
        Arrays.fill(this.oFz, 0);
        this.oFz[0] = 255;
        Arrays.fill(this.oFA, 0);
        this.oFA[0] = 255;
        Arrays.fill(this.oFB, false);
        this.oFB[0] = true;
    }

    public void Ok(int i) {
        this.oFx = 0;
        this.oFB[i] = true;
        invalidateSelf();
    }

    public void Ol(int i) {
        this.oFx = 0;
        this.oFB[i] = false;
        invalidateSelf();
    }

    public void eic() {
        this.oFx = 0;
        Arrays.fill(this.oFB, true);
        invalidateSelf();
    }

    public void eid() {
        this.oFx = 2;
        for (int i = 0; i < this.oFl.length; i++) {
            this.oFA[i] = this.oFB[i] ? 255 : 0;
        }
        invalidateSelf();
    }

    private boolean bi(float f) {
        boolean z = true;
        for (int i = 0; i < this.oFl.length; i++) {
            this.oFA[i] = (int) (((this.oFB[i] ? 1 : -1) * 255 * f) + this.oFz[i]);
            if (this.oFA[i] < 0) {
                this.oFA[i] = 0;
            }
            if (this.oFA[i] > 255) {
                this.oFA[i] = 255;
            }
            if (this.oFB[i] && this.oFA[i] < 255) {
                z = false;
            }
            if (!this.oFB[i] && this.oFA[i] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // com.facebook.drawee.drawable.a, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z = true;
        switch (this.oFx) {
            case 0:
                System.arraycopy(this.oFA, 0, this.oFz, 0, this.oFl.length);
                this.mStartTimeMs = eie();
                if (oFD && this.oFy != 0) {
                    r0 = 0.0f;
                }
                boolean bi = bi(r0);
                this.oFx = bi ? 2 : 1;
                z = bi;
                break;
            case 1:
                com.facebook.common.internal.g.checkState(this.oFy > 0);
                boolean bi2 = bi(oFD ? ((float) (eie() - this.mStartTimeMs)) / this.oFy : 1.0f);
                this.oFx = bi2 ? 2 : 1;
                z = bi2;
                break;
        }
        for (int i = 0; i < this.oFl.length; i++) {
            a(canvas, this.oFl[i], (this.oFA[i] * this.mAlpha) / 255);
        }
        if (!z) {
            invalidateSelf();
        }
    }

    private void a(Canvas canvas, Drawable drawable, int i) {
        if (drawable != null && i > 0) {
            this.oFC++;
            drawable.mutate().setAlpha(i);
            this.oFC--;
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

    protected long eie() {
        return SystemClock.uptimeMillis();
    }
}
