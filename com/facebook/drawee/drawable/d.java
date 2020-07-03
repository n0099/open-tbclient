package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes13.dex */
public class d {
    private int mAlpha = -1;
    private boolean mMo = false;
    private ColorFilter mColorFilter = null;
    private int mMp = -1;
    private int mMq = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mMo = true;
    }

    public void setDither(boolean z) {
        this.mMp = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.mMq = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void k(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.mMo) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.mMp != -1) {
                drawable.setDither(this.mMp != 0);
            }
            if (this.mMq != -1) {
                drawable.setFilterBitmap(this.mMq != 0);
            }
        }
    }
}
