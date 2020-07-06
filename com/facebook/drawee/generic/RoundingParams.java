package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod mNU = RoundingMethod.BITMAP_ONLY;
    private boolean mNV = false;
    private float[] mNW = null;
    private int mMP = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean mMJ = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams wD(boolean z) {
        this.mNV = z;
        return this;
    }

    public boolean dBC() {
        return this.mNV;
    }

    public RoundingParams aJ(float f) {
        Arrays.fill(dBG(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dBG = dBG();
        dBG[1] = f;
        dBG[0] = f;
        dBG[3] = f2;
        dBG[2] = f2;
        dBG[5] = f3;
        dBG[4] = f3;
        dBG[7] = f4;
        dBG[6] = f4;
        return this;
    }

    public float[] dBD() {
        return this.mNW;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.mNU = roundingMethod;
        return this;
    }

    public RoundingMethod dBE() {
        return this.mNU;
    }

    public RoundingParams Ir(@ColorInt int i) {
        this.mMP = i;
        this.mNU = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dBF() {
        return this.mMP;
    }

    private float[] dBG() {
        if (this.mNW == null) {
            this.mNW = new float[8];
        }
        return this.mNW;
    }

    public static RoundingParams dBH() {
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

    public boolean dBI() {
        return this.mMJ;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mNV == roundingParams.mNV && this.mMP == roundingParams.mMP && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.mNU == roundingParams.mNU && this.mMJ == roundingParams.mMJ) {
            return Arrays.equals(this.mNW, roundingParams.mNW);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.mNW != null ? Arrays.hashCode(this.mNW) : 0) + (((this.mNV ? 1 : 0) + ((this.mNU != null ? this.mNU.hashCode() : 0) * 31)) * 31)) * 31) + this.mMP) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.mMJ ? 1 : 0);
    }
}
