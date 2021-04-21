package com.kwad.sdk.pngencrypt;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f36569a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36570b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36571c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36572d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f36573e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36574f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36575g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f36576h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.f36569a = i;
        this.f36570b = i2;
        this.f36573e = z;
        this.f36575g = z3;
        this.f36574f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f36572d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f36571c = i3;
        boolean z4 = i3 < 8;
        this.f36576h = z4;
        int i4 = this.f36572d;
        int i5 = this.f36571c * i4;
        this.i = i5;
        this.j = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.k = i6;
        int i7 = i4 * this.f36569a;
        this.l = i7;
        this.m = z4 ? i6 : i7;
        int i8 = this.f36571c;
        if (i8 == 1 || i8 == 2 || i8 == 4) {
            if (!this.f36575g && !this.f36574f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f36571c);
            }
        } else if (i8 != 8) {
            if (i8 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f36571c);
            } else if (this.f36575g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f36571c);
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
            return this.f36573e == kVar.f36573e && this.f36571c == kVar.f36571c && this.f36569a == kVar.f36569a && this.f36574f == kVar.f36574f && this.f36575g == kVar.f36575g && this.f36570b == kVar.f36570b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f36573e ? 1231 : 1237) + 31) * 31) + this.f36571c) * 31) + this.f36569a) * 31) + (this.f36574f ? 1231 : 1237)) * 31) + (this.f36575g ? 1231 : 1237)) * 31) + this.f36570b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f36569a + ", rows=" + this.f36570b + ", bitDepth=" + this.f36571c + ", channels=" + this.f36572d + ", alpha=" + this.f36573e + ", greyscale=" + this.f36574f + ", indexed=" + this.f36575g + "]";
    }
}
