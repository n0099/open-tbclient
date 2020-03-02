package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class RoundingParams {
    private RoundingMethod lNy = RoundingMethod.BITMAP_ONLY;
    private boolean lNz = false;
    private float[] lNA = null;
    private int lMt = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean lMo = false;

    /* loaded from: classes13.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams vm(boolean z) {
        this.lNz = z;
        return this;
    }

    public boolean dmZ() {
        return this.lNz;
    }

    public RoundingParams bo(float f) {
        Arrays.fill(dnd(), f);
        return this;
    }

    public RoundingParams n(float f, float f2, float f3, float f4) {
        float[] dnd = dnd();
        dnd[1] = f;
        dnd[0] = f;
        dnd[3] = f2;
        dnd[2] = f2;
        dnd[5] = f3;
        dnd[4] = f3;
        dnd[7] = f4;
        dnd[6] = f4;
        return this;
    }

    public float[] dna() {
        return this.lNA;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.lNy = roundingMethod;
        return this;
    }

    public RoundingMethod dnb() {
        return this.lNy;
    }

    public RoundingParams HP(@ColorInt int i) {
        this.lMt = i;
        this.lNy = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dnc() {
        return this.lMt;
    }

    private float[] dnd() {
        if (this.lNA == null) {
            this.lNA = new float[8];
        }
        return this.lNA;
    }

    public static RoundingParams dne() {
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

    public boolean dnf() {
        return this.lMo;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.lNz == roundingParams.lNz && this.lMt == roundingParams.lMt && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.lNy == roundingParams.lNy && this.lMo == roundingParams.lMo) {
            return Arrays.equals(this.lNA, roundingParams.lNA);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.lNA != null ? Arrays.hashCode(this.lNA) : 0) + (((this.lNz ? 1 : 0) + ((this.lNy != null ? this.lNy.hashCode() : 0) * 31)) * 31)) * 31) + this.lMt) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.lMo ? 1 : 0);
    }
}
