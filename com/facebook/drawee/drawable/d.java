package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes9.dex */
public class d {
    private int mAlpha = -1;
    private boolean mUA = false;
    private ColorFilter mColorFilter = null;
    private int mUB = -1;
    private int mUC = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mUA = true;
    }

    public void setDither(boolean z) {
        this.mUB = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.mUC = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.mUA) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.mUB != -1) {
                drawable.setDither(this.mUB != 0);
            }
            if (this.mUC != -1) {
                drawable.setFilterBitmap(this.mUC != 0);
            }
        }
    }
}
