package com.kwad.sdk.pngencrypt;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f10511a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10512b;
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
    private long n = -1;
    private long o = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.f10511a = i;
        this.f10512b = i2;
        this.e = z;
        this.g = z3;
        this.f = z2;
        if (this.f && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.c = i3;
        this.h = i3 < 8;
        this.i = this.d * this.c;
        this.j = (this.i + 7) / 8;
        this.k = ((this.i * i) + 7) / 8;
        this.l = this.d * this.f10511a;
        this.m = this.h ? this.k : this.l;
        switch (this.c) {
            case 1:
            case 2:
            case 4:
                if (!this.g && !this.f) {
                    throw new PngjException("only indexed or grayscale can have bitdepth=" + this.c);
                }
                break;
            case 8:
                break;
            case 16:
                if (this.g) {
                    throw new PngjException("indexed can't have bitdepth=" + this.c);
                }
                break;
            default:
                throw new PngjException("invalid bitdepth=" + this.c);
        }
        if (i < 1 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        }
        if (i2 < 1 || i2 > 16777216) {
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
        if (this.l < 1) {
            throw new PngjException("invalid image parameters (overflow?)");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            k kVar = (k) obj;
            return this.e == kVar.e && this.c == kVar.c && this.f10511a == kVar.f10511a && this.f == kVar.f && this.g == kVar.g && this.f10512b == kVar.f10512b;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f ? 1231 : 1237) + (((((((this.e ? 1231 : 1237) + 31) * 31) + this.c) * 31) + this.f10511a) * 31)) * 31) + (this.g ? 1231 : 1237)) * 31) + this.f10512b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f10511a + ", rows=" + this.f10512b + ", bitDepth=" + this.c + ", channels=" + this.d + ", alpha=" + this.e + ", greyscale=" + this.f + ", indexed=" + this.g + "]";
    }
}
