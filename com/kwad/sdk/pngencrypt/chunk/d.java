package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f36140a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f36141b;

    /* renamed from: c  reason: collision with root package name */
    public final String f36142c;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f36146g;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f36143d = null;

    /* renamed from: f  reason: collision with root package name */
    public long f36145f = 0;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f36144e = new byte[4];

    public d(int i, String str, boolean z) {
        this.f36140a = i;
        this.f36142c = str;
        this.f36141b = b.a(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte[] bArr = this.f36141b;
            if (bArr[i2] < 65 || bArr[i2] > 122 || (bArr[i2] > 90 && bArr[i2] < 97)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        byte[] bArr = this.f36143d;
        if (bArr == null || bArr.length < this.f36140a) {
            this.f36143d = new byte[this.f36140a];
        }
    }

    public void a(long j) {
        this.f36145f = j;
    }

    public void a(boolean z) {
        int value = (int) this.f36146g.getValue();
        int c2 = com.kwad.sdk.pngencrypt.n.c(this.f36144e, 0);
        if (value != c2) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f36142c, Long.valueOf(this.f36145f), Integer.valueOf(c2), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.a.a(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
            }
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f36146g == null) {
            this.f36146g = new CRC32();
        }
        this.f36146g.update(bArr, i, i2);
    }

    public ByteArrayInputStream b() {
        return new ByteArrayInputStream(this.f36143d);
    }

    public long c() {
        return this.f36145f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.f36142c;
            if (str == null) {
                if (dVar.f36142c != null) {
                    return false;
                }
            } else if (!str.equals(dVar.f36142c)) {
                return false;
            }
            return this.f36145f == dVar.f36145f;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f36142c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f36145f;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "chunkid=" + b.a(this.f36141b) + " len=" + this.f36140a;
    }
}
