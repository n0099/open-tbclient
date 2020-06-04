package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes13.dex */
public class d {
    private int mAlpha = -1;
    private boolean mqp = false;
    private ColorFilter mColorFilter = null;
    private int mqq = -1;
    private int mqr = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mqp = true;
    }

    public void setDither(boolean z) {
        this.mqq = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.mqr = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.mqp) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.mqq != -1) {
                drawable.setDither(this.mqq != 0);
            }
            if (this.mqr != -1) {
                drawable.setFilterBitmap(this.mqr != 0);
            }
        }
    }
}
