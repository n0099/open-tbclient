package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean hZT = false;
    private ColorFilter mColorFilter = null;
    private int hZU = -1;
    private int hZV = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.hZT = true;
    }

    public void setDither(boolean z) {
        this.hZU = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.hZV = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.hZT) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.hZU != -1) {
                drawable.setDither(this.hZU != 0);
            }
            if (this.hZV != -1) {
                drawable.setFilterBitmap(this.hZV != 0);
            }
        }
    }
}
