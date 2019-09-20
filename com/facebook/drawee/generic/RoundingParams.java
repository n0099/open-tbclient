package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod khn = RoundingMethod.BITMAP_ONLY;
    private boolean kho = false;
    private float[] khp = null;
    private int kgB = 0;
    private float mBorderWidth = 0.0f;
    private int GW = 0;
    private float kgv = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams sD(boolean z) {
        this.kho = z;
        return this;
    }

    public boolean cIa() {
        return this.kho;
    }

    public RoundingParams bd(float f) {
        Arrays.fill(cIe(), f);
        return this;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] cIe = cIe();
        cIe[1] = f;
        cIe[0] = f;
        cIe[3] = f2;
        cIe[2] = f2;
        cIe[5] = f3;
        cIe[4] = f3;
        cIe[7] = f4;
        cIe[6] = f4;
        return this;
    }

    public float[] cIb() {
        return this.khp;
    }

    public RoundingMethod cIc() {
        return this.khn;
    }

    public RoundingParams DR(@ColorInt int i) {
        this.kgB = i;
        this.khn = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cId() {
        return this.kgB;
    }

    private float[] cIe() {
        if (this.khp == null) {
            this.khp = new float[8];
        }
        return this.khp;
    }

    public RoundingParams be(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cIf() {
        return this.mBorderWidth;
    }

    public RoundingParams DS(@ColorInt int i) {
        this.GW = i;
        return this;
    }

    public int getBorderColor() {
        return this.GW;
    }

    public RoundingParams bf(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.kgv = f;
        return this;
    }

    public float cIg() {
        return this.kgv;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.kho == roundingParams.kho && this.kgB == roundingParams.kgB && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.GW == roundingParams.GW && Float.compare(roundingParams.kgv, this.kgv) == 0 && this.khn == roundingParams.khn) {
            return Arrays.equals(this.khp, roundingParams.khp);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.khp != null ? Arrays.hashCode(this.khp) : 0) + (((this.kho ? 1 : 0) + ((this.khn != null ? this.khn.hashCode() : 0) * 31)) * 31)) * 31) + this.kgB) * 31)) * 31) + this.GW) * 31) + (this.kgv != 0.0f ? Float.floatToIntBits(this.kgv) : 0);
    }
}
