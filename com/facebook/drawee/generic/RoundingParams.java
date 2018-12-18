package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod iko = RoundingMethod.BITMAP_ONLY;
    private boolean ikp = false;
    private float[] ikq = null;
    private int ijC = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float ijv = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams oW(boolean z) {
        this.ikp = z;
        return this;
    }

    public boolean bVn() {
        return this.ikp;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] bVr = bVr();
        bVr[1] = f;
        bVr[0] = f;
        bVr[3] = f2;
        bVr[2] = f2;
        bVr[5] = f3;
        bVr[4] = f3;
        bVr[7] = f4;
        bVr[6] = f4;
        return this;
    }

    public float[] bVo() {
        return this.ikq;
    }

    public RoundingMethod bVp() {
        return this.iko;
    }

    public RoundingParams yi(@ColorInt int i) {
        this.ijC = i;
        this.iko = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int bVq() {
        return this.ijC;
    }

    private float[] bVr() {
        if (this.ikq == null) {
            this.ikq = new float[8];
        }
        return this.ikq;
    }

    public RoundingParams aK(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float bVs() {
        return this.mBorderWidth;
    }

    public RoundingParams yj(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aL(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.ijv = f;
        return this;
    }

    public float bVt() {
        return this.ijv;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.ikp == roundingParams.ikp && this.ijC == roundingParams.ijC && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.ijv, this.ijv) == 0 && this.iko == roundingParams.iko) {
            return Arrays.equals(this.ikq, roundingParams.ikq);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.ikq != null ? Arrays.hashCode(this.ikq) : 0) + (((this.ikp ? 1 : 0) + ((this.iko != null ? this.iko.hashCode() : 0) * 31)) * 31)) * 31) + this.ijC) * 31)) * 31) + this.mBorderColor) * 31) + (this.ijv != 0.0f ? Float.floatToIntBits(this.ijv) : 0);
    }
}
