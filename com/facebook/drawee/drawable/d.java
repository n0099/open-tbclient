package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes13.dex */
public class d {
    private int mAlpha = -1;
    private boolean lVm = false;
    private ColorFilter mColorFilter = null;
    private int lVn = -1;
    private int lVo = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.lVm = true;
    }

    public void setDither(boolean z) {
        this.lVn = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.lVo = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.lVm) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.lVn != -1) {
                drawable.setDither(this.lVn != 0);
            }
            if (this.lVo != -1) {
                drawable.setFilterBitmap(this.lVo != 0);
            }
        }
    }
}
