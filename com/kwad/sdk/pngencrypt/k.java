package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f33456a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33457b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33458c;

    /* renamed from: d  reason: collision with root package name */
    public final int f33459d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f33460e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33461f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f33462g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f33463h;

    /* renamed from: i  reason: collision with root package name */
    public final int f33464i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.f33456a = i2;
        this.f33457b = i3;
        this.f33460e = z;
        this.f33462g = z3;
        this.f33461f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f33459d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f33458c = i4;
        boolean z4 = i4 < 8;
        this.f33463h = z4;
        int i5 = this.f33459d;
        int i6 = this.f33458c * i5;
        this.f33464i = i6;
        this.j = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.k = i7;
        int i8 = i5 * this.f33456a;
        this.l = i8;
        this.m = z4 ? i7 : i8;
        int i9 = this.f33458c;
        if (i9 == 1 || i9 == 2 || i9 == 4) {
            if (!this.f33462g && !this.f33461f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f33458c);
            }
        } else if (i9 != 8) {
            if (i9 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f33458c);
            } else if (this.f33462g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f33458c);
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
            return this.f33460e == kVar.f33460e && this.f33458c == kVar.f33458c && this.f33456a == kVar.f33456a && this.f33461f == kVar.f33461f && this.f33462g == kVar.f33462g && this.f33457b == kVar.f33457b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f33460e ? 1231 : 1237) + 31) * 31) + this.f33458c) * 31) + this.f33456a) * 31) + (this.f33461f ? 1231 : 1237)) * 31) + (this.f33462g ? 1231 : 1237)) * 31) + this.f33457b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f33456a + ", rows=" + this.f33457b + ", bitDepth=" + this.f33458c + ", channels=" + this.f33459d + ", alpha=" + this.f33460e + ", greyscale=" + this.f33461f + ", indexed=" + this.f33462g + "]";
    }
}
