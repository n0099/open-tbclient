package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod lWL = RoundingMethod.BITMAP_ONLY;
    private boolean lWM = false;
    private float[] lWN = null;
    private int lVG = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float lVA = 0.0f;
    private boolean lVB = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams vH(boolean z) {
        this.lWM = z;
        return this;
    }

    public boolean dpr() {
        return this.lWM;
    }

    public RoundingParams aE(float f) {
        Arrays.fill(dpv(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dpv = dpv();
        dpv[1] = f;
        dpv[0] = f;
        dpv[3] = f2;
        dpv[2] = f2;
        dpv[5] = f3;
        dpv[4] = f3;
        dpv[7] = f4;
        dpv[6] = f4;
        return this;
    }

    public float[] dps() {
        return this.lWN;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.lWL = roundingMethod;
        return this;
    }

    public RoundingMethod dpt() {
        return this.lWL;
    }

    public RoundingParams Gw(@ColorInt int i) {
        this.lVG = i;
        this.lWL = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dpu() {
        return this.lVG;
    }

    private float[] dpv() {
        if (this.lWN == null) {
            this.lWN = new float[8];
        }
        return this.lWN;
    }

    public static RoundingParams dpw() {
        return new RoundingParams().vH(true);
    }

    public static RoundingParams i(float f, float f2, float f3, float f4) {
        return new RoundingParams().h(f, f2, f3, f4);
    }

    public RoundingParams aF(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Gx(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams o(@ColorInt int i, float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        this.mBorderColor = i;
        return this;
    }

    public RoundingParams aG(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.lVA = f;
        return this;
    }

    public float dpx() {
        return this.lVA;
    }

    public boolean dpy() {
        return this.lVB;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.lWM == roundingParams.lWM && this.lVG == roundingParams.lVG && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.lVA, this.lVA) == 0 && this.lWL == roundingParams.lWL && this.lVB == roundingParams.lVB) {
            return Arrays.equals(this.lWN, roundingParams.lWN);
        }
        return false;
    }

    public int hashCode() {
        return (((this.lVA != 0.0f ? Float.floatToIntBits(this.lVA) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.lWN != null ? Arrays.hashCode(this.lWN) : 0) + (((this.lWM ? 1 : 0) + ((this.lWL != null ? this.lWL.hashCode() : 0) * 31)) * 31)) * 31) + this.lVG) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.lVB ? 1 : 0);
    }
}
