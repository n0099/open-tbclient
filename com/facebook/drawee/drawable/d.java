package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean imb = false;
    private ColorFilter mColorFilter = null;
    private int imc = -1;
    private int imd = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.imb = true;
    }

    public void setDither(boolean z) {
        this.imc = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.imd = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void i(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.imb) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.imc != -1) {
                drawable.setDither(this.imc != 0);
            }
            if (this.imd != -1) {
                drawable.setFilterBitmap(this.imd != 0);
            }
        }
    }
}
