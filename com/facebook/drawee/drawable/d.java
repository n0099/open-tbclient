package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes11.dex */
public class d {
    private int mAlpha = -1;
    private boolean lHL = false;
    private ColorFilter mColorFilter = null;
    private int lHM = -1;
    private int lHN = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.lHL = true;
    }

    public void setDither(boolean z) {
        this.lHM = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.lHN = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void o(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.lHL) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.lHM != -1) {
                drawable.setDither(this.lHM != 0);
            }
            if (this.lHN != -1) {
                drawable.setFilterBitmap(this.lHN != 0);
            }
        }
    }
}
