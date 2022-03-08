package com.kwad.sdk.pngencrypt;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes8.dex */
public class k {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f55693b;

    /* renamed from: c  reason: collision with root package name */
    public final int f55694c;

    /* renamed from: d  reason: collision with root package name */
    public final int f55695d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f55696e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f55697f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f55698g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f55699h;

    /* renamed from: i  reason: collision with root package name */
    public final int f55700i;

    /* renamed from: j  reason: collision with root package name */
    public final int f55701j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.a = i2;
        this.f55693b = i3;
        this.f55696e = z;
        this.f55698g = z3;
        this.f55697f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f55695d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f55694c = i4;
        boolean z4 = i4 < 8;
        this.f55699h = z4;
        int i5 = this.f55695d;
        int i6 = this.f55694c * i5;
        this.f55700i = i6;
        this.f55701j = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.k = i7;
        int i8 = i5 * this.a;
        this.l = i8;
        this.m = z4 ? i7 : i8;
        int i9 = this.f55694c;
        if (i9 == 1 || i9 == 2 || i9 == 4) {
            if (!this.f55698g && !this.f55697f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f55694c);
            }
        } else if (i9 != 8) {
            if (i9 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f55694c);
            } else if (this.f55698g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f55694c);
            }
        }
        if (i2 < 1 || i2 > 16777216) {
            throw new PngjException("invalid cols=" + i2 + " ???");
        } else if (i3 >= 1 && i3 <= 16777216) {
            if (this.l < 1) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i3 + " ???");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            return this.f55696e == kVar.f55696e && this.f55694c == kVar.f55694c && this.a == kVar.a && this.f55697f == kVar.f55697f && this.f55698g == kVar.f55698g && this.f55693b == kVar.f55693b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f55696e ? 1231 : 1237) + 31) * 31) + this.f55694c) * 31) + this.a) * 31) + (this.f55697f ? 1231 : 1237)) * 31) + (this.f55698g ? 1231 : 1237)) * 31) + this.f55693b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.a + ", rows=" + this.f55693b + ", bitDepth=" + this.f55694c + ", channels=" + this.f55695d + ", alpha=" + this.f55696e + ", greyscale=" + this.f55697f + ", indexed=" + this.f55698g + PreferencesUtil.RIGHT_MOUNT;
    }
}
