package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes3.dex */
public class d {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f57065b;

    /* renamed from: c  reason: collision with root package name */
    public final String f57066c;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f57070g;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f57067d = null;

    /* renamed from: f  reason: collision with root package name */
    public long f57069f = 0;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f57068e = new byte[4];

    public d(int i2, String str, boolean z) {
        this.a = i2;
        this.f57066c = str;
        this.f57065b = b.a(str);
        for (int i3 = 0; i3 < 4; i3++) {
            byte[] bArr = this.f57065b;
            if (bArr[i3] < 65 || bArr[i3] > 122 || (bArr[i3] > 90 && bArr[i3] < 97)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        byte[] bArr = this.f57067d;
        if (bArr == null || bArr.length < this.a) {
            this.f57067d = new byte[this.a];
        }
    }

    public void a(long j2) {
        this.f57069f = j2;
    }

    public void a(boolean z) {
        int value = (int) this.f57070g.getValue();
        int c2 = com.kwad.sdk.pngencrypt.n.c(this.f57068e, 0);
        if (value != c2) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f57066c, Long.valueOf(this.f57069f), Integer.valueOf(c2), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.a.a(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
            }
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f57070g == null) {
            this.f57070g = new CRC32();
        }
        this.f57070g.update(bArr, i2, i3);
    }

    public ByteArrayInputStream b() {
        return new ByteArrayInputStream(this.f57067d);
    }

    public long c() {
        return this.f57069f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.f57066c;
            if (str == null) {
                if (dVar.f57066c != null) {
                    return false;
                }
            } else if (!str.equals(dVar.f57066c)) {
                return false;
            }
            return this.f57069f == dVar.f57069f;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f57066c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j2 = this.f57069f;
        return ((hashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "chunkid=" + b.a(this.f57065b) + " len=" + this.a;
    }
}
