package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod inA = RoundingMethod.BITMAP_ONLY;
    private boolean inB = false;
    private float[] inC = null;
    private int imN = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float imG = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams oZ(boolean z) {
        this.inB = z;
        return this;
    }

    public boolean bWe() {
        return this.inB;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] bWi = bWi();
        bWi[1] = f;
        bWi[0] = f;
        bWi[3] = f2;
        bWi[2] = f2;
        bWi[5] = f3;
        bWi[4] = f3;
        bWi[7] = f4;
        bWi[6] = f4;
        return this;
    }

    public float[] bWf() {
        return this.inC;
    }

    public RoundingMethod bWg() {
        return this.inA;
    }

    public RoundingParams yv(@ColorInt int i) {
        this.imN = i;
        this.inA = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int bWh() {
        return this.imN;
    }

    private float[] bWi() {
        if (this.inC == null) {
            this.inC = new float[8];
        }
        return this.inC;
    }

    public RoundingParams aK(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float bWj() {
        return this.mBorderWidth;
    }

    public RoundingParams yw(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aL(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.imG = f;
        return this;
    }

    public float bWk() {
        return this.imG;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.inB == roundingParams.inB && this.imN == roundingParams.imN && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.imG, this.imG) == 0 && this.inA == roundingParams.inA) {
            return Arrays.equals(this.inC, roundingParams.inC);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.inC != null ? Arrays.hashCode(this.inC) : 0) + (((this.inB ? 1 : 0) + ((this.inA != null ? this.inA.hashCode() : 0) * 31)) * 31)) * 31) + this.imN) * 31)) * 31) + this.mBorderColor) * 31) + (this.imG != 0.0f ? Float.floatToIntBits(this.imG) : 0);
    }
}
