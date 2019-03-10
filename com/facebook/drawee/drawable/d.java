package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public class d {
    private int mAlpha = -1;
    private boolean jDe = false;
    private ColorFilter mColorFilter = null;
    private int jDf = -1;
    private int jDg = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.jDe = true;
    }

    public void setDither(boolean z) {
        this.jDf = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.jDg = z ? 1 : 0;
    }

    @SuppressLint({"Range"})
    public void j(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.jDe) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.jDf != -1) {
                drawable.setDither(this.jDf != 0);
            }
            if (this.jDg != -1) {
                drawable.setFilterBitmap(this.jDg != 0);
            }
        }
    }
}
