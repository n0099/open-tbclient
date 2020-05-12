package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod lWP = RoundingMethod.BITMAP_ONLY;
    private boolean lWQ = false;
    private float[] lWR = null;
    private int lVK = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float lVE = 0.0f;
    private boolean lVF = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams vH(boolean z) {
        this.lWQ = z;
        return this;
    }

    public boolean dpp() {
        return this.lWQ;
    }

    public RoundingParams aE(float f) {
        Arrays.fill(dpt(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dpt = dpt();
        dpt[1] = f;
        dpt[0] = f;
        dpt[3] = f2;
        dpt[2] = f2;
        dpt[5] = f3;
        dpt[4] = f3;
        dpt[7] = f4;
        dpt[6] = f4;
        return this;
    }

    public float[] dpq() {
        return this.lWR;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.lWP = roundingMethod;
        return this;
    }

    public RoundingMethod dpr() {
        return this.lWP;
    }

    public RoundingParams Gw(@ColorInt int i) {
        this.lVK = i;
        this.lWP = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dps() {
        return this.lVK;
    }

    private float[] dpt() {
        if (this.lWR == null) {
            this.lWR = new float[8];
        }
        return this.lWR;
    }

    public static RoundingParams dpu() {
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
        this.lVE = f;
        return this;
    }

    public float dpv() {
        return this.lVE;
    }

    public boolean dpw() {
        return this.lVF;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.lWQ == roundingParams.lWQ && this.lVK == roundingParams.lVK && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.lVE, this.lVE) == 0 && this.lWP == roundingParams.lWP && this.lVF == roundingParams.lVF) {
            return Arrays.equals(this.lWR, roundingParams.lWR);
        }
        return false;
    }

    public int hashCode() {
        return (((this.lVE != 0.0f ? Float.floatToIntBits(this.lVE) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.lWR != null ? Arrays.hashCode(this.lWR) : 0) + (((this.lWQ ? 1 : 0) + ((this.lWP != null ? this.lWP.hashCode() : 0) * 31)) * 31)) * 31) + this.lVK) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.lVF ? 1 : 0);
    }
}
