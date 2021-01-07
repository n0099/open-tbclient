package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class RoundingParams {
    private RoundingMethod pyt = RoundingMethod.BITMAP_ONLY;
    private boolean pyu = false;
    private float[] pyv = null;
    private int pxn = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean pxi = false;

    /* loaded from: classes4.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams Bc(boolean z) {
        this.pyu = z;
        return this;
    }

    public boolean ewr() {
        return this.pyu;
    }

    public RoundingParams bH(float f) {
        Arrays.fill(ewv(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] ewv = ewv();
        ewv[1] = f;
        ewv[0] = f;
        ewv[3] = f2;
        ewv[2] = f2;
        ewv[5] = f3;
        ewv[4] = f3;
        ewv[7] = f4;
        ewv[6] = f4;
        return this;
    }

    public float[] ews() {
        return this.pyv;
    }

    public RoundingMethod ewt() {
        return this.pyt;
    }

    public RoundingParams QB(@ColorInt int i) {
        this.pxn = i;
        this.pyt = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int ewu() {
        return this.pxn;
    }

    private float[] ewv() {
        if (this.pyv == null) {
            this.pyv = new float[8];
        }
        return this.pyv;
    }

    public RoundingParams bI(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams QC(@ColorInt int i) {
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

    public boolean eww() {
        return this.pxi;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.pyu == roundingParams.pyu && this.pxn == roundingParams.pxn && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.pyt == roundingParams.pyt && this.pxi == roundingParams.pxi) {
            return Arrays.equals(this.pyv, roundingParams.pyv);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.pyv != null ? Arrays.hashCode(this.pyv) : 0) + (((this.pyu ? 1 : 0) + ((this.pyt != null ? this.pyt.hashCode() : 0) * 31)) * 31)) * 31) + this.pxn) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.pxi ? 1 : 0);
    }
}
