package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes15.dex */
public class d {
    private int mAlpha = -1;
    private boolean nOb = false;
    private ColorFilter mColorFilter = null;
    private int nOc = -1;
    private int nOd = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.nOb = true;
    }

    public void setDither(boolean z) {
        this.nOc = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.nOd = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.nOb) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.nOc != -1) {
                drawable.setDither(this.nOc != 0);
            }
            if (this.nOd != -1) {
                drawable.setFilterBitmap(this.nOd != 0);
            }
        }
    }
}
