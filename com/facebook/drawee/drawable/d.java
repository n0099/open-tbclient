package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean kea = false;
    private ColorFilter mColorFilter = null;
    private int keb = -1;
    private int kec = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.kea = true;
    }

    public void setDither(boolean z) {
        this.keb = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.kec = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void g(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.kea) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.keb != -1) {
                drawable.setDither(this.keb != 0);
            }
            if (this.kec != -1) {
                drawable.setFilterBitmap(this.kec != 0);
            }
        }
    }
}
