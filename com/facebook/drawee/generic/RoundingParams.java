package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class RoundingParams {
    private RoundingMethod oQq = RoundingMethod.BITMAP_ONLY;
    private boolean oQr = false;
    private float[] oQs = null;
    private int oPl = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean oPf = false;

    /* loaded from: classes15.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams Ak(boolean z) {
        this.oQr = z;
        return this;
    }

    public boolean emt() {
        return this.oQr;
    }

    public RoundingParams bn(float f) {
        Arrays.fill(emx(), f);
        return this;
    }

    public RoundingParams j(float f, float f2, float f3, float f4) {
        float[] emx = emx();
        emx[1] = f;
        emx[0] = f;
        emx[3] = f2;
        emx[2] = f2;
        emx[5] = f3;
        emx[4] = f3;
        emx[7] = f4;
        emx[6] = f4;
        return this;
    }

    public float[] emu() {
        return this.oQs;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.oQq = roundingMethod;
        return this;
    }

    public RoundingMethod emv() {
        return this.oQq;
    }

    public RoundingParams ON(@ColorInt int i) {
        this.oPl = i;
        this.oQq = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int emw() {
        return this.oPl;
    }

    private float[] emx() {
        if (this.oQs == null) {
            this.oQs = new float[8];
        }
        return this.oQs;
    }

    public static RoundingParams emy() {
        return new RoundingParams().Ak(true);
    }

    public static RoundingParams k(float f, float f2, float f3, float f4) {
        return new RoundingParams().j(f, f2, f3, f4);
    }

    public RoundingParams bo(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams OO(@ColorInt int i) {
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

    public RoundingParams bp(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean emz() {
        return this.oPf;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.oQr == roundingParams.oQr && this.oPl == roundingParams.oPl && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.oQq == roundingParams.oQq && this.oPf == roundingParams.oPf) {
            return Arrays.equals(this.oQs, roundingParams.oQs);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.oQs != null ? Arrays.hashCode(this.oQs) : 0) + (((this.oQr ? 1 : 0) + ((this.oQq != null ? this.oQq.hashCode() : 0) * 31)) * 31)) * 31) + this.oPl) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.oPf ? 1 : 0);
    }
}
