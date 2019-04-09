package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod jDO = RoundingMethod.BITMAP_ONLY;
    private boolean jDP = false;
    private float[] jDQ = null;
    private int jDc = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float jCV = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams ru(boolean z) {
        this.jDP = z;
        return this;
    }

    public boolean cvR() {
        return this.jDP;
    }

    public RoundingParams aX(float f) {
        Arrays.fill(cvV(), f);
        return this;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] cvV = cvV();
        cvV[1] = f;
        cvV[0] = f;
        cvV[3] = f2;
        cvV[2] = f2;
        cvV[5] = f3;
        cvV[4] = f3;
        cvV[7] = f4;
        cvV[6] = f4;
        return this;
    }

    public float[] cvS() {
        return this.jDQ;
    }

    public RoundingMethod cvT() {
        return this.jDO;
    }

    public RoundingParams Ca(@ColorInt int i) {
        this.jDc = i;
        this.jDO = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cvU() {
        return this.jDc;
    }

    private float[] cvV() {
        if (this.jDQ == null) {
            this.jDQ = new float[8];
        }
        return this.jDQ;
    }

    public RoundingParams aY(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cvW() {
        return this.mBorderWidth;
    }

    public RoundingParams Cb(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aZ(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.jCV = f;
        return this;
    }

    public float cvX() {
        return this.jCV;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.jDP == roundingParams.jDP && this.jDc == roundingParams.jDc && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.jCV, this.jCV) == 0 && this.jDO == roundingParams.jDO) {
            return Arrays.equals(this.jDQ, roundingParams.jDQ);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.jDQ != null ? Arrays.hashCode(this.jDQ) : 0) + (((this.jDP ? 1 : 0) + ((this.jDO != null ? this.jDO.hashCode() : 0) * 31)) * 31)) * 31) + this.jDc) * 31)) * 31) + this.mBorderColor) * 31) + (this.jCV != 0.0f ? Float.floatToIntBits(this.jCV) : 0);
    }
}
