package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class RoundingParams {
    private RoundingMethod ptS = RoundingMethod.BITMAP_ONLY;
    private boolean ptT = false;
    private float[] ptU = null;
    private int psL = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean psG = false;

    /* loaded from: classes3.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams AY(boolean z) {
        this.ptT = z;
        return this;
    }

    public boolean esz() {
        return this.ptT;
    }

    public RoundingParams bH(float f) {
        Arrays.fill(esD(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] esD = esD();
        esD[1] = f;
        esD[0] = f;
        esD[3] = f2;
        esD[2] = f2;
        esD[5] = f3;
        esD[4] = f3;
        esD[7] = f4;
        esD[6] = f4;
        return this;
    }

    public float[] esA() {
        return this.ptU;
    }

    public RoundingMethod esB() {
        return this.ptS;
    }

    public RoundingParams OU(@ColorInt int i) {
        this.psL = i;
        this.ptS = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int esC() {
        return this.psL;
    }

    private float[] esD() {
        if (this.ptU == null) {
            this.ptU = new float[8];
        }
        return this.ptU;
    }

    public RoundingParams bI(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams OV(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams bJ(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean esE() {
        return this.psG;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.ptT == roundingParams.ptT && this.psL == roundingParams.psL && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.ptS == roundingParams.ptS && this.psG == roundingParams.psG) {
            return Arrays.equals(this.ptU, roundingParams.ptU);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.ptU != null ? Arrays.hashCode(this.ptU) : 0) + (((this.ptT ? 1 : 0) + ((this.ptS != null ? this.ptS.hashCode() : 0) * 31)) * 31)) * 31) + this.psL) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.psG ? 1 : 0);
    }
}
