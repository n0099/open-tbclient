package com.facebook.drawee.generic;

import androidx.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class RoundingParams {
    private RoundingMethod pEB = RoundingMethod.BITMAP_ONLY;
    private boolean pEC = false;
    private float[] pED = null;
    private int pDv = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean pDq = false;

    /* loaded from: classes15.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams Br(boolean z) {
        this.pEC = z;
        return this;
    }

    public boolean euZ() {
        return this.pEC;
    }

    public RoundingParams bK(float f) {
        Arrays.fill(evd(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] evd = evd();
        evd[1] = f;
        evd[0] = f;
        evd[3] = f2;
        evd[2] = f2;
        evd[5] = f3;
        evd[4] = f3;
        evd[7] = f4;
        evd[6] = f4;
        return this;
    }

    public float[] eva() {
        return this.pED;
    }

    public RoundingMethod evb() {
        return this.pEB;
    }

    public RoundingParams Pq(@ColorInt int i) {
        this.pDv = i;
        this.pEB = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int evc() {
        return this.pDv;
    }

    private float[] evd() {
        if (this.pED == null) {
            this.pED = new float[8];
        }
        return this.pED;
    }

    public RoundingParams bL(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Pr(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams bM(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean eve() {
        return this.pDq;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.pEC == roundingParams.pEC && this.pDv == roundingParams.pDv && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.pEB == roundingParams.pEB && this.pDq == roundingParams.pDq) {
            return Arrays.equals(this.pED, roundingParams.pED);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.pED != null ? Arrays.hashCode(this.pED) : 0) + (((this.pEC ? 1 : 0) + ((this.pEB != null ? this.pEB.hashCode() : 0) * 31)) * 31)) * 31) + this.pDv) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.pDq ? 1 : 0);
    }
}
