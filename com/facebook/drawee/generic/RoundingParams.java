package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class RoundingParams {
    private RoundingMethod nPE = RoundingMethod.BITMAP_ONLY;
    private boolean nPF = false;
    private float[] nPG = null;
    private int nOz = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean nOt = false;

    /* loaded from: classes15.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams yR(boolean z) {
        this.nPF = z;
        return this;
    }

    public boolean dYG() {
        return this.nPF;
    }

    public RoundingParams aU(float f) {
        Arrays.fill(dYK(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dYK = dYK();
        dYK[1] = f;
        dYK[0] = f;
        dYK[3] = f2;
        dYK[2] = f2;
        dYK[5] = f3;
        dYK[4] = f3;
        dYK[7] = f4;
        dYK[6] = f4;
        return this;
    }

    public float[] dYH() {
        return this.nPG;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.nPE = roundingMethod;
        return this;
    }

    public RoundingMethod dYI() {
        return this.nPE;
    }

    public RoundingParams MB(@ColorInt int i) {
        this.nOz = i;
        this.nPE = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dYJ() {
        return this.nOz;
    }

    private float[] dYK() {
        if (this.nPG == null) {
            this.nPG = new float[8];
        }
        return this.nPG;
    }

    public static RoundingParams dYL() {
        return new RoundingParams().yR(true);
    }

    public static RoundingParams i(float f, float f2, float f3, float f4) {
        return new RoundingParams().h(f, f2, f3, f4);
    }

    public RoundingParams aV(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams MC(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams p(@ColorInt int i, float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        this.mBorderColor = i;
        return this;
    }

    public RoundingParams aW(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dYM() {
        return this.nOt;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.nPF == roundingParams.nPF && this.nOz == roundingParams.nOz && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.nPE == roundingParams.nPE && this.nOt == roundingParams.nOt) {
            return Arrays.equals(this.nPG, roundingParams.nPG);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.nPG != null ? Arrays.hashCode(this.nPG) : 0) + (((this.nPF ? 1 : 0) + ((this.nPE != null ? this.nPE.hashCode() : 0) * 31)) * 31)) * 31) + this.nOz) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.nOt ? 1 : 0);
    }
}
