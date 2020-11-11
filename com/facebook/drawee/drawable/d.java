package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes15.dex */
public class d {
    private int mAlpha = -1;
    private boolean oON = false;
    private ColorFilter mColorFilter = null;
    private int oOO = -1;
    private int oOP = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.oON = true;
    }

    public void setDither(boolean z) {
        this.oOO = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.oOP = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void p(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.oON) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.oOO != -1) {
                drawable.setDither(this.oOO != 0);
            }
            if (this.oOP != -1) {
                drawable.setFilterBitmap(this.oOP != 0);
            }
        }
    }
}
