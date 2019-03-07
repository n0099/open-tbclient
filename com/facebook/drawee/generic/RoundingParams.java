package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod jEi = RoundingMethod.BITMAP_ONLY;
    private boolean jEj = false;
    private float[] jEk = null;
    private int jDw = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float jDp = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams ru(boolean z) {
        this.jEj = z;
        return this;
    }

    public boolean cvL() {
        return this.jEj;
    }

    public RoundingParams aX(float f) {
        Arrays.fill(cvP(), f);
        return this;
    }

    public RoundingParams k(float f, float f2, float f3, float f4) {
        float[] cvP = cvP();
        cvP[1] = f;
        cvP[0] = f;
        cvP[3] = f2;
        cvP[2] = f2;
        cvP[5] = f3;
        cvP[4] = f3;
        cvP[7] = f4;
        cvP[6] = f4;
        return this;
    }

    public float[] cvM() {
        return this.jEk;
    }

    public RoundingMethod cvN() {
        return this.jEi;
    }

    public RoundingParams Cj(@ColorInt int i) {
        this.jDw = i;
        this.jEi = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cvO() {
        return this.jDw;
    }

    private float[] cvP() {
        if (this.jEk == null) {
            this.jEk = new float[8];
        }
        return this.jEk;
    }

    public RoundingParams aY(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float cvQ() {
        return this.mBorderWidth;
    }

    public RoundingParams Ck(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aZ(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.jDp = f;
        return this;
    }

    public float cvR() {
        return this.jDp;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.jEj == roundingParams.jEj && this.jDw == roundingParams.jDw && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.jDp, this.jDp) == 0 && this.jEi == roundingParams.jEi) {
            return Arrays.equals(this.jEk, roundingParams.jEk);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.jEk != null ? Arrays.hashCode(this.jEk) : 0) + (((this.jEj ? 1 : 0) + ((this.jEi != null ? this.jEi.hashCode() : 0) * 31)) * 31)) * 31) + this.jDw) * 31)) * 31) + this.mBorderColor) * 31) + (this.jDp != 0.0f ? Float.floatToIntBits(this.jDp) : 0);
    }
}
