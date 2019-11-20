package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod keF = RoundingMethod.BITMAP_ONLY;
    private boolean keG = false;
    private float[] keH = null;
    private int kdS = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float kdM = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams si(boolean z) {
        this.keG = z;
        return this;
    }

    public boolean cEW() {
        return this.keG;
    }

    public RoundingParams aG(float f) {
        Arrays.fill(cFa(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] cFa = cFa();
        cFa[1] = f;
        cFa[0] = f;
        cFa[3] = f2;
        cFa[2] = f2;
        cFa[5] = f3;
        cFa[4] = f3;
        cFa[7] = f4;
        cFa[6] = f4;
        return this;
    }

    public float[] cEX() {
        return this.keH;
    }

    public RoundingMethod cEY() {
        return this.keF;
    }

    public RoundingParams Cm(@ColorInt int i) {
        this.kdS = i;
        this.keF = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cEZ() {
        return this.kdS;
    }

    private float[] cFa() {
        if (this.keH == null) {
            this.keH = new float[8];
        }
        return this.keH;
    }

    public RoundingParams aH(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Cn(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aI(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.kdM = f;
        return this;
    }

    public float cFb() {
        return this.kdM;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.keG == roundingParams.keG && this.kdS == roundingParams.kdS && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.kdM, this.kdM) == 0 && this.keF == roundingParams.keF) {
            return Arrays.equals(this.keH, roundingParams.keH);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.keH != null ? Arrays.hashCode(this.keH) : 0) + (((this.keG ? 1 : 0) + ((this.keF != null ? this.keF.hashCode() : 0) * 31)) * 31)) * 31) + this.kdS) * 31)) * 31) + this.mBorderColor) * 31) + (this.kdM != 0.0f ? Float.floatToIntBits(this.kdM) : 0);
    }
}
