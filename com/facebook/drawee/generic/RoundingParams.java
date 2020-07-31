package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class RoundingParams {
    private RoundingMethod mWd = RoundingMethod.BITMAP_ONLY;
    private boolean mWe = false;
    private float[] mWf = null;
    private int mUY = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean mUS = false;

    /* loaded from: classes9.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams xi(boolean z) {
        this.mWe = z;
        return this;
    }

    public boolean dEO() {
        return this.mWe;
    }

    public RoundingParams aI(float f) {
        Arrays.fill(dES(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dES = dES();
        dES[1] = f;
        dES[0] = f;
        dES[3] = f2;
        dES[2] = f2;
        dES[5] = f3;
        dES[4] = f3;
        dES[7] = f4;
        dES[6] = f4;
        return this;
    }

    public float[] dEP() {
        return this.mWf;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.mWd = roundingMethod;
        return this;
    }

    public RoundingMethod dEQ() {
        return this.mWd;
    }

    public RoundingParams IM(@ColorInt int i) {
        this.mUY = i;
        this.mWd = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dER() {
        return this.mUY;
    }

    private float[] dES() {
        if (this.mWf == null) {
            this.mWf = new float[8];
        }
        return this.mWf;
    }

    public static RoundingParams dET() {
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

    public boolean dEU() {
        return this.mUS;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mWe == roundingParams.mWe && this.mUY == roundingParams.mUY && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.mWd == roundingParams.mWd && this.mUS == roundingParams.mUS) {
            return Arrays.equals(this.mWf, roundingParams.mWf);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.mWf != null ? Arrays.hashCode(this.mWf) : 0) + (((this.mWe ? 1 : 0) + ((this.mWd != null ? this.mWd.hashCode() : 0) * 31)) * 31)) * 31) + this.mUY) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.mUS ? 1 : 0);
    }
}
