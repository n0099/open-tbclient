package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean inj = false;
    private ColorFilter mColorFilter = null;
    private int ink = -1;
    private int inl = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.inj = true;
    }

    public void setDither(boolean z) {
        this.ink = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.inl = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.inj) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.ink != -1) {
                drawable.setDither(this.ink != 0);
            }
            if (this.inl != -1) {
                drawable.setFilterBitmap(this.inl != 0);
            }
        }
    }
}
