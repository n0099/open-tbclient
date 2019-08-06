package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean kdu = false;
    private ColorFilter mColorFilter = null;
    private int kdv = -1;
    private int kdw = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.kdu = true;
    }

    public void setDither(boolean z) {
        this.kdv = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.kdw = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.kdu) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.kdv != -1) {
                drawable.setDither(this.kdv != 0);
            }
            if (this.kdw != -1) {
                drawable.setFilterBitmap(this.kdw != 0);
            }
        }
    }
}
