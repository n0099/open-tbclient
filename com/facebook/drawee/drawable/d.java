package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes15.dex */
public class d {
    private int mAlpha = -1;
    private boolean pwI = false;
    private ColorFilter mColorFilter = null;
    private int pwJ = -1;
    private int pwK = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.pwI = true;
    }

    public void setDither(boolean z) {
        this.pwJ = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.pwK = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void w(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.pwI) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.pwJ != -1) {
                drawable.setDither(this.pwJ != 0);
            }
            if (this.pwK != -1) {
                drawable.setFilterBitmap(this.pwK != 0);
            }
        }
    }
}
