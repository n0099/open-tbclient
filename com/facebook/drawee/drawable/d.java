package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean jCr = false;
    private ColorFilter mColorFilter = null;
    private int jCs = -1;
    private int jCt = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.jCr = true;
    }

    public void setDither(boolean z) {
        this.jCs = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.jCt = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void j(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.jCr) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.jCs != -1) {
                drawable.setDither(this.jCs != 0);
            }
            if (this.jCt != -1) {
                drawable.setFilterBitmap(this.jCt != 0);
            }
        }
    }
}
