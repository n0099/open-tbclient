package com.facebook.drawee.drawable;

import android.annotation.SuppressLint;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes8.dex */
public class DrawableProperties {
    public static final int UNSET = -1;
    public int mAlpha = -1;
    public boolean mIsSetColorFilter = false;
    public ColorFilter mColorFilter = null;
    public int mDither = -1;
    public int mFilterBitmap = -1;

    @SuppressLint({"Range"})
    public void applyTo(Drawable drawable) {
        boolean z;
        if (drawable == null) {
            return;
        }
        int i = this.mAlpha;
        if (i != -1) {
            drawable.setAlpha(i);
        }
        if (this.mIsSetColorFilter) {
            drawable.setColorFilter(this.mColorFilter);
        }
        int i2 = this.mDither;
        boolean z2 = true;
        if (i2 != -1) {
            if (i2 != 0) {
                z = true;
            } else {
                z = false;
            }
            drawable.setDither(z);
        }
        int i3 = this.mFilterBitmap;
        if (i3 != -1) {
            if (i3 == 0) {
                z2 = false;
            }
            drawable.setFilterBitmap(z2);
        }
    }

    public void setAlpha(int i) {
        this.mAlpha = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mColorFilter = colorFilter;
        this.mIsSetColorFilter = true;
    }

    public void setDither(boolean z) {
        this.mDither = z ? 1 : 0;
    }

    public void setFilterBitmap(boolean z) {
        this.mFilterBitmap = z ? 1 : 0;
    }
}
