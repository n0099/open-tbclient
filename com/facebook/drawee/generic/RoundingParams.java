package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod mqJ = RoundingMethod.BITMAP_ONLY;
    private boolean mqK = false;
    private float[] mqL = null;
    private int mpE = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mpx = 0.0f;
    private boolean mpy = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams wf(boolean z) {
        this.mqK = z;
        return this;
    }

    public boolean dwH() {
        return this.mqK;
    }

    public RoundingParams aD(float f) {
        Arrays.fill(dwL(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dwL = dwL();
        dwL[1] = f;
        dwL[0] = f;
        dwL[3] = f2;
        dwL[2] = f2;
        dwL[5] = f3;
        dwL[4] = f3;
        dwL[7] = f4;
        dwL[6] = f4;
        return this;
    }

    public float[] dwI() {
        return this.mqL;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.mqJ = roundingMethod;
        return this;
    }

    public RoundingMethod dwJ() {
        return this.mqJ;
    }

    public RoundingParams Hi(@ColorInt int i) {
        this.mpE = i;
        this.mqJ = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dwK() {
        return this.mpE;
    }

    private float[] dwL() {
        if (this.mqL == null) {
            this.mqL = new float[8];
        }
        return this.mqL;
    }

    public static RoundingParams dwM() {
        return new RoundingParams().wf(true);
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

    public RoundingParams Hj(@ColorInt int i) {
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
        this.mpx = f;
        return this;
    }

    public float dwN() {
        return this.mpx;
    }

    public boolean dwO() {
        return this.mpy;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mqK == roundingParams.mqK && this.mpE == roundingParams.mpE && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mpx, this.mpx) == 0 && this.mqJ == roundingParams.mqJ && this.mpy == roundingParams.mpy) {
            return Arrays.equals(this.mqL, roundingParams.mqL);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mpx != 0.0f ? Float.floatToIntBits(this.mpx) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.mqL != null ? Arrays.hashCode(this.mqL) : 0) + (((this.mqK ? 1 : 0) + ((this.mqJ != null ? this.mqJ.hashCode() : 0) * 31)) * 31)) * 31) + this.mpE) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.mpy ? 1 : 0);
    }
}
