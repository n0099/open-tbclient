package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes12.dex */
public class d {
    private int mAlpha = -1;
    private boolean lLo = false;
    private ColorFilter mColorFilter = null;
    private int lLp = -1;
    private int lLq = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.lLo = true;
    }

    public void setDither(boolean z) {
        this.lLp = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.lLq = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void o(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.lLo) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.lLp != -1) {
                drawable.setDither(this.lLp != 0);
            }
            if (this.lLq != -1) {
                drawable.setFilterBitmap(this.lLq != 0);
            }
        }
    }
}
