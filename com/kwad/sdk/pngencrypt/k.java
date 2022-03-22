package com.kwad.sdk.pngencrypt;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes7.dex */
public class k {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40680b;

    /* renamed from: c  reason: collision with root package name */
    public final int f40681c;

    /* renamed from: d  reason: collision with root package name */
    public final int f40682d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f40683e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f40684f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f40685g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f40686h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.a = i;
        this.f40680b = i2;
        this.f40683e = z;
        this.f40685g = z3;
        this.f40684f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f40682d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f40681c = i3;
        boolean z4 = i3 < 8;
        this.f40686h = z4;
        int i4 = this.f40682d;
        int i5 = this.f40681c * i4;
        this.i = i5;
        this.j = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.k = i6;
        int i7 = i4 * this.a;
        this.l = i7;
        this.m = z4 ? i6 : i7;
        int i8 = this.f40681c;
        if (i8 == 1 || i8 == 2 || i8 == 4) {
            if (!this.f40685g && !this.f40684f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f40681c);
            }
        } else if (i8 != 8) {
            if (i8 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f40681c);
            } else if (this.f40685g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f40681c);
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
            return this.f40683e == kVar.f40683e && this.f40681c == kVar.f40681c && this.a == kVar.a && this.f40684f == kVar.f40684f && this.f40685g == kVar.f40685g && this.f40680b == kVar.f40680b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f40683e ? 1231 : 1237) + 31) * 31) + this.f40681c) * 31) + this.a) * 31) + (this.f40684f ? 1231 : 1237)) * 31) + (this.f40685g ? 1231 : 1237)) * 31) + this.f40680b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.a + ", rows=" + this.f40680b + ", bitDepth=" + this.f40681c + ", channels=" + this.f40682d + ", alpha=" + this.f40683e + ", greyscale=" + this.f40684f + ", indexed=" + this.f40685g + PreferencesUtil.RIGHT_MOUNT;
    }
}
