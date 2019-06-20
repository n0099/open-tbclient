package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean jVk = false;
    private ColorFilter mColorFilter = null;
    private int jVl = -1;
    private int jVm = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.jVk = true;
    }

    public void setDither(boolean z) {
        this.jVl = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.jVm = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.jVk) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.jVl != -1) {
                drawable.setDither(this.jVl != 0);
            }
            if (this.jVm != -1) {
                drawable.setFilterBitmap(this.jVm != 0);
            }
        }
    }
}
