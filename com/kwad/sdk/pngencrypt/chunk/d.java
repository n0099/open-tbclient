package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f36856a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f36857b;

    /* renamed from: c  reason: collision with root package name */
    public final String f36858c;

    /* renamed from: g  reason: collision with root package name */
    public CRC32 f36862g;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f36859d = null;

    /* renamed from: f  reason: collision with root package name */
    public long f36861f = 0;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f36860e = new byte[4];

    public d(int i2, String str, boolean z) {
        this.f36856a = i2;
        this.f36858c = str;
        this.f36857b = b.a(str);
        for (int i3 = 0; i3 < 4; i3++) {
            byte[] bArr = this.f36857b;
            if (bArr[i3] < 65 || bArr[i3] > 122 || (bArr[i3] > 90 && bArr[i3] < 97)) {
                com.kwad.sdk.core.d.a.a(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            a();
        }
    }

    public void a() {
        byte[] bArr = this.f36859d;
        if (bArr == null || bArr.length < this.f36856a) {
            this.f36859d = new byte[this.f36856a];
        }
    }

    public void a(long j) {
        this.f36861f = j;
    }

    public void a(boolean z) {
        int value = (int) this.f36862g.getValue();
        int c2 = com.kwad.sdk.pngencrypt.n.c(this.f36860e, 0);
        if (value != c2) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.f36858c, Long.valueOf(this.f36861f), Integer.valueOf(c2), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.a.a(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.a.a("PNG_ENCRYPT", format);
            }
        }
    }

    public void a(byte[] bArr, int i2, int i3) {
        if (this.f36862g == null) {
            this.f36862g = new CRC32();
        }
        this.f36862g.update(bArr, i2, i3);
    }

    public ByteArrayInputStream b() {
        return new ByteArrayInputStream(this.f36859d);
    }

    public long c() {
        return this.f36861f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.f36858c;
            if (str == null) {
                if (dVar.f36858c != null) {
                    return false;
                }
            } else if (!str.equals(dVar.f36858c)) {
                return false;
            }
            return this.f36861f == dVar.f36861f;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f36858c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f36861f;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "chunkid=" + b.a(this.f36857b) + " len=" + this.f36856a;
    }
}
