package com.kwad.sdk.pngencrypt;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes9.dex */
public final class k {
    public final int akN;
    public final int akO;
    public final boolean akP;
    public final boolean akQ;
    public final boolean akR;
    public final boolean akS;
    public final int akT;
    public final int akU;
    public final int akV;
    public final int akW;
    public final int akX;
    public long akY = -1;
    public long akZ = -1;
    public final int aku;
    public final int akv;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.akv = i;
        this.aku = i2;
        this.akP = z;
        this.akR = z3;
        this.akQ = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.akO = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.akN = i3;
        boolean z4 = i3 < 8;
        this.akS = z4;
        int i4 = this.akO;
        int i5 = this.akN * i4;
        this.akT = i5;
        this.akU = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.akV = i6;
        int i7 = i4 * this.akv;
        this.akW = i7;
        this.akX = z4 ? i6 : i7;
        int i8 = this.akN;
        if (i8 == 1 || i8 == 2 || i8 == 4) {
            if (!this.akR && !this.akQ) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.akN);
            }
        } else if (i8 != 8) {
            if (i8 != 16) {
                throw new PngjException("invalid bitdepth=" + this.akN);
            } else if (this.akR) {
                throw new PngjException("indexed can't have bitdepth=" + this.akN);
            }
        }
        if (i <= 0 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        } else if (i2 > 0 && i2 <= 16777216) {
            if (this.akW <= 0) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            return this.akP == kVar.akP && this.akN == kVar.akN && this.akv == kVar.akv && this.akQ == kVar.akQ && this.akR == kVar.akR && this.aku == kVar.aku;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.akP ? 1231 : 1237) + 31) * 31) + this.akN) * 31) + this.akv) * 31) + (this.akQ ? 1231 : 1237)) * 31) + (this.akR ? 1231 : 1237)) * 31) + this.aku;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.akv + ", rows=" + this.aku + ", bitDepth=" + this.akN + ", channels=" + this.akO + ", alpha=" + this.akP + ", greyscale=" + this.akQ + ", indexed=" + this.akR + PreferencesUtil.RIGHT_MOUNT;
    }
}
