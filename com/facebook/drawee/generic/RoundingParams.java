package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod jEt = RoundingMethod.BITMAP_ONLY;
    private boolean jEu = false;
    private float[] jEv = null;
    private int jDH = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float jDA = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams ru(boolean z) {
        this.jEu = z;
        return this;
    }

    public boolean cvY() {
        return this.jEu;
    }

    public RoundingParams aX(float f) {
        Arrays.fill(cwc(), f);
        return this;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] cwc = cwc();
        cwc[1] = f;
        cwc[0] = f;
        cwc[3] = f2;
        cwc[2] = f2;
        cwc[5] = f3;
        cwc[4] = f3;
        cwc[7] = f4;
        cwc[6] = f4;
        return this;
    }

    public float[] cvZ() {
        return this.jEv;
    }

    public RoundingMethod cwa() {
        return this.jEt;
    }

    public RoundingParams Ck(@ColorInt int i) {
        this.jDH = i;
        this.jEt = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cwb() {
        return this.jDH;
    }

    private float[] cwc() {
        if (this.jEv == null) {
            this.jEv = new float[8];
        }
        return this.jEv;
    }

    public RoundingParams aY(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cwd() {
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
        this.jDA = f;
        return this;
    }

    public float cwe() {
        return this.jDA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.jEu == roundingParams.jEu && this.jDH == roundingParams.jDH && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.jDA, this.jDA) == 0 && this.jEt == roundingParams.jEt) {
            return Arrays.equals(this.jEv, roundingParams.jEv);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.jEv != null ? Arrays.hashCode(this.jEv) : 0) + (((this.jEu ? 1 : 0) + ((this.jEt != null ? this.jEt.hashCode() : 0) * 31)) * 31)) * 31) + this.jDH) * 31)) * 31) + this.mBorderColor) * 31) + (this.jDA != 0.0f ? Float.floatToIntBits(this.jDA) : 0);
    }
}
