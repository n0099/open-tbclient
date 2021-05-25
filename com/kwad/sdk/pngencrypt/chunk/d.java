package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f33396a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f33397b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33398c;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f33402g;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f33399d = null;

    /* renamed from: f  reason: collision with root package name */
    public long f33401f = 0;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f33400e = new byte[4];

    public d(int i2, String str, boolean z) {
        this.f33396a = i2;
        this.f33398c = str;
        this.f33397b = b.a(str);
        for (int i3 = 0; i3 < 4; i3++) {
            byte[] bArr = this.f33397b;
            if (bArr[i3] < 65 || bArr[i3] > 122 || (bArr[i3] > 90 && bArr[i3] < 97)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        byte[] bArr = this.f33399d;
        if (bArr == null || bArr.length < this.f33396a) {
            this.f33399d = new byte[this.f33396a];
        }
    }

    public void a(long j) {
        this.f33401f = j;
    }

    public void a(boolean z) {
        int value = (int) this.f33402g.getValue();
        int c2 = com.kwad.sdk.pngencrypt.n.c(this.f33400e, 0);
        if (value != c2) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f33398c, Long.valueOf(this.f33401f), Integer.valueOf(c2), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.a.a(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
            }
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f33402g == null) {
            this.f33402g = new CRC32();
        }
        this.f33402g.update(bArr, i2, i3);
    }

    public ByteArrayInputStream b() {
        return new ByteArrayInputStream(this.f33399d);
    }

    public long c() {
        return this.f33401f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.f33398c;
            if (str == null) {
                if (dVar.f33398c != null) {
                    return false;
                }
            } else if (!str.equals(dVar.f33398c)) {
                return false;
            }
            return this.f33401f == dVar.f33401f;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f33398c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f33401f;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "chunkid=" + b.a(this.f33397b) + " len=" + this.f33396a;
    }
}
