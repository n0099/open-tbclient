package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod jWC = RoundingMethod.BITMAP_ONLY;
    private boolean jWD = false;
    private float[] jWE = null;
    private int jVQ = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float jVK = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams sj(boolean z) {
        this.jWD = z;
        return this;
    }

    public boolean cDP() {
        return this.jWD;
    }

    public RoundingParams bb(float f) {
        Arrays.fill(cDT(), f);
        return this;
    }

    public RoundingParams l(float f, float f2, float f3, float f4) {
        float[] cDT = cDT();
        cDT[1] = f;
        cDT[0] = f;
        cDT[3] = f2;
        cDT[2] = f2;
        cDT[5] = f3;
        cDT[4] = f3;
        cDT[7] = f4;
        cDT[6] = f4;
        return this;
    }

    public float[] cDQ() {
        return this.jWE;
    }

    public RoundingMethod cDR() {
        return this.jWC;
    }

    public RoundingParams De(@ColorInt int i) {
        this.jVQ = i;
        this.jWC = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cDS() {
        return this.jVQ;
    }

    private float[] cDT() {
        if (this.jWE == null) {
            this.jWE = new float[8];
        }
        return this.jWE;
    }

    public RoundingParams bc(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cDU() {
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
        this.jVK = f;
        return this;
    }

    public float cDV() {
        return this.jVK;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.jWD == roundingParams.jWD && this.jVQ == roundingParams.jVQ && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.jVK, this.jVK) == 0 && this.jWC == roundingParams.jWC) {
            return Arrays.equals(this.jWE, roundingParams.jWE);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.jWE != null ? Arrays.hashCode(this.jWE) : 0) + (((this.jWD ? 1 : 0) + ((this.jWC != null ? this.jWC.hashCode() : 0) * 31)) * 31)) * 31) + this.jVQ) * 31)) * 31) + this.mBorderColor) * 31) + (this.jVK != 0.0f ? Float.floatToIntBits(this.jVK) : 0);
    }
}
