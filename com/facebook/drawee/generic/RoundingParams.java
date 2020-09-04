package com.facebook.drawee.generic;

import android.support.annotation.ColorInt;
import com.facebook.common.internal.g;
import java.util.Arrays;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class RoundingParams {
    private RoundingMethod nqn = RoundingMethod.BITMAP_ONLY;
    private boolean nqo = false;
    private float[] nqp = null;
    private int npi = 0;
    private float mBorderWidth = 0.0f;
    private int mBorderColor = 0;
    private float mPadding = 0.0f;
    private boolean npc = false;

    /* loaded from: classes4.dex */
    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public RoundingParams yb(boolean z) {
        this.nqo = z;
        return this;
    }

    public boolean dQX() {
        return this.nqo;
    }

    public RoundingParams aO(float f) {
        Arrays.fill(dRb(), f);
        return this;
    }

    public RoundingParams h(float f, float f2, float f3, float f4) {
        float[] dRb = dRb();
        dRb[1] = f;
        dRb[0] = f;
        dRb[3] = f2;
        dRb[2] = f2;
        dRb[5] = f3;
        dRb[4] = f3;
        dRb[7] = f4;
        dRb[6] = f4;
        return this;
    }

    public float[] dQY() {
        return this.nqp;
    }

    public RoundingParams a(RoundingMethod roundingMethod) {
        this.nqn = roundingMethod;
        return this;
    }

    public RoundingMethod dQZ() {
        return this.nqn;
    }

    public RoundingParams Lq(@ColorInt int i) {
        this.npi = i;
        this.nqn = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public int dRa() {
        return this.npi;
    }

    private float[] dRb() {
        if (this.nqp == null) {
            this.nqp = new float[8];
        }
        return this.nqp;
    }

    public static RoundingParams dRc() {
        return new RoundingParams().yb(true);
    }

    public static RoundingParams i(float f, float f2, float f3, float f4) {
        return new RoundingParams().h(f, f2, f3, f4);
    }

    public RoundingParams aP(float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        return this;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public RoundingParams Lr(@ColorInt int i) {
        this.mBorderColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public RoundingParams o(@ColorInt int i, float f) {
        g.checkArgument(f >= 0.0f, "the border width cannot be < 0");
        this.mBorderWidth = f;
        this.mBorderColor = i;
        return this;
    }

    public RoundingParams aQ(float f) {
        g.checkArgument(f >= 0.0f, "the padding cannot be < 0");
        this.mPadding = f;
        return this;
    }

    public float getPadding() {
        return this.mPadding;
    }

    public boolean dRd() {
        return this.npc;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.nqo == roundingParams.nqo && this.npi == roundingParams.npi && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.nqn == roundingParams.nqn && this.npc == roundingParams.npc) {
            return Arrays.equals(this.nqp, roundingParams.nqp);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mPadding != 0.0f ? Float.floatToIntBits(this.mPadding) : 0) + (((((this.mBorderWidth != 0.0f ? Float.floatToIntBits(this.mBorderWidth) : 0) + (((((this.nqp != null ? Arrays.hashCode(this.nqp) : 0) + (((this.nqo ? 1 : 0) + ((this.nqn != null ? this.nqn.hashCode() : 0) * 31)) * 31)) * 31) + this.npi) * 31)) * 31) + this.mBorderColor) * 31)) * 31) + (this.npc ? 1 : 0);
    }
}
