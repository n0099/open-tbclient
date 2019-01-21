package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean ink = false;
    private ColorFilter mColorFilter = null;
    private int inl = -1;
    private int inm = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.ink = true;
    }

    public void setDither(boolean z) {
        this.inl = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.inm = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.ink) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.inl != -1) {
                drawable.setDither(this.inl != 0);
            }
            if (this.inm != -1) {
                drawable.setFilterBitmap(this.inm != 0);
            }
        }
    }
}
