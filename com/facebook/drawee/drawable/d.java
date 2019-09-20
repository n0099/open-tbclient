package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean kfS = false;
    private ColorFilter mColorFilter = null;
    private int kfT = -1;
    private int kfU = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.kfS = true;
    }

    public void setDither(boolean z) {
        this.kfT = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.kfU = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.kfS) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.kfT != -1) {
                drawable.setDither(this.kfT != 0);
            }
            if (this.kfU != -1) {
                drawable.setFilterBitmap(this.kfU != 0);
            }
        }
    }
}
