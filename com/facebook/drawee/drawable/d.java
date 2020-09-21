package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes11.dex */
public class d {
    private int mAlpha = -1;
    private boolean nyI = false;
    private ColorFilter mColorFilter = null;
    private int nyJ = -1;
    private int nyK = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.nyI = true;
    }

    public void setDither(boolean z) {
        this.nyJ = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.nyK = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.nyI) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.nyJ != -1) {
                drawable.setDither(this.nyJ != 0);
            }
            if (this.nyK != -1) {
                drawable.setFilterBitmap(this.nyK != 0);
            }
        }
    }
}
