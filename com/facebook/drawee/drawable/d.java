package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes4.dex */
public class d {
    private int mAlpha = -1;
    private boolean noq = false;
    private ColorFilter mColorFilter = null;
    private int nor = -1;
    private int nos = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.noq = true;
    }

    public void setDither(boolean z) {
        this.nor = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.nos = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.noq) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.nor != -1) {
                drawable.setDither(this.nor != 0);
            }
            if (this.nos != -1) {
                drawable.setFilterBitmap(this.nos != 0);
            }
        }
    }
}
