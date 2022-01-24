package com.kwad.sdk.pngencrypt;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes3.dex */
public class k {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57176b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57177c;

    /* renamed from: d  reason: collision with root package name */
    public final int f57178d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f57179e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f57180f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f57181g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f57182h;

    /* renamed from: i  reason: collision with root package name */
    public final int f57183i;

    /* renamed from: j  reason: collision with root package name */
    public final int f57184j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.a = i2;
        this.f57176b = i3;
        this.f57179e = z;
        this.f57181g = z3;
        this.f57180f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f57178d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f57177c = i4;
        boolean z4 = i4 < 8;
        this.f57182h = z4;
        int i5 = this.f57178d;
        int i6 = this.f57177c * i5;
        this.f57183i = i6;
        this.f57184j = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.k = i7;
        int i8 = i5 * this.a;
        this.l = i8;
        this.m = z4 ? i7 : i8;
        int i9 = this.f57177c;
        if (i9 == 1 || i9 == 2 || i9 == 4) {
            if (!this.f57181g && !this.f57180f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f57177c);
            }
        } else if (i9 != 8) {
            if (i9 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f57177c);
            } else if (this.f57181g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f57177c);
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
            return this.f57179e == kVar.f57179e && this.f57177c == kVar.f57177c && this.a == kVar.a && this.f57180f == kVar.f57180f && this.f57181g == kVar.f57181g && this.f57176b == kVar.f57176b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f57179e ? 1231 : 1237) + 31) * 31) + this.f57177c) * 31) + this.a) * 31) + (this.f57180f ? 1231 : 1237)) * 31) + (this.f57181g ? 1231 : 1237)) * 31) + this.f57176b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.a + ", rows=" + this.f57176b + ", bitDepth=" + this.f57177c + ", channels=" + this.f57178d + ", alpha=" + this.f57179e + ", greyscale=" + this.f57180f + ", indexed=" + this.f57181g + PreferencesUtil.RIGHT_MOUNT;
    }
}
