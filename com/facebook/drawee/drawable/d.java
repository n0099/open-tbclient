package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes4.dex */
public class d {
    private int mAlpha = -1;
    private boolean pFc = false;
    private ColorFilter mColorFilter = null;
    private int pFd = -1;
    private int pFe = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.pFc = true;
    }

    public void setDither(boolean z) {
        this.pFd = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.pFe = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void w(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.pFc) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.pFd != -1) {
                drawable.setDither(this.pFd != 0);
            }
            if (this.pFe != -1) {
                drawable.setFilterBitmap(this.pFe != 0);
            }
        }
    }
}
