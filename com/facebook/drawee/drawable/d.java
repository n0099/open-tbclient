package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean jCq = false;
    private ColorFilter mColorFilter = null;
    private int jCr = -1;
    private int jCs = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.jCq = true;
    }

    public void setDither(boolean z) {
        this.jCr = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.jCs = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void j(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.jCq) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.jCr != -1) {
                drawable.setDither(this.jCr != 0);
            }
            if (this.jCs != -1) {
                drawable.setFilterBitmap(this.jCs != 0);
            }
        }
    }
}
