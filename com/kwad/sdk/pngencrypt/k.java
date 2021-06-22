package com.kwad.sdk.pngencrypt;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f37014a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37015b;

    /* renamed from: c  reason: collision with root package name */
    public final int f37016c;

    /* renamed from: d  reason: collision with root package name */
    public final int f37017d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f37018e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f37019f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37020g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f37021h;

    /* renamed from: i  reason: collision with root package name */
    public final int f37022i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public long n = -1;
    public long o = -1;

    public k(int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.f37014a = i2;
        this.f37015b = i3;
        this.f37018e = z;
        this.f37020g = z3;
        this.f37019f = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        this.f37017d = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.f37016c = i4;
        boolean z4 = i4 < 8;
        this.f37021h = z4;
        int i5 = this.f37017d;
        int i6 = this.f37016c * i5;
        this.f37022i = i6;
        this.j = (i6 + 7) / 8;
        int i7 = ((i6 * i2) + 7) / 8;
        this.k = i7;
        int i8 = i5 * this.f37014a;
        this.l = i8;
        this.m = z4 ? i7 : i8;
        int i9 = this.f37016c;
        if (i9 == 1 || i9 == 2 || i9 == 4) {
            if (!this.f37020g && !this.f37019f) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + this.f37016c);
            }
        } else if (i9 != 8) {
            if (i9 != 16) {
                throw new PngjException("invalid bitdepth=" + this.f37016c);
            } else if (this.f37020g) {
                throw new PngjException("indexed can't have bitdepth=" + this.f37016c);
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
            return this.f37018e == kVar.f37018e && this.f37016c == kVar.f37016c && this.f37014a == kVar.f37014a && this.f37019f == kVar.f37019f && this.f37020g == kVar.f37020g && this.f37015b == kVar.f37015b;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f37018e ? 1231 : 1237) + 31) * 31) + this.f37016c) * 31) + this.f37014a) * 31) + (this.f37019f ? 1231 : 1237)) * 31) + (this.f37020g ? 1231 : 1237)) * 31) + this.f37015b;
    }

    public String toString() {
        return "ImageInfo [cols=" + this.f37014a + ", rows=" + this.f37015b + ", bitDepth=" + this.f37016c + ", channels=" + this.f37017d + ", alpha=" + this.f37018e + ", greyscale=" + this.f37019f + ", indexed=" + this.f37020g + PreferencesUtil.RIGHT_MOUNT;
    }
}
