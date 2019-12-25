package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class RoundingParams {
    private RoundingMethod lJn = RoundingMethod.BITMAP_ONLY;
    private boolean lJo = false;
    private float[] lJp = null;
    private int lIh = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean lIc = false;

    /* loaded from: classes11.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams uW(boolean z) {
        this.lJo = z;
        return this;
    }

    public boolean dkI() {
        return this.lJo;
    }

    public RoundingParams bq(float f) {
        Arrays.fill(dkM(), f);
        return this;
    }

    public RoundingParams n(float f, float f2, float f3, float f4) {
        float[] dkM = dkM();
        dkM[1] = f;
        dkM[0] = f;
        dkM[3] = f2;
        dkM[2] = f2;
        dkM[5] = f3;
        dkM[4] = f3;
        dkM[7] = f4;
        dkM[6] = f4;
        return this;
    }

    public float[] dkJ() {
        return this.lJp;
    }

    public RoundingMethod dkK() {
        return this.lJn;
    }

    public RoundingParams HC(@ColorInt int i) {
        this.lIh = i;
        this.lJn = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dkL() {
        return this.lIh;
    }

    private float[] dkM() {
        if (this.lJp == null) {
            this.lJp = new float[8];
        }
        return this.lJp;
    }

    public RoundingParams br(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams HD(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams bs(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dkN() {
        return this.lIc;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.lJo == roundingParams.lJo && this.lIh == roundingParams.lIh && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.lJn == roundingParams.lJn && this.lIc == roundingParams.lIc) {
            return Arrays.equals(this.lJp, roundingParams.lJp);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.lJp != null ? Arrays.hashCode(this.lJp) : 0) + (((this.lJo ? 1 : 0) + ((this.lJn != null ? this.lJn.hashCode() : 0) * 31)) * 31)) * 31) + this.lIh) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.lIc ? 1 : 0);
    }
}
