package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class RoundingParams {
    private RoundingMethod ptT = RoundingMethod.BITMAP_ONLY;
    private boolean ptU = false;
    private float[] ptV = null;
    private int psM = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean psH = false;

    /* loaded from: classes3.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams AY(boolean z) {
        this.ptU = z;
        return this;
    }

    public boolean esz() {
        return this.ptU;
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
        return this.ptV;
    }

    public RoundingMethod esB() {
        return this.ptT;
    }

    public RoundingParams OU(@ColorInt int i) {
        this.psM = i;
        this.ptT = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int esC() {
        return this.psM;
    }

    private float[] esD() {
        if (this.ptV == null) {
            this.ptV = new float[8];
        }
        return this.ptV;
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
        return this.psH;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.ptU == roundingParams.ptU && this.psM == roundingParams.psM && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.ptT == roundingParams.ptT && this.psH == roundingParams.psH) {
            return Arrays.equals(this.ptV, roundingParams.ptV);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.ptV != null ? Arrays.hashCode(this.ptV) : 0) + (((this.ptU ? 1 : 0) + ((this.ptT != null ? this.ptT.hashCode() : 0) * 31)) * 31)) * 31) + this.psM) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.psH ? 1 : 0);
    }
}
