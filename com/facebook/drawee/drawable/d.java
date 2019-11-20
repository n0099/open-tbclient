package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean kdj = false;
    private ColorFilter mColorFilter = null;
    private int kdk = -1;
    private int kdl = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.kdj = true;
    }

    public void setDither(boolean z) {
        this.kdk = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.kdl = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void h(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.kdj) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.kdk != -1) {
                drawable.setDither(this.kdk != 0);
            }
            if (this.kdl != -1) {
                drawable.setFilterBitmap(this.kdl != 0);
            }
        }
    }
}
