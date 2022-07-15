package com.kwad.sdk.pngencrypt;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes5.dex */
public final class k {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.a = i;
        this.b = i2;
        this.e = z;
        this.g = z3;
        this.f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.c = i3;
        boolean z4 = i3 < 8;
        this.h = z4;
        int i4 = this.d;
        int i5 = this.c * i4;
        this.i = i5;
        this.j = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.k = i6;
        int i7 = i4 * this.a;
        this.l = i7;
        this.m = z4 ? i6 : i7;
        int i8 = this.c;
        if (i8 == 1 || i8 == 2 || i8 == 4) {
            if (!this.g && !this.f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.c);
            }
        } else if (i8 != 8) {
            if (i8 != 16) {
                throw new PngjException("invalid bitdepth=" + this.c);
            } else if (this.g) {
                throw new PngjException("indexed can't have bitdepth=" + this.c);
            }
        }
        if (i <= 0 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        } else if (i2 > 0 && i2 <= 16777216) {
            if (this.l <= 0) {
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
            return this.e == kVar.e && this.c == kVar.c && this.a == kVar.a && this.f == kVar.f && this.g == kVar.g && this.b == kVar.b;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((this.e ? 1231 : 1237) + 31) * 31) + this.c) * 31) + this.a) * 31) + (this.f ? 1231 : 1237)) * 31) + (this.g ? 1231 : 1237)) * 31) + this.b;
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.a + ", rows=" + this.b + ", bitDepth=" + this.c + ", channels=" + this.d + ", alpha=" + this.e + ", greyscale=" + this.f + ", indexed=" + this.g + PreferencesUtil.RIGHT_MOUNT;
    }
}
