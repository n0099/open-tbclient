package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class RoundingParams {
    private RoundingMethod lMP = RoundingMethod.BITMAP_ONLY;
    private boolean lMQ = false;
    private float[] lMR = null;
    private int lLK = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean lLF = false;

    /* loaded from: classes12.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams vi(boolean z) {
        this.lMQ = z;
        return this;
    }

    public boolean dlL() {
        return this.lMQ;
    }

    public RoundingParams bp(float f) {
        Arrays.fill(dlP(), f);
        return this;
    }

    public RoundingParams n(float f, float f2, float f3, float f4) {
        float[] dlP = dlP();
        dlP[1] = f;
        dlP[0] = f;
        dlP[3] = f2;
        dlP[2] = f2;
        dlP[5] = f3;
        dlP[4] = f3;
        dlP[7] = f4;
        dlP[6] = f4;
        return this;
    }

    public float[] dlM() {
        return this.lMR;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.lMP = roundingMethod;
        return this;
    }

    public RoundingMethod dlN() {
        return this.lMP;
    }

    public RoundingParams HK(@ColorInt int i) {
        this.lLK = i;
        this.lMP = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dlO() {
        return this.lLK;
    }

    private float[] dlP() {
        if (this.lMR == null) {
            this.lMR = new float[8];
        }
        return this.lMR;
    }

    public static RoundingParams dlQ() {
        return new RoundingParams().vi(true);
    }

    public static RoundingParams o(float f, float f2, float f3, float f4) {
        return new RoundingParams().n(f, f2, f3, f4);
    }

    public RoundingParams bq(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams HL(@ColorInt int i) {
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

    public RoundingParams br(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dlR() {
        return this.lLF;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.lMQ == roundingParams.lMQ && this.lLK == roundingParams.lLK && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.lMP == roundingParams.lMP && this.lLF == roundingParams.lLF) {
            return Arrays.equals(this.lMR, roundingParams.lMR);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.lMR != null ? Arrays.hashCode(this.lMR) : 0) + (((this.lMQ ? 1 : 0) + ((this.lMP != null ? this.lMP.hashCode() : 0) * 31)) * 31)) * 31) + this.lLK) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.lLF ? 1 : 0);
    }
}
