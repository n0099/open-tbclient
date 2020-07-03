package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod mNR = RoundingMethod.BITMAP_ONLY;
    private boolean mNS = false;
    private float[] mNT = null;
    private int mMM = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean mMG = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams wD(boolean z) {
        this.mNS = z;
        return this;
    }

    public boolean dBy() {
        return this.mNS;
    }

    public RoundingParams aJ(float f) {
        Arrays.fill(dBC(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dBC = dBC();
        dBC[1] = f;
        dBC[0] = f;
        dBC[3] = f2;
        dBC[2] = f2;
        dBC[5] = f3;
        dBC[4] = f3;
        dBC[7] = f4;
        dBC[6] = f4;
        return this;
    }

    public float[] dBz() {
        return this.mNT;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.mNR = roundingMethod;
        return this;
    }

    public RoundingMethod dBA() {
        return this.mNR;
    }

    public RoundingParams Ir(@ColorInt int i) {
        this.mMM = i;
        this.mNR = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dBB() {
        return this.mMM;
    }

    private float[] dBC() {
        if (this.mNT == null) {
            this.mNT = new float[8];
        }
        return this.mNT;
    }

    public static RoundingParams dBD() {
        return new RoundingParams().wD(true);
    }

    public static RoundingParams i(float f, float f2, float f3, float f4) {
        return new RoundingParams().h(f, f2, f3, f4);
    }

    public RoundingParams aK(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Is(@ColorInt int i) {
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

    public RoundingParams aL(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dBE() {
        return this.mMG;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mNS == roundingParams.mNS && this.mMM == roundingParams.mMM && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.mNR == roundingParams.mNR && this.mMG == roundingParams.mMG) {
            return Arrays.equals(this.mNT, roundingParams.mNT);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.mNT != null ? Arrays.hashCode(this.mNT) : 0) + (((this.mNS ? 1 : 0) + ((this.mNR != null ? this.mNR.hashCode() : 0) * 31)) * 31)) * 31) + this.mMM) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.mMG ? 1 : 0);
    }
}
