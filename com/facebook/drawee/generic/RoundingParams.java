package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class RoundingParams {
    private RoundingMethod oRT = RoundingMethod.BITMAP_ONLY;
    private boolean oRU = false;
    private float[] oRV = null;
    private int oQO = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean oQJ = false;

    /* loaded from: classes14.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams Ar(boolean z) {
        this.oRU = z;
        return this;
    }

    public boolean emr() {
        return this.oRU;
    }

    public RoundingParams bu(float f) {
        Arrays.fill(emv(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] emv = emv();
        emv[1] = f;
        emv[0] = f;
        emv[3] = f2;
        emv[2] = f2;
        emv[5] = f3;
        emv[4] = f3;
        emv[7] = f4;
        emv[6] = f4;
        return this;
    }

    public float[] ems() {
        return this.oRV;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.oRT = roundingMethod;
        return this;
    }

    public RoundingMethod emt() {
        return this.oRT;
    }

    public RoundingParams Pq(@ColorInt int i) {
        this.oQO = i;
        this.oRT = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int emu() {
        return this.oQO;
    }

    private float[] emv() {
        if (this.oRV == null) {
            this.oRV = new float[8];
        }
        return this.oRV;
    }

    public static RoundingParams emw() {
        return new RoundingParams().Ar(true);
    }

    public static RoundingParams k(float f, float f2, float f3, float f4) {
        return new RoundingParams().j(f, f2, f3, f4);
    }

    public RoundingParams bv(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Pr(@ColorInt int i) {
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

    public RoundingParams bw(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean emx() {
        return this.oQJ;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.oRU == roundingParams.oRU && this.oQO == roundingParams.oQO && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.oRT == roundingParams.oRT && this.oQJ == roundingParams.oQJ) {
            return Arrays.equals(this.oRV, roundingParams.oRV);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.oRV != null ? Arrays.hashCode(this.oRV) : 0) + (((this.oRU ? 1 : 0) + ((this.oRT != null ? this.oRT.hashCode() : 0) * 31)) * 31)) * 31) + this.oQO) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.oQJ ? 1 : 0);
    }
}
