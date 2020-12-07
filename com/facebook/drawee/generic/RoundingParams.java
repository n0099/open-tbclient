package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class RoundingParams {
    private RoundingMethod phc = RoundingMethod.BITMAP_ONLY;
    private boolean phd = false;
    private float[] phe = null;
    private int pfW = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean pfR = false;

    /* loaded from: classes8.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams AU(boolean z) {
        this.phd = z;
        return this;
    }

    public boolean esg() {
        return this.phd;
    }

    public RoundingParams bv(float f) {
        Arrays.fill(esk(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] esk = esk();
        esk[1] = f;
        esk[0] = f;
        esk[3] = f2;
        esk[2] = f2;
        esk[5] = f3;
        esk[4] = f3;
        esk[7] = f4;
        esk[6] = f4;
        return this;
    }

    public float[] esh() {
        return this.phe;
    }

    public RoundingMethod esi() {
        return this.phc;
    }

    public RoundingParams Qn(@ColorInt int i) {
        this.pfW = i;
        this.phc = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int esj() {
        return this.pfW;
    }

    private float[] esk() {
        if (this.phe == null) {
            this.phe = new float[8];
        }
        return this.phe;
    }

    public RoundingParams bw(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Qo(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams bx(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean esl() {
        return this.pfR;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.phd == roundingParams.phd && this.pfW == roundingParams.pfW && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.phc == roundingParams.phc && this.pfR == roundingParams.pfR) {
            return Arrays.equals(this.phe, roundingParams.phe);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.phe != null ? Arrays.hashCode(this.phe) : 0) + (((this.phd ? 1 : 0) + ((this.phc != null ? this.phc.hashCode() : 0) * 31)) * 31)) * 31) + this.pfW) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.pfR ? 1 : 0);
    }
}
