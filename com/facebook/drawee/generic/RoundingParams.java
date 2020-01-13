package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class RoundingParams {
    private RoundingMethod lMK = RoundingMethod.BITMAP_ONLY;
    private boolean lML = false;
    private float[] lMM = null;
    private int lLF = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean lLA = false;

    /* loaded from: classes12.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams vi(boolean z) {
        this.lML = z;
        return this;
    }

    public boolean dlJ() {
        return this.lML;
    }

    public RoundingParams bp(float f) {
        Arrays.fill(dlN(), f);
        return this;
    }

    public RoundingParams n(float f, float f2, float f3, float f4) {
        float[] dlN = dlN();
        dlN[1] = f;
        dlN[0] = f;
        dlN[3] = f2;
        dlN[2] = f2;
        dlN[5] = f3;
        dlN[4] = f3;
        dlN[7] = f4;
        dlN[6] = f4;
        return this;
    }

    public float[] dlK() {
        return this.lMM;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.lMK = roundingMethod;
        return this;
    }

    public RoundingMethod dlL() {
        return this.lMK;
    }

    public RoundingParams HK(@ColorInt int i) {
        this.lLF = i;
        this.lMK = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dlM() {
        return this.lLF;
    }

    private float[] dlN() {
        if (this.lMM == null) {
            this.lMM = new float[8];
        }
        return this.lMM;
    }

    public static RoundingParams dlO() {
        return new RoundingParams().vi(true);
    }

    public static RoundingParams o(float f, float f2, float f3, float f4) {
        return new RoundingParams().n(f, f2, f3, f4);
    }

    public RoundingParams bq(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams HL(@ColorInt int i) {
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

    public RoundingParams br(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dlP() {
        return this.lLA;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.lML == roundingParams.lML && this.lLF == roundingParams.lLF && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.lMK == roundingParams.lMK && this.lLA == roundingParams.lLA) {
            return Arrays.equals(this.lMM, roundingParams.lMM);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.lMM != null ? Arrays.hashCode(this.lMM) : 0) + (((this.lML ? 1 : 0) + ((this.lMK != null ? this.lMK.hashCode() : 0) * 31)) * 31)) * 31) + this.lLF) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.lLA ? 1 : 0);
    }
}
