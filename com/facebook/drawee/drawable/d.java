package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean iiR = false;
    private ColorFilter mColorFilter = null;
    private int iiS = -1;
    private int iiT = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.iiR = true;
    }

    public void setDither(boolean z) {
        this.iiS = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.iiT = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.iiR) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.iiS != -1) {
                drawable.setDither(this.iiS != 0);
            }
            if (this.iiT != -1) {
                drawable.setFilterBitmap(this.iiT != 0);
            }
        }
    }
}
