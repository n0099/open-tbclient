package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod kdJ = RoundingMethod.BITMAP_ONLY;
    private boolean kdK = false;
    private float[] kdL = null;
    private int kcX = 0;
    private float mBorderWidth = 0.0f;
    private int GW = 0;
    private float kcR = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams sz(boolean z) {
        this.kdK = z;
        return this;
    }

    public boolean cGR() {
        return this.kdK;
    }

    public RoundingParams bc(float f) {
        Arrays.fill(cGV(), f);
        return this;
    }

    public RoundingParams l(float f, float f2, float f3, float f4) {
        float[] cGV = cGV();
        cGV[1] = f;
        cGV[0] = f;
        cGV[3] = f2;
        cGV[2] = f2;
        cGV[5] = f3;
        cGV[4] = f3;
        cGV[7] = f4;
        cGV[6] = f4;
        return this;
    }

    public float[] cGS() {
        return this.kdL;
    }

    public RoundingMethod cGT() {
        return this.kdJ;
    }

    public RoundingParams DL(@ColorInt int i) {
        this.kcX = i;
        this.kdJ = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cGU() {
        return this.kcX;
    }

    private float[] cGV() {
        if (this.kdL == null) {
            this.kdL = new float[8];
        }
        return this.kdL;
    }

    public RoundingParams bd(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cGW() {
        return this.mBorderWidth;
    }

    public RoundingParams DM(@ColorInt int i) {
        this.GW = i;
        return this;
    }

    public int getBorderColor() {
        return this.GW;
    }

    public RoundingParams be(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.kcR = f;
        return this;
    }

    public float cGX() {
        return this.kcR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.kdK == roundingParams.kdK && this.kcX == roundingParams.kcX && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.GW == roundingParams.GW && Float.compare(roundingParams.kcR, this.kcR) == 0 && this.kdJ == roundingParams.kdJ) {
            return Arrays.equals(this.kdL, roundingParams.kdL);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.kdL != null ? Arrays.hashCode(this.kdL) : 0) + (((this.kdK ? 1 : 0) + ((this.kdJ != null ? this.kdJ.hashCode() : 0) * 31)) * 31)) * 31) + this.kcX) * 31)) * 31) + this.GW) * 31) + (this.kcR != 0.0f ? Float.floatToIntBits(this.kcR) : 0);
    }
}
