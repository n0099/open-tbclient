package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes10.dex */
public final class d {
    public final byte[] alA;
    public final String alB;
    public CRC32 alE;
    public final int len;
    public byte[] data = null;
    public long alC = 0;
    public byte[] alD = new byte[4];

    public d(int i, String str, boolean z) {
        this.len = i;
        this.alB = str;
        this.alA = b.dq(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte[] bArr = this.alA;
            if (bArr[i2] < 65 || bArr[i2] > 122 || (bArr[i2] > 90 && bArr[i2] < 97)) {
                com.kwad.sdk.core.e.b.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            yE();
        }
    }

    private void yE() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final void R(long j) {
        this.alC = j;
    }

    public final void aY(boolean z) {
        int value = (int) this.alE.getValue();
        int g = com.kwad.sdk.pngencrypt.n.g(this.alD, 0);
        if (value != g) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.alB, Long.valueOf(this.alC), Integer.valueOf(g), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.e.b.printStackTrace(new PngjException(format));
            } else {
                com.kwad.sdk.core.e.b.d("PNG_ENCRYPT", format);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.alB;
            if (str == null) {
                if (dVar.alB != null) {
                    return false;
                }
            } else if (!str.equals(dVar.alB)) {
                return false;
            }
            return this.alC == dVar.alC;
        }
        return false;
    }

    public final void f(byte[] bArr, int i, int i2) {
        if (this.alE == null) {
            this.alE = new CRC32();
        }
        this.alE.update(bArr, i, i2);
    }

    public final int hashCode() {
        String str = this.alB;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.alC;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.i(this.alA) + " len=" + this.len;
    }

    public final ByteArrayInputStream yF() {
        return new ByteArrayInputStream(this.data);
    }

    public final long yG() {
        return this.alC;
    }
}
