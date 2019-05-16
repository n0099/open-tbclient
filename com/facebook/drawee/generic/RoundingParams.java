package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod jWB = RoundingMethod.BITMAP_ONLY;
    private boolean jWC = false;
    private float[] jWD = null;
    private int jVP = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float jVJ = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams sj(boolean z) {
        this.jWC = z;
        return this;
    }

    public boolean cDN() {
        return this.jWC;
    }

    public RoundingParams bb(float f) {
        Arrays.fill(cDR(), f);
        return this;
    }

    public RoundingParams l(float f, float f2, float f3, float f4) {
        float[] cDR = cDR();
        cDR[1] = f;
        cDR[0] = f;
        cDR[3] = f2;
        cDR[2] = f2;
        cDR[5] = f3;
        cDR[4] = f3;
        cDR[7] = f4;
        cDR[6] = f4;
        return this;
    }

    public float[] cDO() {
        return this.jWD;
    }

    public RoundingMethod cDP() {
        return this.jWB;
    }

    public RoundingParams De(@ColorInt int i) {
        this.jVP = i;
        this.jWB = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cDQ() {
        return this.jVP;
    }

    private float[] cDR() {
        if (this.jWD == null) {
            this.jWD = new float[8];
        }
        return this.jWD;
    }

    public RoundingParams bc(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cDS() {
        return this.mBorderWidth;
    }

    public RoundingParams Df(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams bd(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.jVJ = f;
        return this;
    }

    public float cDT() {
        return this.jVJ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.jWC == roundingParams.jWC && this.jVP == roundingParams.jVP && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.jVJ, this.jVJ) == 0 && this.jWB == roundingParams.jWB) {
            return Arrays.equals(this.jWD, roundingParams.jWD);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.jWD != null ? Arrays.hashCode(this.jWD) : 0) + (((this.jWC ? 1 : 0) + ((this.jWB != null ? this.jWB.hashCode() : 0) * 31)) * 31)) * 31) + this.jVP) * 31)) * 31) + this.mBorderColor) * 31) + (this.jVJ != 0.0f ? Float.floatToIntBits(this.jVJ) : 0);
    }
}
