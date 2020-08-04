package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class RoundingParams {
    private RoundingMethod mWf = RoundingMethod.BITMAP_ONLY;
    private boolean mWg = false;
    private float[] mWh = null;
    private int mVa = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean mUU = false;

    /* loaded from: classes9.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams xi(boolean z) {
        this.mWg = z;
        return this;
    }

    public boolean dEP() {
        return this.mWg;
    }

    public RoundingParams aI(float f) {
        Arrays.fill(dET(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dET = dET();
        dET[1] = f;
        dET[0] = f;
        dET[3] = f2;
        dET[2] = f2;
        dET[5] = f3;
        dET[4] = f3;
        dET[7] = f4;
        dET[6] = f4;
        return this;
    }

    public float[] dEQ() {
        return this.mWh;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.mWf = roundingMethod;
        return this;
    }

    public RoundingMethod dER() {
        return this.mWf;
    }

    public RoundingParams IM(@ColorInt int i) {
        this.mVa = i;
        this.mWf = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dES() {
        return this.mVa;
    }

    private float[] dET() {
        if (this.mWh == null) {
            this.mWh = new float[8];
        }
        return this.mWh;
    }

    public static RoundingParams dEU() {
        return new RoundingParams().xi(true);
    }

    public static RoundingParams i(float f, float f2, float f3, float f4) {
        return new RoundingParams().h(f, f2, f3, f4);
    }

    public RoundingParams aJ(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams IN(@ColorInt int i) {
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

    public RoundingParams aK(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dEV() {
        return this.mUU;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mWg == roundingParams.mWg && this.mVa == roundingParams.mVa && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.mWf == roundingParams.mWf && this.mUU == roundingParams.mUU) {
            return Arrays.equals(this.mWh, roundingParams.mWh);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.mWh != null ? Arrays.hashCode(this.mWh) : 0) + (((this.mWg ? 1 : 0) + ((this.mWf != null ? this.mWf.hashCode() : 0) * 31)) * 31)) * 31) + this.mVa) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.mUU ? 1 : 0);
    }
}
