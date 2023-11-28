package com.kwad.sdk.pngencrypt;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes10.dex */
public final class k {
    public final int aJD;
    public final int aJE;
    public final boolean aJF;
    public final boolean aJG;
    public final boolean aJH;
    public final boolean aJI;
    public final int aJJ;
    public final int aJK;
    public final int aJL;
    public final int aJM;
    public final int aJN;
    public long aJO = -1;
    public long aJP = -1;
    public final int aJk;
    public final int aJl;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        int i4;
        boolean z4;
        this.aJl = i;
        this.aJk = i2;
        this.aJF = z;
        this.aJH = z3;
        this.aJG = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        if (!z2 && !z3) {
            if (z) {
                i4 = 4;
            } else {
                i4 = 3;
            }
        } else if (z) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        this.aJE = i4;
        this.aJD = i3;
        if (i3 < 8) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.aJI = z4;
        int i5 = this.aJE;
        int i6 = this.aJD * i5;
        this.aJJ = i6;
        this.aJK = (i6 + 7) / 8;
        int i7 = ((i6 * i) + 7) / 8;
        this.aJL = i7;
        int i8 = i5 * this.aJl;
        this.aJM = i8;
        this.aJN = z4 ? i7 : i8;
        int i9 = this.aJD;
        if (i9 != 1 && i9 != 2 && i9 != 4) {
            if (i9 != 8) {
                if (i9 == 16) {
                    if (this.aJH) {
                        throw new PngjException("indexed can't have bitdepth=" + this.aJD);
                    }
                } else {
                    throw new PngjException("invalid bitdepth=" + this.aJD);
                }
            }
        } else if (!this.aJH && !this.aJG) {
            throw new PngjException("only indexed or grayscale can have bitdepth=" + this.aJD);
        }
        if (i > 0 && i <= 16777216) {
            if (i2 > 0 && i2 <= 16777216) {
                if (this.aJM > 0) {
                    return;
                }
                throw new PngjException("invalid image parameters (overflow?)");
            }
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
        throw new PngjException("invalid cols=" + i + " ???");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.aJF == kVar.aJF && this.aJD == kVar.aJD && this.aJl == kVar.aJl && this.aJG == kVar.aJG && this.aJH == kVar.aJH && this.aJk == kVar.aJk) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3 = 1231;
        if (this.aJF) {
            i = 1231;
        } else {
            i = 1237;
        }
        int i4 = (((((i + 31) * 31) + this.aJD) * 31) + this.aJl) * 31;
        if (this.aJG) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        int i5 = (i4 + i2) * 31;
        if (!this.aJH) {
            i3 = 1237;
        }
        return ((i5 + i3) * 31) + this.aJk;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.aJl + ", rows=" + this.aJk + ", bitDepth=" + this.aJD + ", channels=" + this.aJE + ", alpha=" + this.aJF + ", greyscale=" + this.aJG + ", indexed=" + this.aJH + PreferencesUtil.RIGHT_MOUNT;
    }
}
