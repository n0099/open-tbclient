package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes4.dex */
public class d {
    private int mAlpha = -1;
    private boolean pwP = false;
    private ColorFilter mColorFilter = null;
    private int pwQ = -1;
    private int pwR = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.pwP = true;
    }

    public void setDither(boolean z) {
        this.pwQ = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.pwR = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void w(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.pwP) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.pwQ != -1) {
                drawable.setDither(this.pwQ != 0);
            }
            if (this.pwR != -1) {
                drawable.setFilterBitmap(this.pwR != 0);
            }
        }
    }
}
