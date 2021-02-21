package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes15.dex */
public class d {
    private int mAlpha = -1;
    private boolean pCX = false;
    private ColorFilter mColorFilter = null;
    private int pCY = -1;
    private int pCZ = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.pCX = true;
    }

    public void setDither(boolean z) {
        this.pCY = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.pCZ = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void w(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.pCX) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.pCY != -1) {
                drawable.setDither(this.pCY != 0);
            }
            if (this.pCZ != -1) {
                drawable.setFilterBitmap(this.pCZ != 0);
            }
        }
    }
}
