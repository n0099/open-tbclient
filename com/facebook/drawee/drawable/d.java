package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean jVh = false;
    private ColorFilter mColorFilter = null;
    private int jVi = -1;
    private int jVj = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.jVh = true;
    }

    public void setDither(boolean z) {
        this.jVi = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.jVj = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.jVh) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.jVi != -1) {
                drawable.setDither(this.jVi != 0);
            }
            if (this.jVj != -1) {
                drawable.setFilterBitmap(this.jVj != 0);
            }
        }
    }
}
