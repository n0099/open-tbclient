package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f33527a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33528b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33529c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33530d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f33531e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33532f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f33533g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f33534h;

    /* renamed from: i  reason: collision with root package name */
    public final int f33535i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.f33527a = i2;
        this.f33528b = i3;
        this.f33531e = z;
        this.f33533g = z3;
        this.f33532f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f33530d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f33529c = i4;
        boolean z4 = i4 < 8;
        this.f33534h = z4;
        int i5 = this.f33530d;
        int i6 = this.f33529c * i5;
        this.f33535i = i6;
        this.j = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.k = i7;
        int i8 = i5 * this.f33527a;
        this.l = i8;
        this.m = z4 ? i7 : i8;
        int i9 = this.f33529c;
        if (i9 == 1 || i9 == 2 || i9 == 4) {
            if (!this.f33533g && !this.f33532f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f33529c);
            }
        } else if (i9 != 8) {
            if (i9 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f33529c);
            } else if (this.f33533g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f33529c);
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
            return this.f33531e == kVar.f33531e && this.f33529c == kVar.f33529c && this.f33527a == kVar.f33527a && this.f33532f == kVar.f33532f && this.f33533g == kVar.f33533g && this.f33528b == kVar.f33528b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f33531e ? 1231 : 1237) + 31) * 31) + this.f33529c) * 31) + this.f33527a) * 31) + (this.f33532f ? 1231 : 1237)) * 31) + (this.f33533g ? 1231 : 1237)) * 31) + this.f33528b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f33527a + ", rows=" + this.f33528b + ", bitDepth=" + this.f33529c + ", channels=" + this.f33530d + ", alpha=" + this.f33531e + ", greyscale=" + this.f33532f + ", indexed=" + this.f33533g + "]";
    }
}
