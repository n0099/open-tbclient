package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean jCL = false;
    private ColorFilter mColorFilter = null;
    private int jCM = -1;
    private int jCN = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.jCL = true;
    }

    public void setDither(boolean z) {
        this.jCM = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.jCN = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void j(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.jCL) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.jCM != -1) {
                drawable.setDither(this.jCM != 0);
            }
            if (this.jCN != -1) {
                drawable.setFilterBitmap(this.jCN != 0);
            }
        }
    }
}
