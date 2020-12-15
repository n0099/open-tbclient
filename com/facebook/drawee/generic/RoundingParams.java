package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class RoundingParams {
    private RoundingMethod phe = RoundingMethod.BITMAP_ONLY;
    private boolean phf = false;
    private float[] phg = null;
    private int pfY = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean pfT = false;

    /* loaded from: classes8.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams AU(boolean z) {
        this.phf = z;
        return this;
    }

    public boolean esh() {
        return this.phf;
    }

    public RoundingParams bv(float f) {
        Arrays.fill(esl(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] esl = esl();
        esl[1] = f;
        esl[0] = f;
        esl[3] = f2;
        esl[2] = f2;
        esl[5] = f3;
        esl[4] = f3;
        esl[7] = f4;
        esl[6] = f4;
        return this;
    }

    public float[] esi() {
        return this.phg;
    }

    public RoundingMethod esj() {
        return this.phe;
    }

    public RoundingParams Qn(@ColorInt int i) {
        this.pfY = i;
        this.phe = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int esk() {
        return this.pfY;
    }

    private float[] esl() {
        if (this.phg == null) {
            this.phg = new float[8];
        }
        return this.phg;
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

    public boolean esm() {
        return this.pfT;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.phf == roundingParams.phf && this.pfY == roundingParams.pfY && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.phe == roundingParams.phe && this.pfT == roundingParams.pfT) {
            return Arrays.equals(this.phg, roundingParams.phg);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.phg != null ? Arrays.hashCode(this.phg) : 0) + (((this.phf ? 1 : 0) + ((this.phe != null ? this.phe.hashCode() : 0) * 31)) * 31)) * 31) + this.pfY) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.pfT ? 1 : 0);
    }
}
