package com.kwad.sdk.pngencrypt;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes3.dex */
public class k {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57131b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57132c;

    /* renamed from: d  reason: collision with root package name */
    public final int f57133d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f57134e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f57135f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f57136g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f57137h;

    /* renamed from: i  reason: collision with root package name */
    public final int f57138i;

    /* renamed from: j  reason: collision with root package name */
    public final int f57139j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.a = i2;
        this.f57131b = i3;
        this.f57134e = z;
        this.f57136g = z3;
        this.f57135f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f57133d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f57132c = i4;
        boolean z4 = i4 < 8;
        this.f57137h = z4;
        int i5 = this.f57133d;
        int i6 = this.f57132c * i5;
        this.f57138i = i6;
        this.f57139j = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.k = i7;
        int i8 = i5 * this.a;
        this.l = i8;
        this.m = z4 ? i7 : i8;
        int i9 = this.f57132c;
        if (i9 == 1 || i9 == 2 || i9 == 4) {
            if (!this.f57136g && !this.f57135f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f57132c);
            }
        } else if (i9 != 8) {
            if (i9 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f57132c);
            } else if (this.f57136g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f57132c);
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
            return this.f57134e == kVar.f57134e && this.f57132c == kVar.f57132c && this.a == kVar.a && this.f57135f == kVar.f57135f && this.f57136g == kVar.f57136g && this.f57131b == kVar.f57131b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f57134e ? 1231 : 1237) + 31) * 31) + this.f57132c) * 31) + this.a) * 31) + (this.f57135f ? 1231 : 1237)) * 31) + (this.f57136g ? 1231 : 1237)) * 31) + this.f57131b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.a + ", rows=" + this.f57131b + ", bitDepth=" + this.f57132c + ", channels=" + this.f57133d + ", alpha=" + this.f57134e + ", greyscale=" + this.f57135f + ", indexed=" + this.f57136g + PreferencesUtil.RIGHT_MOUNT;
    }
}
