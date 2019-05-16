package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean jVg = false;
    private ColorFilter mColorFilter = null;
    private int jVh = -1;
    private int jVi = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.jVg = true;
    }

    public void setDither(boolean z) {
        this.jVh = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.jVi = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.jVg) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.jVh != -1) {
                drawable.setDither(this.jVh != 0);
            }
            if (this.jVi != -1) {
                drawable.setFilterBitmap(this.jVi != 0);
            }
        }
    }
}
