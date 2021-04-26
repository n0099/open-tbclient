package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f34282a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34283b;

    /* renamed from: c  reason: collision with root package name */
    public final int f34284c;

    /* renamed from: d  reason: collision with root package name */
    public final int f34285d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f34286e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f34287f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f34288g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f34289h;

    /* renamed from: i  reason: collision with root package name */
    public final int f34290i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.f34282a = i2;
        this.f34283b = i3;
        this.f34286e = z;
        this.f34288g = z3;
        this.f34287f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f34285d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f34284c = i4;
        boolean z4 = i4 < 8;
        this.f34289h = z4;
        int i5 = this.f34285d;
        int i6 = this.f34284c * i5;
        this.f34290i = i6;
        this.j = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.k = i7;
        int i8 = i5 * this.f34282a;
        this.l = i8;
        this.m = z4 ? i7 : i8;
        int i9 = this.f34284c;
        if (i9 == 1 || i9 == 2 || i9 == 4) {
            if (!this.f34288g && !this.f34287f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f34284c);
            }
        } else if (i9 != 8) {
            if (i9 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f34284c);
            } else if (this.f34288g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f34284c);
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
            return this.f34286e == kVar.f34286e && this.f34284c == kVar.f34284c && this.f34282a == kVar.f34282a && this.f34287f == kVar.f34287f && this.f34288g == kVar.f34288g && this.f34283b == kVar.f34283b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f34286e ? 1231 : 1237) + 31) * 31) + this.f34284c) * 31) + this.f34282a) * 31) + (this.f34287f ? 1231 : 1237)) * 31) + (this.f34288g ? 1231 : 1237)) * 31) + this.f34283b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f34282a + ", rows=" + this.f34283b + ", bitDepth=" + this.f34284c + ", channels=" + this.f34285d + ", alpha=" + this.f34286e + ", greyscale=" + this.f34287f + ", indexed=" + this.f34288g + "]";
    }
}
