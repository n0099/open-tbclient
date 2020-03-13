package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes13.dex */
public class d {
    private int mAlpha = -1;
    private boolean lMi = false;
    private ColorFilter mColorFilter = null;
    private int lMj = -1;
    private int lMk = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.lMi = true;
    }

    public void setDither(boolean z) {
        this.lMj = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.lMk = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void o(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.lMi) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.lMj != -1) {
                drawable.setDither(this.lMj != 0);
            }
            if (this.lMk != -1) {
                drawable.setFilterBitmap(this.lMk != 0);
            }
        }
    }
}
