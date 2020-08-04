package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes9.dex */
public class d {
    private int mAlpha = -1;
    private boolean mUC = false;
    private ColorFilter mColorFilter = null;
    private int mUD = -1;
    private int mUE = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mUC = true;
    }

    public void setDither(boolean z) {
        this.mUD = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.mUE = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.mUC) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.mUD != -1) {
                drawable.setDither(this.mUD != 0);
            }
            if (this.mUE != -1) {
                drawable.setFilterBitmap(this.mUE != 0);
            }
        }
    }
}
