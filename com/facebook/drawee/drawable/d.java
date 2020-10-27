package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes15.dex */
public class d {
    private int mAlpha = -1;
    private boolean oFu = false;
    private ColorFilter mColorFilter = null;
    private int oFv = -1;
    private int oFw = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.oFu = true;
    }

    public void setDither(boolean z) {
        this.oFv = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.oFw = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void p(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.oFu) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.oFv != -1) {
                drawable.setDither(this.oFv != 0);
            }
            if (this.oFw != -1) {
                drawable.setFilterBitmap(this.oFw != 0);
            }
        }
    }
}
