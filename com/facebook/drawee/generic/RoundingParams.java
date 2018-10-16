package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod ibq = RoundingMethod.BITMAP_ONLY;
    private boolean ibr = false;
    private float[] ibs = null;
    private int iaE = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float iax = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams oG(boolean z) {
        this.ibr = z;
        return this;
    }

    public boolean bTN() {
        return this.ibr;
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
        return this.ibs;
    }

    public RoundingMethod bTP() {
        return this.ibq;
    }

    public RoundingParams xs(@ColorInt int i) {
        this.iaE = i;
        this.ibq = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int bTQ() {
        return this.iaE;
    }

    private float[] bTR() {
        if (this.ibs == null) {
            this.ibs = new float[8];
        }
        return this.ibs;
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
        this.iax = f;
        return this;
    }

    public float bTT() {
        return this.iax;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.ibr == roundingParams.ibr && this.iaE == roundingParams.iaE && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.iax, this.iax) == 0 && this.ibq == roundingParams.ibq) {
            return Arrays.equals(this.ibs, roundingParams.ibs);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.ibs != null ? Arrays.hashCode(this.ibs) : 0) + (((this.ibr ? 1 : 0) + ((this.ibq != null ? this.ibq.hashCode() : 0) * 31)) * 31)) * 31) + this.iaE) * 31)) * 31) + this.mBorderColor) * 31) + (this.iax != 0.0f ? Float.floatToIntBits(this.iax) : 0);
    }
}
