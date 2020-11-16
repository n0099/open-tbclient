package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.baidubce.http.Headers;
/* loaded from: classes14.dex */
public class d {
    private int mAlpha = -1;
    private boolean oQr = false;
    private ColorFilter mColorFilter = null;
    private int oQs = -1;
    private int oQt = -1;

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.oQr = true;
    }

    public void setDither(boolean z) {
        this.oQs = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.oQt = z ? 1 : 0;
    }

    @SuppressLint({Headers.RANGE})
    public void q(Drawable drawable) {
        if (drawable != null) {
            if (this.mAlpha != -1) {
                drawable.setAlpha(this.mAlpha);
            }
            if (this.oQr) {
                drawable.setColorFilter(this.mColorFilter);
            }
            if (this.oQs != -1) {
                drawable.setDither(this.oQs != 0);
            }
            if (this.oQt != -1) {
                drawable.setFilterBitmap(this.oQt != 0);
            }
        }
    }
}
