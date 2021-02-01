package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes15.dex */
public class d {
    private int mAlpha = -1;
    private boolean pCx = false;
    private ColorFilter mColorFilter = null;
    private int pCy = -1;
    private int pCz = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.pCx = true;
    }

    public void setDither(boolean z) {
        this.pCy = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.pCz = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void w(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.pCx) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.pCy != -1) {
                drawable.setDither(this.pCy != 0);
            }
            if (this.pCz != -1) {
                drawable.setFilterBitmap(this.pCz != 0);
            }
        }
    }
}
