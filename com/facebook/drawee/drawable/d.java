package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean kco = false;
    private ColorFilter mColorFilter = null;
    private int kcp = -1;
    private int kcq = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.kco = true;
    }

    public void setDither(boolean z) {
        this.kcp = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.kcq = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.kco) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.kcp != -1) {
                drawable.setDither(this.kcp != 0);
            }
            if (this.kcq != -1) {
                drawable.setFilterBitmap(this.kcq != 0);
            }
        }
    }
}
