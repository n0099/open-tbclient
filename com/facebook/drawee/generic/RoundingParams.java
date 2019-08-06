package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod keQ = RoundingMethod.BITMAP_ONLY;
    private boolean keR = false;
    private float[] keS = null;
    private int ked = 0;
    private float mBorderWidth = 0.0f;
    private int GW = 0;
    private float kdX = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams sA(boolean z) {
        this.keR = z;
        return this;
    }

    public boolean cHm() {
        return this.keR;
    }

    public RoundingParams bc(float f) {
        Arrays.fill(cHq(), f);
        return this;
    }

    public RoundingParams l(float f, float f2, float f3, float f4) {
        float[] cHq = cHq();
        cHq[1] = f;
        cHq[0] = f;
        cHq[3] = f2;
        cHq[2] = f2;
        cHq[5] = f3;
        cHq[4] = f3;
        cHq[7] = f4;
        cHq[6] = f4;
        return this;
    }

    public float[] cHn() {
        return this.keS;
    }

    public RoundingMethod cHo() {
        return this.keQ;
    }

    public RoundingParams DN(@ColorInt int i) {
        this.ked = i;
        this.keQ = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cHp() {
        return this.ked;
    }

    private float[] cHq() {
        if (this.keS == null) {
            this.keS = new float[8];
        }
        return this.keS;
    }

    public RoundingParams bd(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cHr() {
        return this.mBorderWidth;
    }

    public RoundingParams DO(@ColorInt int i) {
        this.GW = i;
        return this;
    }

    public int getBorderColor() {
        return this.GW;
    }

    public RoundingParams be(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.kdX = f;
        return this;
    }

    public float cHs() {
        return this.kdX;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.keR == roundingParams.keR && this.ked == roundingParams.ked && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.GW == roundingParams.GW && Float.compare(roundingParams.kdX, this.kdX) == 0 && this.keQ == roundingParams.keQ) {
            return Arrays.equals(this.keS, roundingParams.keS);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.keS != null ? Arrays.hashCode(this.keS) : 0) + (((this.keR ? 1 : 0) + ((this.keQ != null ? this.keQ.hashCode() : 0) * 31)) * 31)) * 31) + this.ked) * 31)) * 31) + this.GW) * 31) + (this.kdX != 0.0f ? Float.floatToIntBits(this.kdX) : 0);
    }
}
