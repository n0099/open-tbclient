package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f36474a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36475b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36476c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36477d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f36478e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36479f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36480g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36481h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.f36474a = i;
        this.f36475b = i2;
        this.f36478e = z;
        this.f36480g = z3;
        this.f36479f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f36477d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f36476c = i3;
        boolean z4 = i3 < 8;
        this.f36481h = z4;
        int i4 = this.f36477d;
        int i5 = this.f36476c * i4;
        this.i = i5;
        this.j = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.k = i6;
        int i7 = i4 * this.f36474a;
        this.l = i7;
        this.m = z4 ? i6 : i7;
        int i8 = this.f36476c;
        if (i8 == 1 || i8 == 2 || i8 == 4) {
            if (!this.f36480g && !this.f36479f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f36476c);
            }
        } else if (i8 != 8) {
            if (i8 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f36476c);
            } else if (this.f36480g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f36476c);
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
            return this.f36478e == kVar.f36478e && this.f36476c == kVar.f36476c && this.f36474a == kVar.f36474a && this.f36479f == kVar.f36479f && this.f36480g == kVar.f36480g && this.f36475b == kVar.f36475b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f36478e ? 1231 : 1237) + 31) * 31) + this.f36476c) * 31) + this.f36474a) * 31) + (this.f36479f ? 1231 : 1237)) * 31) + (this.f36480g ? 1231 : 1237)) * 31) + this.f36475b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f36474a + ", rows=" + this.f36475b + ", bitDepth=" + this.f36476c + ", channels=" + this.f36477d + ", alpha=" + this.f36478e + ", greyscale=" + this.f36479f + ", indexed=" + this.f36480g + "]";
    }
}
