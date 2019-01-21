package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod ioI = RoundingMethod.BITMAP_ONLY;
    private boolean ioJ = false;
    private float[] ioK = null;
    private int inW = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float inP = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams pa(boolean z) {
        this.ioJ = z;
        return this;
    }

    public boolean bWM() {
        return this.ioJ;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] bWQ = bWQ();
        bWQ[1] = f;
        bWQ[0] = f;
        bWQ[3] = f2;
        bWQ[2] = f2;
        bWQ[5] = f3;
        bWQ[4] = f3;
        bWQ[7] = f4;
        bWQ[6] = f4;
        return this;
    }

    public float[] bWN() {
        return this.ioK;
    }

    public RoundingMethod bWO() {
        return this.ioI;
    }

    public RoundingParams yx(@ColorInt int i) {
        this.inW = i;
        this.ioI = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int bWP() {
        return this.inW;
    }

    private float[] bWQ() {
        if (this.ioK == null) {
            this.ioK = new float[8];
        }
        return this.ioK;
    }

    public RoundingParams aK(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float bWR() {
        return this.mBorderWidth;
    }

    public RoundingParams yy(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aL(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.inP = f;
        return this;
    }

    public float bWS() {
        return this.inP;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.ioJ == roundingParams.ioJ && this.inW == roundingParams.inW && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.inP, this.inP) == 0 && this.ioI == roundingParams.ioI) {
            return Arrays.equals(this.ioK, roundingParams.ioK);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.ioK != null ? Arrays.hashCode(this.ioK) : 0) + (((this.ioJ ? 1 : 0) + ((this.ioI != null ? this.ioI.hashCode() : 0) * 31)) * 31)) * 31) + this.inW) * 31)) * 31) + this.mBorderColor) * 31) + (this.inP != 0.0f ? Float.floatToIntBits(this.inP) : 0);
    }
}
