package com.kwad.sdk.pngencrypt;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes3.dex */
public class k {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f59375b;

    /* renamed from: c  reason: collision with root package name */
    public final int f59376c;

    /* renamed from: d  reason: collision with root package name */
    public final int f59377d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f59378e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f59379f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f59380g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f59381h;

    /* renamed from: i  reason: collision with root package name */
    public final int f59382i;

    /* renamed from: j  reason: collision with root package name */
    public final int f59383j;

    /* renamed from: k  reason: collision with root package name */
    public final int f59384k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.a = i2;
        this.f59375b = i3;
        this.f59378e = z;
        this.f59380g = z3;
        this.f59379f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f59377d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f59376c = i4;
        boolean z4 = i4 < 8;
        this.f59381h = z4;
        int i5 = this.f59377d;
        int i6 = this.f59376c * i5;
        this.f59382i = i6;
        this.f59383j = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.f59384k = i7;
        int i8 = i5 * this.a;
        this.l = i8;
        this.m = z4 ? i7 : i8;
        int i9 = this.f59376c;
        if (i9 == 1 || i9 == 2 || i9 == 4) {
            if (!this.f59380g && !this.f59379f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f59376c);
            }
        } else if (i9 != 8) {
            if (i9 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f59376c);
            } else if (this.f59380g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f59376c);
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
            return this.f59378e == kVar.f59378e && this.f59376c == kVar.f59376c && this.a == kVar.a && this.f59379f == kVar.f59379f && this.f59380g == kVar.f59380g && this.f59375b == kVar.f59375b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f59378e ? 1231 : 1237) + 31) * 31) + this.f59376c) * 31) + this.a) * 31) + (this.f59379f ? 1231 : 1237)) * 31) + (this.f59380g ? 1231 : 1237)) * 31) + this.f59375b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.a + ", rows=" + this.f59375b + ", bitDepth=" + this.f59376c + ", channels=" + this.f59377d + ", alpha=" + this.f59378e + ", greyscale=" + this.f59379f + ", indexed=" + this.f59380g + PreferencesUtil.RIGHT_MOUNT;
    }
}
