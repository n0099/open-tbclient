package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class RoundingParams {
    private RoundingMethod nAl = RoundingMethod.BITMAP_ONLY;
    private boolean nAm = false;
    private float[] nAn = null;
    private int nzg = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean nza = false;

    /* loaded from: classes11.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams yk(boolean z) {
        this.nAm = z;
        return this;
    }

    public boolean dUV() {
        return this.nAm;
    }

    public RoundingParams aO(float f) {
        Arrays.fill(dUZ(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dUZ = dUZ();
        dUZ[1] = f;
        dUZ[0] = f;
        dUZ[3] = f2;
        dUZ[2] = f2;
        dUZ[5] = f3;
        dUZ[4] = f3;
        dUZ[7] = f4;
        dUZ[6] = f4;
        return this;
    }

    public float[] dUW() {
        return this.nAn;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.nAl = roundingMethod;
        return this;
    }

    public RoundingMethod dUX() {
        return this.nAl;
    }

    public RoundingParams LV(@ColorInt int i) {
        this.nzg = i;
        this.nAl = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dUY() {
        return this.nzg;
    }

    private float[] dUZ() {
        if (this.nAn == null) {
            this.nAn = new float[8];
        }
        return this.nAn;
    }

    public static RoundingParams dVa() {
        return new RoundingParams().yk(true);
    }

    public static RoundingParams i(float f, float f2, float f3, float f4) {
        return new RoundingParams().h(f, f2, f3, f4);
    }

    public RoundingParams aP(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams LW(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams o(@ColorInt int i, float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        this.mBorderColor = i;
        return this;
    }

    public RoundingParams aQ(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dVb() {
        return this.nza;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.nAm == roundingParams.nAm && this.nzg == roundingParams.nzg && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.nAl == roundingParams.nAl && this.nza == roundingParams.nza) {
            return Arrays.equals(this.nAn, roundingParams.nAn);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.nAn != null ? Arrays.hashCode(this.nAn) : 0) + (((this.nAm ? 1 : 0) + ((this.nAl != null ? this.nAl.hashCode() : 0) * 31)) * 31)) * 31) + this.nzg) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.nza ? 1 : 0);
    }
}
