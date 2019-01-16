package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod ioH = RoundingMethod.BITMAP_ONLY;
    private boolean ioI = false;
    private float[] ioJ = null;
    private int inV = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float inO = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams pa(boolean z) {
        this.ioI = z;
        return this;
    }

    public boolean bWM() {
        return this.ioI;
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
        return this.ioJ;
    }

    public RoundingMethod bWO() {
        return this.ioH;
    }

    public RoundingParams yx(@ColorInt int i) {
        this.inV = i;
        this.ioH = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int bWP() {
        return this.inV;
    }

    private float[] bWQ() {
        if (this.ioJ == null) {
            this.ioJ = new float[8];
        }
        return this.ioJ;
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
        this.inO = f;
        return this;
    }

    public float bWS() {
        return this.inO;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.ioI == roundingParams.ioI && this.inV == roundingParams.inV && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.inO, this.inO) == 0 && this.ioH == roundingParams.ioH) {
            return Arrays.equals(this.ioJ, roundingParams.ioJ);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.ioJ != null ? Arrays.hashCode(this.ioJ) : 0) + (((this.ioI ? 1 : 0) + ((this.ioH != null ? this.ioH.hashCode() : 0) * 31)) * 31)) * 31) + this.inV) * 31)) * 31) + this.mBorderColor) * 31) + (this.inO != 0.0f ? Float.floatToIntBits(this.inO) : 0);
    }
}
