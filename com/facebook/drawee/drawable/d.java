package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes13.dex */
public class d {
    private int mAlpha = -1;
    private boolean lLV = false;
    private ColorFilter mColorFilter = null;
    private int lLW = -1;
    private int lLX = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.lLV = true;
    }

    public void setDither(boolean z) {
        this.lLW = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.lLX = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void o(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.lLV) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.lLW != -1) {
                drawable.setDither(this.lLW != 0);
            }
            if (this.lLX != -1) {
                drawable.setFilterBitmap(this.lLX != 0);
            }
        }
    }
}
