package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes3.dex */
public class d {
    private int mAlpha = -1;
    private boolean pso = false;
    private ColorFilter mColorFilter = null;
    private int psp = -1;
    private int psq = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.pso = true;
    }

    public void setDither(boolean z) {
        this.psp = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.psq = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void w(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.pso) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.psp != -1) {
                drawable.setDither(this.psp != 0);
            }
            if (this.psq != -1) {
                drawable.setFilterBitmap(this.psq != 0);
            }
        }
    }
}
