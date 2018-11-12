package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod idb = RoundingMethod.BITMAP_ONLY;
    private boolean idc = false;
    private float[] idd = null;
    private int icp = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float ici = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams oU(boolean z) {
        this.idc = z;
        return this;
    }

    public boolean bTi() {
        return this.idc;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] bTm = bTm();
        bTm[1] = f;
        bTm[0] = f;
        bTm[3] = f2;
        bTm[2] = f2;
        bTm[5] = f3;
        bTm[4] = f3;
        bTm[7] = f4;
        bTm[6] = f4;
        return this;
    }

    public float[] bTj() {
        return this.idd;
    }

    public RoundingMethod bTk() {
        return this.idb;
    }

    public RoundingParams xL(@ColorInt int i) {
        this.icp = i;
        this.idb = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int bTl() {
        return this.icp;
    }

    private float[] bTm() {
        if (this.idd == null) {
            this.idd = new float[8];
        }
        return this.idd;
    }

    public RoundingParams aK(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float bTn() {
        return this.mBorderWidth;
    }

    public RoundingParams xM(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aL(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.ici = f;
        return this;
    }

    public float bTo() {
        return this.ici;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.idc == roundingParams.idc && this.icp == roundingParams.icp && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.ici, this.ici) == 0 && this.idb == roundingParams.idb) {
            return Arrays.equals(this.idd, roundingParams.idd);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.idd != null ? Arrays.hashCode(this.idd) : 0) + (((this.idc ? 1 : 0) + ((this.idb != null ? this.idb.hashCode() : 0) * 31)) * 31)) * 31) + this.icp) * 31)) * 31) + this.mBorderColor) * 31) + (this.ici != 0.0f ? Float.floatToIntBits(this.ici) : 0);
    }
}
