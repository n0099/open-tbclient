package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class RoundingParams {
    private RoundingMethod kfw = RoundingMethod.BITMAP_ONLY;
    private boolean kfx = false;
    private float[] kfy = null;
    private int keK = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float keE = 0.0f;

    /* loaded from: classes2.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams si(boolean z) {
        this.kfx = z;
        return this;
    }

    public boolean cEY() {
        return this.kfx;
    }

    public RoundingParams aG(float f) {
        Arrays.fill(cFc(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] cFc = cFc();
        cFc[1] = f;
        cFc[0] = f;
        cFc[3] = f2;
        cFc[2] = f2;
        cFc[5] = f3;
        cFc[4] = f3;
        cFc[7] = f4;
        cFc[6] = f4;
        return this;
    }

    public float[] cEZ() {
        return this.kfy;
    }

    public RoundingMethod cFa() {
        return this.kfw;
    }

    public RoundingParams Cn(@ColorInt int i) {
        this.keK = i;
        this.kfw = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int cFb() {
        return this.keK;
    }

    private float[] cFc() {
        if (this.kfy == null) {
            this.kfy = new float[8];
        }
        return this.kfy;
    }

    public RoundingParams aH(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Co(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams aI(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.keE = f;
        return this;
    }

    public float cFd() {
        return this.keE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.kfx == roundingParams.kfx && this.keK == roundingParams.keK && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.keE, this.keE) == 0 && this.kfw == roundingParams.kfw) {
            return Arrays.equals(this.kfy, roundingParams.kfy);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.kfy != null ? Arrays.hashCode(this.kfy) : 0) + (((this.kfx ? 1 : 0) + ((this.kfw != null ? this.kfw.hashCode() : 0) * 31)) * 31)) * 31) + this.keK) * 31)) * 31) + this.mBorderColor) * 31) + (this.keE != 0.0f ? Float.floatToIntBits(this.keE) : 0);
    }
}
