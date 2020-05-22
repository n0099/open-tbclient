package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes13.dex */
public class d {
    private int mAlpha = -1;
    private boolean mpf = false;
    private ColorFilter mColorFilter = null;
    private int mpg = -1;
    private int mph = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mpf = true;
    }

    public void setDither(boolean z) {
        this.mpg = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.mph = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.mpf) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.mpg != -1) {
                drawable.setDither(this.mpg != 0);
            }
            if (this.mph != -1) {
                drawable.setFilterBitmap(this.mph != 0);
            }
        }
    }
}
