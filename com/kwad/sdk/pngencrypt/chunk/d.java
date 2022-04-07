package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes5.dex */
public class d {
    public final int a;
    public final byte[] b;
    public final String c;
    public CRC32 g;
    public byte[] d = null;
    public long f = 0;
    public byte[] e = new byte[4];

    public d(int i, String str, boolean z) {
        this.a = i;
        this.c = str;
        this.b = b.a(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte[] bArr = this.b;
            if (bArr[i2] < 65 || bArr[i2] > 122 || (bArr[i2] > 90 && bArr[i2] < 97)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        byte[] bArr = this.d;
        if (bArr == null || bArr.length < this.a) {
            this.d = new byte[this.a];
        }
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(boolean z) {
        int value = (int) this.g.getValue();
        int c = com.kwad.sdk.pngencrypt.n.c(this.e, 0);
        if (value != c) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.c, Long.valueOf(this.f), Integer.valueOf(c), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.a.a(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
            }
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.g == null) {
            this.g = new CRC32();
        }
        this.g.update(bArr, i, i2);
    }

    public ByteArrayInputStream b() {
        return new ByteArrayInputStream(this.d);
    }

    public long c() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.c;
            if (str == null) {
                if (dVar.c != null) {
                    return false;
                }
            } else if (!str.equals(dVar.c)) {
                return false;
            }
            return this.f == dVar.f;
        }
        return false;
    }

    public int hashCode() {
        String str = this.c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "chunkid=" + b.a(this.b) + " len=" + this.a;
    }
}
