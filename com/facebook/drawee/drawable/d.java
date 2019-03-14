package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean jCW = false;
    private ColorFilter mColorFilter = null;
    private int jCX = -1;
    private int jCY = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.jCW = true;
    }

    public void setDither(boolean z) {
        this.jCX = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.jCY = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void j(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.jCW) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.jCX != -1) {
                drawable.setDither(this.jCX != 0);
            }
            if (this.jCY != -1) {
                drawable.setFilterBitmap(this.jCY != 0);
            }
        }
    }
}
