package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class RoundingParams {
    private RoundingMethod oGX = RoundingMethod.BITMAP_ONLY;
    private boolean oGY = false;
    private float[] oGZ = null;
    private int oFS = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean oFM = false;

    /* loaded from: classes15.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams zZ(boolean z) {
        this.oGY = z;
        return this;
    }

    public boolean eiE() {
        return this.oGY;
    }

    public RoundingParams bl(float f) {
        Arrays.fill(eiI(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] eiI = eiI();
        eiI[1] = f;
        eiI[0] = f;
        eiI[3] = f2;
        eiI[2] = f2;
        eiI[5] = f3;
        eiI[4] = f3;
        eiI[7] = f4;
        eiI[6] = f4;
        return this;
    }

    public float[] eiF() {
        return this.oGZ;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.oGX = roundingMethod;
        return this;
    }

    public RoundingMethod eiG() {
        return this.oGX;
    }

    public RoundingParams Os(@ColorInt int i) {
        this.oFS = i;
        this.oGX = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int eiH() {
        return this.oFS;
    }

    private float[] eiI() {
        if (this.oGZ == null) {
            this.oGZ = new float[8];
        }
        return this.oGZ;
    }

    public static RoundingParams eiJ() {
        return new RoundingParams().zZ(true);
    }

    public static RoundingParams k(float f, float f2, float f3, float f4) {
        return new RoundingParams().j(f, f2, f3, f4);
    }

    public RoundingParams bm(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Ot(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams p(@ColorInt int i, float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        this.mBorderColor = i;
        return this;
    }

    public RoundingParams bn(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean eiK() {
        return this.oFM;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.oGY == roundingParams.oGY && this.oFS == roundingParams.oFS && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.oGX == roundingParams.oGX && this.oFM == roundingParams.oFM) {
            return Arrays.equals(this.oGZ, roundingParams.oGZ);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.oGZ != null ? Arrays.hashCode(this.oGZ) : 0) + (((this.oGY ? 1 : 0) + ((this.oGX != null ? this.oGX.hashCode() : 0) * 31)) * 31)) * 31) + this.oFS) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.oFM ? 1 : 0);
    }
}
