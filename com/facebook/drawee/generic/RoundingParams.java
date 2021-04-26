package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class RoundingParams {
    public RoundingMethod mRoundingMethod = RoundingMethod.BITMAP_ONLY;
    public boolean mRoundAsCircle = false;
    public float[] mCornersRadii = null;
    public int mOverlayColor = 0;
    public float mBorderWidth = 0.0f;
    public int mBorderColor = 0;
    public float mPadding = 0.0f;
    public boolean mScaleDownInsideBorders = false;
    public boolean mPaintFilterBitmap = false;

    /* loaded from: classes6.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public static RoundingParams asCircle() {
        return new RoundingParams().setRoundAsCircle(true);
    }

    public static RoundingParams fromCornersRadii(float f2, float f3, float f4, float f5) {
        return new RoundingParams().setCornersRadii(f2, f3, f4, f5);
    }

    public static RoundingParams fromCornersRadius(float f2) {
        return new RoundingParams().setCornersRadius(f2);
    }

    private float[] getOrCreateRoundedCornersRadii() {
        if (this.mCornersRadii == null) {
            this.mCornersRadii = new float[8];
        }
        return this.mCornersRadii;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RoundingParams.class != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mRoundAsCircle == roundingParams.mRoundAsCircle && this.mOverlayColor == roundingParams.mOverlayColor && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.mRoundingMethod == roundingParams.mRoundingMethod && this.mScaleDownInsideBorders == roundingParams.mScaleDownInsideBorders && this.mPaintFilterBitmap == roundingParams.mPaintFilterBitmap) {
            return Arrays.equals(this.mCornersRadii, roundingParams.mCornersRadii);
        }
        return false;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public float[] getCornersRadii() {
        return this.mCornersRadii;
    }

    public int getOverlayColor() {
        return this.mOverlayColor;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean getPaintFilterBitmap() {
        return this.mPaintFilterBitmap;
    }

    public boolean getRoundAsCircle() {
        return this.mRoundAsCircle;
    }

    public RoundingMethod getRoundingMethod() {
        return this.mRoundingMethod;
    }

    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    public int hashCode() {
        RoundingMethod roundingMethod = this.mRoundingMethod;
        int hashCode = (((roundingMethod != null ? roundingMethod.hashCode() : 0) * 31) + (this.mRoundAsCircle ? 1 : 0)) * 31;
        float[] fArr = this.mCornersRadii;
        int hashCode2 = (((hashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.mOverlayColor) * 31;
        float f2 = this.mBorderWidth;
        int floatToIntBits = (((hashCode2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.mBorderColor) * 31;
        float f3 = this.mPadding;
        return ((((floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31) + (this.mScaleDownInsideBorders ? 1 : 0)) * 31) + (this.mPaintFilterBitmap ? 1 : 0);
    }

    public RoundingParams setBorder(@ColorInt int i2, float f2) {
        Preconditions.checkArgument(f2 >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f2;
        this.mBorderColor = i2;
        return this;
    }

    public RoundingParams setBorderColor(@ColorInt int i2) {
        this.mBorderColor = i2;
        return this;
    }

    public RoundingParams setBorderWidth(float f2) {
        Preconditions.checkArgument(f2 >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f2;
        return this;
    }

    public RoundingParams setCornersRadii(float f2, float f3, float f4, float f5) {
        float[] orCreateRoundedCornersRadii = getOrCreateRoundedCornersRadii();
        orCreateRoundedCornersRadii[1] = f2;
        orCreateRoundedCornersRadii[0] = f2;
        orCreateRoundedCornersRadii[3] = f3;
        orCreateRoundedCornersRadii[2] = f3;
        orCreateRoundedCornersRadii[5] = f4;
        orCreateRoundedCornersRadii[4] = f4;
        orCreateRoundedCornersRadii[7] = f5;
        orCreateRoundedCornersRadii[6] = f5;
        return this;
    }

    public RoundingParams setCornersRadius(float f2) {
        Arrays.fill(getOrCreateRoundedCornersRadii(), f2);
        return this;
    }

    public RoundingParams setOverlayColor(@ColorInt int i2) {
        this.mOverlayColor = i2;
        this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public RoundingParams setPadding(float f2) {
        Preconditions.checkArgument(f2 >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f2;
        return this;
    }

    public RoundingParams setPaintFilterBitmap(boolean z) {
        this.mPaintFilterBitmap = z;
        return this;
    }

    public RoundingParams setRoundAsCircle(boolean z) {
        this.mRoundAsCircle = z;
        return this;
    }

    public RoundingParams setRoundingMethod(RoundingMethod roundingMethod) {
        this.mRoundingMethod = roundingMethod;
        return this;
    }

    public RoundingParams setScaleDownInsideBorders(boolean z) {
        this.mScaleDownInsideBorders = z;
        return this;
    }

    public static RoundingParams fromCornersRadii(float[] fArr) {
        return new RoundingParams().setCornersRadii(fArr);
    }

    public RoundingParams setCornersRadii(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
        System.arraycopy(fArr, 0, getOrCreateRoundedCornersRadii(), 0, 8);
        return this;
    }
}
