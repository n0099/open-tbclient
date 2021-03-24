package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f36184a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36185b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36186c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36187d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f36188e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36189f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36190g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36191h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.f36184a = i;
        this.f36185b = i2;
        this.f36188e = z;
        this.f36190g = z3;
        this.f36189f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f36187d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f36186c = i3;
        boolean z4 = i3 < 8;
        this.f36191h = z4;
        int i4 = this.f36187d;
        int i5 = this.f36186c * i4;
        this.i = i5;
        this.j = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.k = i6;
        int i7 = i4 * this.f36184a;
        this.l = i7;
        this.m = z4 ? i6 : i7;
        int i8 = this.f36186c;
        if (i8 == 1 || i8 == 2 || i8 == 4) {
            if (!this.f36190g && !this.f36189f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f36186c);
            }
        } else if (i8 != 8) {
            if (i8 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f36186c);
            } else if (this.f36190g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f36186c);
            }
        }
        if (i < 1 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        } else if (i2 >= 1 && i2 <= 16777216) {
            if (this.l < 1) {
                throw new PngjException("invalid image parameters (overflow?)");
            }
        } else {
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            return this.f36188e == kVar.f36188e && this.f36186c == kVar.f36186c && this.f36184a == kVar.f36184a && this.f36189f == kVar.f36189f && this.f36190g == kVar.f36190g && this.f36185b == kVar.f36185b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f36188e ? 1231 : 1237) + 31) * 31) + this.f36186c) * 31) + this.f36184a) * 31) + (this.f36189f ? 1231 : 1237)) * 31) + (this.f36190g ? 1231 : 1237)) * 31) + this.f36185b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f36184a + ", rows=" + this.f36185b + ", bitDepth=" + this.f36186c + ", channels=" + this.f36187d + ", alpha=" + this.f36188e + ", greyscale=" + this.f36189f + ", indexed=" + this.f36190g + "]";
    }
}
