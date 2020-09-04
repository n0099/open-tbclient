package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes4.dex */
public class d {
    private int mAlpha = -1;
    private boolean noK = false;
    private ColorFilter mColorFilter = null;
    private int noL = -1;
    private int noM = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.noK = true;
    }

    public void setDither(boolean z) {
        this.noL = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.noM = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.noK) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.noL != -1) {
                drawable.setDither(this.noL != 0);
            }
            if (this.noM != -1) {
                drawable.setFilterBitmap(this.noM != 0);
            }
        }
    }
}
