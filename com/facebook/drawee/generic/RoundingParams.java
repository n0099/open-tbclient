package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod lPp = RoundingMethod.BITMAP_ONLY;
    private boolean lPq = false;
    private float[] lPr = null;
    private int lOk = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean lOf = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams vt(boolean z) {
        this.lPq = z;
        return this;
    }

    public boolean dny() {
        return this.lPq;
    }

    public RoundingParams bo(float f) {
        Arrays.fill(dnC(), f);
        return this;
    }

    public RoundingParams n(float f, float f2, float f3, float f4) {
        float[] dnC = dnC();
        dnC[1] = f;
        dnC[0] = f;
        dnC[3] = f2;
        dnC[2] = f2;
        dnC[5] = f3;
        dnC[4] = f3;
        dnC[7] = f4;
        dnC[6] = f4;
        return this;
    }

    public float[] dnz() {
        return this.lPr;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.lPp = roundingMethod;
        return this;
    }

    public RoundingMethod dnA() {
        return this.lPp;
    }

    public RoundingParams HV(@ColorInt int i) {
        this.lOk = i;
        this.lPp = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dnB() {
        return this.lOk;
    }

    private float[] dnC() {
        if (this.lPr == null) {
            this.lPr = new float[8];
        }
        return this.lPr;
    }

    public static RoundingParams dnD() {
        return new RoundingParams().vt(true);
    }

    public static RoundingParams o(float f, float f2, float f3, float f4) {
        return new RoundingParams().n(f, f2, f3, f4);
    }

    public RoundingParams bp(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams HW(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams q(@ColorInt int i, float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        this.mBorderColor = i;
        return this;
    }

    public RoundingParams bq(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dnE() {
        return this.lOf;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.lPq == roundingParams.lPq && this.lOk == roundingParams.lOk && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.lPp == roundingParams.lPp && this.lOf == roundingParams.lOf) {
            return Arrays.equals(this.lPr, roundingParams.lPr);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.lPr != null ? Arrays.hashCode(this.lPr) : 0) + (((this.lPq ? 1 : 0) + ((this.lPp != null ? this.lPp.hashCode() : 0) * 31)) * 31)) * 31) + this.lOk) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.lOf ? 1 : 0);
    }
}
