package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod jWF = RoundingMethod.BITMAP_ONLY;
    private boolean jWG = false;
    private float[] jWH = null;
    private int jVT = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float jVN = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams sk(boolean z) {
        this.jWG = z;
        return this;
    }

    public boolean cDO() {
        return this.jWG;
    }

    public RoundingParams bb(float f) {
        Arrays.fill(cDS(), f);
        return this;
    }

    public RoundingParams l(float f, float f2, float f3, float f4) {
        float[] cDS = cDS();
        cDS[1] = f;
        cDS[0] = f;
        cDS[3] = f2;
        cDS[2] = f2;
        cDS[5] = f3;
        cDS[4] = f3;
        cDS[7] = f4;
        cDS[6] = f4;
        return this;
    }

    public float[] cDP() {
        return this.jWH;
    }

    public RoundingMethod cDQ() {
        return this.jWF;
    }

    public RoundingParams De(@ColorInt int i) {
        this.jVT = i;
        this.jWF = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cDR() {
        return this.jVT;
    }

    private float[] cDS() {
        if (this.jWH == null) {
            this.jWH = new float[8];
        }
        return this.jWH;
    }

    public RoundingParams bc(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cDT() {
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
        this.jVN = f;
        return this;
    }

    public float cDU() {
        return this.jVN;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.jWG == roundingParams.jWG && this.jVT == roundingParams.jVT && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.jVN, this.jVN) == 0 && this.jWF == roundingParams.jWF) {
            return Arrays.equals(this.jWH, roundingParams.jWH);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.jWH != null ? Arrays.hashCode(this.jWH) : 0) + (((this.jWG ? 1 : 0) + ((this.jWF != null ? this.jWF.hashCode() : 0) * 31)) * 31)) * 31) + this.jVT) * 31)) * 31) + this.mBorderColor) * 31) + (this.jVN != 0.0f ? Float.floatToIntBits(this.jVN) : 0);
    }
}
