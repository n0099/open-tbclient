package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod lNw = RoundingMethod.BITMAP_ONLY;
    private boolean lNx = false;
    private float[] lNy = null;
    private int lMr = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean lMm = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams vm(boolean z) {
        this.lNx = z;
        return this;
    }

    public boolean dmX() {
        return this.lNx;
    }

    public RoundingParams bo(float f) {
        Arrays.fill(dnb(), f);
        return this;
    }

    public RoundingParams n(float f, float f2, float f3, float f4) {
        float[] dnb = dnb();
        dnb[1] = f;
        dnb[0] = f;
        dnb[3] = f2;
        dnb[2] = f2;
        dnb[5] = f3;
        dnb[4] = f3;
        dnb[7] = f4;
        dnb[6] = f4;
        return this;
    }

    public float[] dmY() {
        return this.lNy;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.lNw = roundingMethod;
        return this;
    }

    public RoundingMethod dmZ() {
        return this.lNw;
    }

    public RoundingParams HP(@ColorInt int i) {
        this.lMr = i;
        this.lNw = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dna() {
        return this.lMr;
    }

    private float[] dnb() {
        if (this.lNy == null) {
            this.lNy = new float[8];
        }
        return this.lNy;
    }

    public static RoundingParams dnc() {
        return new RoundingParams().vm(true);
    }

    public static RoundingParams o(float f, float f2, float f3, float f4) {
        return new RoundingParams().n(f, f2, f3, f4);
    }

    public RoundingParams bp(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams HQ(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams q(@ColorInt int i, float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        this.mBorderColor = i;
        return this;
    }

    public RoundingParams bq(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dnd() {
        return this.lMm;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.lNx == roundingParams.lNx && this.lMr == roundingParams.lMr && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.lNw == roundingParams.lNw && this.lMm == roundingParams.lMm) {
            return Arrays.equals(this.lNy, roundingParams.lNy);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.lNy != null ? Arrays.hashCode(this.lNy) : 0) + (((this.lNx ? 1 : 0) + ((this.lNw != null ? this.lNw.hashCode() : 0) * 31)) * 31)) * 31) + this.lMr) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.lMm ? 1 : 0);
    }
}
