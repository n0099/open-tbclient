package com.kwad.sdk.pngencrypt;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f36916a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36917b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36918c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36919d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f36920e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36921f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36922g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36923h;

    /* renamed from: i  reason: collision with root package name */
    public final int f36924i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.f36916a = i2;
        this.f36917b = i3;
        this.f36920e = z;
        this.f36922g = z3;
        this.f36921f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f36919d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f36918c = i4;
        boolean z4 = i4 < 8;
        this.f36923h = z4;
        int i5 = this.f36919d;
        int i6 = this.f36918c * i5;
        this.f36924i = i6;
        this.j = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.k = i7;
        int i8 = i5 * this.f36916a;
        this.l = i8;
        this.m = z4 ? i7 : i8;
        int i9 = this.f36918c;
        if (i9 == 1 || i9 == 2 || i9 == 4) {
            if (!this.f36922g && !this.f36921f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f36918c);
            }
        } else if (i9 != 8) {
            if (i9 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f36918c);
            } else if (this.f36922g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f36918c);
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
            return this.f36920e == kVar.f36920e && this.f36918c == kVar.f36918c && this.f36916a == kVar.f36916a && this.f36921f == kVar.f36921f && this.f36922g == kVar.f36922g && this.f36917b == kVar.f36917b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f36920e ? 1231 : 1237) + 31) * 31) + this.f36918c) * 31) + this.f36916a) * 31) + (this.f36921f ? 1231 : 1237)) * 31) + (this.f36922g ? 1231 : 1237)) * 31) + this.f36917b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f36916a + ", rows=" + this.f36917b + ", bitDepth=" + this.f36918c + ", channels=" + this.f36919d + ", alpha=" + this.f36920e + ", greyscale=" + this.f36921f + ", indexed=" + this.f36922g + "]";
    }
}
