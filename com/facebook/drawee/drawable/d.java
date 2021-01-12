package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes3.dex */
public class d {
    private int mAlpha = -1;
    private boolean psn = false;
    private ColorFilter mColorFilter = null;
    private int pso = -1;
    private int psp = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.psn = true;
    }

    public void setDither(boolean z) {
        this.pso = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.psp = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void w(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.psn) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.pso != -1) {
                drawable.setDither(this.pso != 0);
            }
            if (this.psp != -1) {
                drawable.setFilterBitmap(this.psp != 0);
            }
        }
    }
}
