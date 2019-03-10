package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod jEB = RoundingMethod.BITMAP_ONLY;
    private boolean jEC = false;
    private float[] jED = null;
    private int jDP = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float jDI = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams ru(boolean z) {
        this.jEC = z;
        return this;
    }

    public boolean cvV() {
        return this.jEC;
    }

    public RoundingParams aX(float f) {
        Arrays.fill(cvZ(), f);
        return this;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] cvZ = cvZ();
        cvZ[1] = f;
        cvZ[0] = f;
        cvZ[3] = f2;
        cvZ[2] = f2;
        cvZ[5] = f3;
        cvZ[4] = f3;
        cvZ[7] = f4;
        cvZ[6] = f4;
        return this;
    }

    public float[] cvW() {
        return this.jED;
    }

    public RoundingMethod cvX() {
        return this.jEB;
    }

    public RoundingParams Ck(@ColorInt int i) {
        this.jDP = i;
        this.jEB = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cvY() {
        return this.jDP;
    }

    private float[] cvZ() {
        if (this.jED == null) {
            this.jED = new float[8];
        }
        return this.jED;
    }

    public RoundingParams aY(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cwa() {
        return this.mBorderWidth;
    }

    public RoundingParams Cl(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aZ(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.jDI = f;
        return this;
    }

    public float cwb() {
        return this.jDI;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.jEC == roundingParams.jEC && this.jDP == roundingParams.jDP && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.jDI, this.jDI) == 0 && this.jEB == roundingParams.jEB) {
            return Arrays.equals(this.jED, roundingParams.jED);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.jED != null ? Arrays.hashCode(this.jED) : 0) + (((this.jEC ? 1 : 0) + ((this.jEB != null ? this.jEB.hashCode() : 0) * 31)) * 31)) * 31) + this.jDP) * 31)) * 31) + this.mBorderColor) * 31) + (this.jDI != 0.0f ? Float.floatToIntBits(this.jDI) : 0);
    }
}
