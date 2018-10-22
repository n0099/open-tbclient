package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod ibr = RoundingMethod.BITMAP_ONLY;
    private boolean ibs = false;
    private float[] ibt = null;
    private int iaF = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float iay = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams oG(boolean z) {
        this.ibs = z;
        return this;
    }

    public boolean bTN() {
        return this.ibs;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] bTR = bTR();
        bTR[1] = f;
        bTR[0] = f;
        bTR[3] = f2;
        bTR[2] = f2;
        bTR[5] = f3;
        bTR[4] = f3;
        bTR[7] = f4;
        bTR[6] = f4;
        return this;
    }

    public float[] bTO() {
        return this.ibt;
    }

    public RoundingMethod bTP() {
        return this.ibr;
    }

    public RoundingParams xs(@ColorInt int i) {
        this.iaF = i;
        this.ibr = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int bTQ() {
        return this.iaF;
    }

    private float[] bTR() {
        if (this.ibt == null) {
            this.ibt = new float[8];
        }
        return this.ibt;
    }

    public RoundingParams aI(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float bTS() {
        return this.mBorderWidth;
    }

    public RoundingParams xt(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aJ(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.iay = f;
        return this;
    }

    public float bTT() {
        return this.iay;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.ibs == roundingParams.ibs && this.iaF == roundingParams.iaF && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.iay, this.iay) == 0 && this.ibr == roundingParams.ibr) {
            return Arrays.equals(this.ibt, roundingParams.ibt);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.ibt != null ? Arrays.hashCode(this.ibt) : 0) + (((this.ibs ? 1 : 0) + ((this.ibr != null ? this.ibr.hashCode() : 0) * 31)) * 31)) * 31) + this.iaF) * 31)) * 31) + this.mBorderColor) * 31) + (this.iay != 0.0f ? Float.floatToIntBits(this.iay) : 0);
    }
}
