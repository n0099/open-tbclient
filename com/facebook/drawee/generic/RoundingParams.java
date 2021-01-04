package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class RoundingParams {
    private RoundingMethod pym = RoundingMethod.BITMAP_ONLY;
    private boolean pyn = false;
    private float[] pyo = null;
    private int pxg = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean pxb = false;

    /* loaded from: classes15.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams Bc(boolean z) {
        this.pyn = z;
        return this;
    }

    public boolean ewk() {
        return this.pyn;
    }

    public RoundingParams bH(float f) {
        Arrays.fill(ewo(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] ewo = ewo();
        ewo[1] = f;
        ewo[0] = f;
        ewo[3] = f2;
        ewo[2] = f2;
        ewo[5] = f3;
        ewo[4] = f3;
        ewo[7] = f4;
        ewo[6] = f4;
        return this;
    }

    public float[] ewl() {
        return this.pyo;
    }

    public RoundingMethod ewm() {
        return this.pym;
    }

    public RoundingParams Qw(@ColorInt int i) {
        this.pxg = i;
        this.pym = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int ewn() {
        return this.pxg;
    }

    private float[] ewo() {
        if (this.pyo == null) {
            this.pyo = new float[8];
        }
        return this.pyo;
    }

    public RoundingParams bI(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Qx(@ColorInt int i) {
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

    public boolean ewp() {
        return this.pxb;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.pyn == roundingParams.pyn && this.pxg == roundingParams.pxg && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.pym == roundingParams.pym && this.pxb == roundingParams.pxb) {
            return Arrays.equals(this.pyo, roundingParams.pyo);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.pyo != null ? Arrays.hashCode(this.pyo) : 0) + (((this.pyn ? 1 : 0) + ((this.pym != null ? this.pym.hashCode() : 0) * 31)) * 31)) * 31) + this.pxg) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.pxb ? 1 : 0);
    }
}
