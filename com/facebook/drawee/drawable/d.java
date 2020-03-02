package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes13.dex */
public class d {
    private int mAlpha = -1;
    private boolean lLX = false;
    private ColorFilter mColorFilter = null;
    private int lLY = -1;
    private int lLZ = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.lLX = true;
    }

    public void setDither(boolean z) {
        this.lLY = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.lLZ = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void o(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.lLX) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.lLY != -1) {
                drawable.setDither(this.lLY != 0);
            }
            if (this.lLZ != -1) {
                drawable.setFilterBitmap(this.lLZ != 0);
            }
        }
    }
}
