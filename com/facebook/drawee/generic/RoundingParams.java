package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class RoundingParams {
    private RoundingMethod pGG = RoundingMethod.BITMAP_ONLY;
    private boolean pGH = false;
    private float[] pGI = null;
    private int pFA = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean pFv = false;

    /* loaded from: classes4.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams Bp(boolean z) {
        this.pGH = z;
        return this;
    }

    public boolean evi() {
        return this.pGH;
    }

    public RoundingParams bO(float f) {
        Arrays.fill(evm(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] evm = evm();
        evm[1] = f;
        evm[0] = f;
        evm[3] = f2;
        evm[2] = f2;
        evm[5] = f3;
        evm[4] = f3;
        evm[7] = f4;
        evm[6] = f4;
        return this;
    }

    public float[] evj() {
        return this.pGI;
    }

    public RoundingMethod evk() {
        return this.pGG;
    }

    public RoundingParams Pu(@ColorInt int i) {
        this.pFA = i;
        this.pGG = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int evl() {
        return this.pFA;
    }

    private float[] evm() {
        if (this.pGI == null) {
            this.pGI = new float[8];
        }
        return this.pGI;
    }

    public RoundingParams bP(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Pv(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams bQ(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean evn() {
        return this.pFv;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.pGH == roundingParams.pGH && this.pFA == roundingParams.pFA && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.pGG == roundingParams.pGG && this.pFv == roundingParams.pFv) {
            return Arrays.equals(this.pGI, roundingParams.pGI);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.pGI != null ? Arrays.hashCode(this.pGI) : 0) + (((this.pGH ? 1 : 0) + ((this.pGG != null ? this.pGG.hashCode() : 0) * 31)) * 31)) * 31) + this.pFA) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.pFv ? 1 : 0);
    }
}
