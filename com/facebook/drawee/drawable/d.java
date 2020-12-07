package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes8.dex */
public class d {
    private int mAlpha = -1;
    private boolean pfz = false;
    private ColorFilter mColorFilter = null;
    private int pfA = -1;
    private int pfB = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.pfz = true;
    }

    public void setDither(boolean z) {
        this.pfA = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.pfB = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void q(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.pfz) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.pfA != -1) {
                drawable.setDither(this.pfA != 0);
            }
            if (this.pfB != -1) {
                drawable.setFilterBitmap(this.pfB != 0);
            }
        }
    }
}
