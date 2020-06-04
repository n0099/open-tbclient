package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod mrT = RoundingMethod.BITMAP_ONLY;
    private boolean mrU = false;
    private float[] mrV = null;
    private int mqO = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mqH = 0.0f;
    private boolean mqI = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams wh(boolean z) {
        this.mrU = z;
        return this;
    }

    public boolean dwV() {
        return this.mrU;
    }

    public RoundingParams aD(float f) {
        Arrays.fill(dwZ(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dwZ = dwZ();
        dwZ[1] = f;
        dwZ[0] = f;
        dwZ[3] = f2;
        dwZ[2] = f2;
        dwZ[5] = f3;
        dwZ[4] = f3;
        dwZ[7] = f4;
        dwZ[6] = f4;
        return this;
    }

    public float[] dwW() {
        return this.mrV;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.mrT = roundingMethod;
        return this;
    }

    public RoundingMethod dwX() {
        return this.mrT;
    }

    public RoundingParams Hk(@ColorInt int i) {
        this.mqO = i;
        this.mrT = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dwY() {
        return this.mqO;
    }

    private float[] dwZ() {
        if (this.mrV == null) {
            this.mrV = new float[8];
        }
        return this.mrV;
    }

    public static RoundingParams dxa() {
        return new RoundingParams().wh(true);
    }

    public static RoundingParams i(float f, float f2, float f3, float f4) {
        return new RoundingParams().h(f, f2, f3, f4);
    }

    public RoundingParams aE(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Hl(@ColorInt int i) {
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

    public RoundingParams aF(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mqH = f;
        return this;
    }

    public float dxb() {
        return this.mqH;
    }

    public boolean dxc() {
        return this.mqI;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mrU == roundingParams.mrU && this.mqO == roundingParams.mqO && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mqH, this.mqH) == 0 && this.mrT == roundingParams.mrT && this.mqI == roundingParams.mqI) {
            return Arrays.equals(this.mrV, roundingParams.mrV);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mqH != 0.0f ? Float.floatToIntBits(this.mqH) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.mrV != null ? Arrays.hashCode(this.mrV) : 0) + (((this.mrU ? 1 : 0) + ((this.mrT != null ? this.mrT.hashCode() : 0) * 31)) * 31)) * 31) + this.mqO) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.mqI ? 1 : 0);
    }
}
