package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class RoundingParams {
    private RoundingMethod npV = RoundingMethod.BITMAP_ONLY;
    private boolean npW = false;
    private float[] npX = null;
    private int noQ = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean noK = false;

    /* loaded from: classes4.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams xZ(boolean z) {
        this.npW = z;
        return this;
    }

    public boolean dQO() {
        return this.npW;
    }

    public RoundingParams aO(float f) {
        Arrays.fill(dQS(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dQS = dQS();
        dQS[1] = f;
        dQS[0] = f;
        dQS[3] = f2;
        dQS[2] = f2;
        dQS[5] = f3;
        dQS[4] = f3;
        dQS[7] = f4;
        dQS[6] = f4;
        return this;
    }

    public float[] dQP() {
        return this.npX;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.npV = roundingMethod;
        return this;
    }

    public RoundingMethod dQQ() {
        return this.npV;
    }

    public RoundingParams Lq(@ColorInt int i) {
        this.noQ = i;
        this.npV = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dQR() {
        return this.noQ;
    }

    private float[] dQS() {
        if (this.npX == null) {
            this.npX = new float[8];
        }
        return this.npX;
    }

    public static RoundingParams dQT() {
        return new RoundingParams().xZ(true);
    }

    public static RoundingParams i(float f, float f2, float f3, float f4) {
        return new RoundingParams().h(f, f2, f3, f4);
    }

    public RoundingParams aP(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Lr(@ColorInt int i) {
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

    public RoundingParams aQ(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dQU() {
        return this.noK;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.npW == roundingParams.npW && this.noQ == roundingParams.noQ && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.npV == roundingParams.npV && this.noK == roundingParams.noK) {
            return Arrays.equals(this.npX, roundingParams.npX);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.npX != null ? Arrays.hashCode(this.npX) : 0) + (((this.npW ? 1 : 0) + ((this.npV != null ? this.npV.hashCode() : 0) * 31)) * 31)) * 31) + this.noQ) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.noK ? 1 : 0);
    }
}
