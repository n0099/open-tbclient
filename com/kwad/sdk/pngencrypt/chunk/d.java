package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes7.dex */
public class d {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f40641b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40642c;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f40646g;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f40643d = null;

    /* renamed from: f  reason: collision with root package name */
    public long f40645f = 0;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f40644e = new byte[4];

    public d(int i, String str, boolean z) {
        this.a = i;
        this.f40642c = str;
        this.f40641b = b.a(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte[] bArr = this.f40641b;
            if (bArr[i2] < 65 || bArr[i2] > 122 || (bArr[i2] > 90 && bArr[i2] < 97)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        byte[] bArr = this.f40643d;
        if (bArr == null || bArr.length < this.a) {
            this.f40643d = new byte[this.a];
        }
    }

    public void a(long j) {
        this.f40645f = j;
    }

    public void a(boolean z) {
        int value = (int) this.f40646g.getValue();
        int c2 = com.kwad.sdk.pngencrypt.n.c(this.f40644e, 0);
        if (value != c2) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f40642c, Long.valueOf(this.f40645f), Integer.valueOf(c2), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.a.a(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
            }
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f40646g == null) {
            this.f40646g = new CRC32();
        }
        this.f40646g.update(bArr, i, i2);
    }

    public ByteArrayInputStream b() {
        return new ByteArrayInputStream(this.f40643d);
    }

    public long c() {
        return this.f40645f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.f40642c;
            if (str == null) {
                if (dVar.f40642c != null) {
                    return false;
                }
            } else if (!str.equals(dVar.f40642c)) {
                return false;
            }
            return this.f40645f == dVar.f40645f;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f40642c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f40645f;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "chunkid=" + b.a(this.f40641b) + " len=" + this.a;
    }
}
