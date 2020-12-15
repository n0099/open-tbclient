package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes8.dex */
public class d {
    private int mAlpha = -1;
    private boolean pfB = false;
    private ColorFilter mColorFilter = null;
    private int pfC = -1;
    private int pfD = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.pfB = true;
    }

    public void setDither(boolean z) {
        this.pfC = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.pfD = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void q(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.pfB) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.pfC != -1) {
                drawable.setDither(this.pfC != 0);
            }
            if (this.pfD != -1) {
                drawable.setFilterBitmap(this.pfD != 0);
            }
        }
    }
}
