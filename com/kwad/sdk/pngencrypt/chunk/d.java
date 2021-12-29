package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes3.dex */
public class d {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f59301b;

    /* renamed from: c  reason: collision with root package name */
    public final String f59302c;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f59306g;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f59303d = null;

    /* renamed from: f  reason: collision with root package name */
    public long f59305f = 0;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f59304e = new byte[4];

    public d(int i2, String str, boolean z) {
        this.a = i2;
        this.f59302c = str;
        this.f59301b = b.a(str);
        for (int i3 = 0; i3 < 4; i3++) {
            byte[] bArr = this.f59301b;
            if (bArr[i3] < 65 || bArr[i3] > 122 || (bArr[i3] > 90 && bArr[i3] < 97)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        byte[] bArr = this.f59303d;
        if (bArr == null || bArr.length < this.a) {
            this.f59303d = new byte[this.a];
        }
    }

    public void a(long j2) {
        this.f59305f = j2;
    }

    public void a(boolean z) {
        int value = (int) this.f59306g.getValue();
        int c2 = com.kwad.sdk.pngencrypt.n.c(this.f59304e, 0);
        if (value != c2) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f59302c, Long.valueOf(this.f59305f), Integer.valueOf(c2), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.a.a(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
            }
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f59306g == null) {
            this.f59306g = new CRC32();
        }
        this.f59306g.update(bArr, i2, i3);
    }

    public ByteArrayInputStream b() {
        return new ByteArrayInputStream(this.f59303d);
    }

    public long c() {
        return this.f59305f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.f59302c;
            if (str == null) {
                if (dVar.f59302c != null) {
                    return false;
                }
            } else if (!str.equals(dVar.f59302c)) {
                return false;
            }
            return this.f59305f == dVar.f59305f;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f59302c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j2 = this.f59305f;
        return ((hashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "chunkid=" + b.a(this.f59301b) + " len=" + this.a;
    }
}
