package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class RoundingParams {
    private RoundingMethod pEb = RoundingMethod.BITMAP_ONLY;
    private boolean pEc = false;
    private float[] pEd = null;
    private int pCV = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean pCQ = false;

    /* loaded from: classes15.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams Br(boolean z) {
        this.pEc = z;
        return this;
    }

    public boolean euR() {
        return this.pEc;
    }

    public RoundingParams bK(float f) {
        Arrays.fill(euV(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] euV = euV();
        euV[1] = f;
        euV[0] = f;
        euV[3] = f2;
        euV[2] = f2;
        euV[5] = f3;
        euV[4] = f3;
        euV[7] = f4;
        euV[6] = f4;
        return this;
    }

    public float[] euS() {
        return this.pEd;
    }

    public RoundingMethod euT() {
        return this.pEb;
    }

    public RoundingParams Pp(@ColorInt int i) {
        this.pCV = i;
        this.pEb = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int euU() {
        return this.pCV;
    }

    private float[] euV() {
        if (this.pEd == null) {
            this.pEd = new float[8];
        }
        return this.pEd;
    }

    public RoundingParams bL(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Pq(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams bM(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean euW() {
        return this.pCQ;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.pEc == roundingParams.pEc && this.pCV == roundingParams.pCV && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.pEb == roundingParams.pEb && this.pCQ == roundingParams.pCQ) {
            return Arrays.equals(this.pEd, roundingParams.pEd);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.pEd != null ? Arrays.hashCode(this.pEd) : 0) + (((this.pEc ? 1 : 0) + ((this.pEb != null ? this.pEb.hashCode() : 0) * 31)) * 31)) * 31) + this.pCV) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.pCQ ? 1 : 0);
    }
}
