package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.Preconditions;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class RoundingParams {
    public RoundingMethod mRoundingMethod = RoundingMethod.BITMAP_ONLY;
    public boolean mRoundAsCircle = false;
    @Nullable
    public float[] mCornersRadii = null;
    public int mOverlayColor = 0;
    public float mBorderWidth = 0.0f;
    public int mBorderColor = 0;
    public float mPadding = 0.0f;
    public boolean mScaleDownInsideBorders = false;
    public boolean mPaintFilterBitmap = false;

    /* loaded from: classes9.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public static RoundingParams asCircle() {
        return new RoundingParams().setRoundAsCircle(true);
    }

    private float[] getOrCreateRoundedCornersRadii() {
        if (this.mCornersRadii == null) {
            this.mCornersRadii = new float[8];
        }
        return this.mCornersRadii;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    @Nullable
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

    public static RoundingParams fromCornersRadii(float f, float f2, float f3, float f4) {
        return new RoundingParams().setCornersRadii(f, f2, f3, f4);
    }

    public RoundingParams setCornersRadii(float f, float f2, float f3, float f4) {
        float[] orCreateRoundedCornersRadii = getOrCreateRoundedCornersRadii();
        orCreateRoundedCornersRadii[1] = f;
        orCreateRoundedCornersRadii[0] = f;
        orCreateRoundedCornersRadii[3] = f2;
        orCreateRoundedCornersRadii[2] = f2;
        orCreateRoundedCornersRadii[5] = f3;
        orCreateRoundedCornersRadii[4] = f3;
        orCreateRoundedCornersRadii[7] = f4;
        orCreateRoundedCornersRadii[6] = f4;
        return this;
    }

    public static RoundingParams fromCornersRadii(float[] fArr) {
        return new RoundingParams().setCornersRadii(fArr);
    }

    public static RoundingParams fromCornersRadius(float f) {
        return new RoundingParams().setCornersRadius(f);
    }

    public RoundingParams setBorderColor(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public RoundingParams setBorderWidth(float f) {
        boolean z;
        if (f >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public RoundingParams setCornersRadii(float[] fArr) {
        boolean z;
        Preconditions.checkNotNull(fArr);
        if (fArr.length == 8) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "radii should have exactly 8 values");
        System.arraycopy(fArr, 0, getOrCreateRoundedCornersRadii(), 0, 8);
        return this;
    }

    public RoundingParams setCornersRadius(float f) {
        Arrays.fill(getOrCreateRoundedCornersRadii(), f);
        return this;
    }

    public RoundingParams setOverlayColor(@ColorInt int i) {
        this.mOverlayColor = i;
        this.mRoundingMethod = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public RoundingParams setPadding(float f) {
        boolean z;
        if (f >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "the padding cannot be < 0");
        this.mPadding = f;
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

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RoundingParams.class != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mRoundAsCircle != roundingParams.mRoundAsCircle || this.mOverlayColor != roundingParams.mOverlayColor || Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) != 0 || this.mBorderColor != roundingParams.mBorderColor || Float.compare(roundingParams.mPadding, this.mPadding) != 0 || this.mRoundingMethod != roundingParams.mRoundingMethod || this.mScaleDownInsideBorders != roundingParams.mScaleDownInsideBorders || this.mPaintFilterBitmap != roundingParams.mPaintFilterBitmap) {
            return false;
        }
        return Arrays.equals(this.mCornersRadii, roundingParams.mCornersRadii);
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        RoundingMethod roundingMethod = this.mRoundingMethod;
        int i4 = 0;
        if (roundingMethod != null) {
            i = roundingMethod.hashCode();
        } else {
            i = 0;
        }
        int i5 = ((i * 31) + (this.mRoundAsCircle ? 1 : 0)) * 31;
        float[] fArr = this.mCornersRadii;
        if (fArr != null) {
            i2 = Arrays.hashCode(fArr);
        } else {
            i2 = 0;
        }
        int i6 = (((i5 + i2) * 31) + this.mOverlayColor) * 31;
        float f = this.mBorderWidth;
        if (f != 0.0f) {
            i3 = Float.floatToIntBits(f);
        } else {
            i3 = 0;
        }
        int i7 = (((i6 + i3) * 31) + this.mBorderColor) * 31;
        float f2 = this.mPadding;
        if (f2 != 0.0f) {
            i4 = Float.floatToIntBits(f2);
        }
        return ((((i7 + i4) * 31) + (this.mScaleDownInsideBorders ? 1 : 0)) * 31) + (this.mPaintFilterBitmap ? 1 : 0);
    }

    public RoundingParams setBorder(@ColorInt int i, float f) {
        boolean z;
        if (f >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "the border width cannot be < 0");
        this.mBorderWidth = f;
        this.mBorderColor = i;
        return this;
    }
}
