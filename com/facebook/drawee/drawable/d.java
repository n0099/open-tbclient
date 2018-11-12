package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean ibE = false;
    private ColorFilter mColorFilter = null;
    private int ibF = -1;
    private int ibG = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.ibE = true;
    }

    public void setDither(boolean z) {
        this.ibF = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.ibG = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.ibE) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.ibF != -1) {
                drawable.setDither(this.ibF != 0);
            }
            if (this.ibG != -1) {
                drawable.setFilterBitmap(this.ibG != 0);
            }
        }
    }
}
