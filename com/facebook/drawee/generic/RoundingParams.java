package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod lNJ = RoundingMethod.BITMAP_ONLY;
    private boolean lNK = false;
    private float[] lNL = null;
    private int lME = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean lMz = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams vm(boolean z) {
        this.lNK = z;
        return this;
    }

    public boolean dna() {
        return this.lNK;
    }

    public RoundingParams bo(float f) {
        Arrays.fill(dne(), f);
        return this;
    }

    public RoundingParams n(float f, float f2, float f3, float f4) {
        float[] dne = dne();
        dne[1] = f;
        dne[0] = f;
        dne[3] = f2;
        dne[2] = f2;
        dne[5] = f3;
        dne[4] = f3;
        dne[7] = f4;
        dne[6] = f4;
        return this;
    }

    public float[] dnb() {
        return this.lNL;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.lNJ = roundingMethod;
        return this;
    }

    public RoundingMethod dnc() {
        return this.lNJ;
    }

    public RoundingParams HP(@ColorInt int i) {
        this.lME = i;
        this.lNJ = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dnd() {
        return this.lME;
    }

    private float[] dne() {
        if (this.lNL == null) {
            this.lNL = new float[8];
        }
        return this.lNL;
    }

    public static RoundingParams dnf() {
        return new RoundingParams().vm(true);
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

    public RoundingParams HQ(@ColorInt int i) {
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

    public boolean dng() {
        return this.lMz;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.lNK == roundingParams.lNK && this.lME == roundingParams.lME && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.lNJ == roundingParams.lNJ && this.lMz == roundingParams.lMz) {
            return Arrays.equals(this.lNL, roundingParams.lNL);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.lNL != null ? Arrays.hashCode(this.lNL) : 0) + (((this.lNK ? 1 : 0) + ((this.lNJ != null ? this.lNJ.hashCode() : 0) * 31)) * 31)) * 31) + this.lME) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.lMz ? 1 : 0);
    }
}
