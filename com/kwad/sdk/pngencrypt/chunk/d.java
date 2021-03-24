package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f36139a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f36140b;

    /* renamed from: c  reason: collision with root package name */
    public final String f36141c;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f36145g;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f36142d = null;

    /* renamed from: f  reason: collision with root package name */
    public long f36144f = 0;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f36143e = new byte[4];

    public d(int i, String str, boolean z) {
        this.f36139a = i;
        this.f36141c = str;
        this.f36140b = b.a(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte[] bArr = this.f36140b;
            if (bArr[i2] < 65 || bArr[i2] > 122 || (bArr[i2] > 90 && bArr[i2] < 97)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        byte[] bArr = this.f36142d;
        if (bArr == null || bArr.length < this.f36139a) {
            this.f36142d = new byte[this.f36139a];
        }
    }

    public void a(long j) {
        this.f36144f = j;
    }

    public void a(boolean z) {
        int value = (int) this.f36145g.getValue();
        int c2 = com.kwad.sdk.pngencrypt.n.c(this.f36143e, 0);
        if (value != c2) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f36141c, Long.valueOf(this.f36144f), Integer.valueOf(c2), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.a.a(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
            }
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f36145g == null) {
            this.f36145g = new CRC32();
        }
        this.f36145g.update(bArr, i, i2);
    }

    public ByteArrayInputStream b() {
        return new ByteArrayInputStream(this.f36142d);
    }

    public long c() {
        return this.f36144f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.f36141c;
            if (str == null) {
                if (dVar.f36141c != null) {
                    return false;
                }
            } else if (!str.equals(dVar.f36141c)) {
                return false;
            }
            return this.f36144f == dVar.f36144f;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f36141c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f36144f;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "chunkid=" + b.a(this.f36140b) + " len=" + this.f36139a;
    }
}
