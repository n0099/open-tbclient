package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes12.dex */
public class d {
    private int mAlpha = -1;
    private boolean lLj = false;
    private ColorFilter mColorFilter = null;
    private int lLk = -1;
    private int lLl = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.lLj = true;
    }

    public void setDither(boolean z) {
        this.lLk = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.lLl = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void o(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.lLj) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.lLk != -1) {
                drawable.setDither(this.lLk != 0);
            }
            if (this.lLl != -1) {
                drawable.setFilterBitmap(this.lLl != 0);
            }
        }
    }
}
