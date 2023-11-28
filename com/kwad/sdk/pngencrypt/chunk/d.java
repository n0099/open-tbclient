package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;
/* loaded from: classes10.dex */
public final class d {
    public final byte[] aKq;
    public CRC32 aKt;
    public final String agT;
    public final int len;
    public byte[] data = null;
    public long aKr = 0;
    public byte[] aKs = new byte[4];

    public d(int i, String str, boolean z) {
        this.len = i;
        this.agT = str;
        this.aKq = b.fA(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte[] bArr = this.aKq;
            if (bArr[i2] < 65 || bArr[i2] > 122 || (bArr[i2] > 90 && bArr[i2] < 97)) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z) {
            IH();
        }
    }

    private void IH() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final ByteArrayInputStream II() {
        return new ByteArrayInputStream(this.data);
    }

    public final long IJ() {
        return this.aKr;
    }

    public final int hashCode() {
        int hashCode;
        String str = this.agT;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j = this.aKr;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.i(this.aKq) + " len=" + this.len;
    }

    public final void av(long j) {
        this.aKr = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.agT;
        if (str == null) {
            if (dVar.agT != null) {
                return false;
            }
        } else if (!str.equals(dVar.agT)) {
            return false;
        }
        if (this.aKr == dVar.aKr) {
            return true;
        }
        return false;
    }

    public final void bF(boolean z) {
        int value = (int) this.aKt.getValue();
        int g = com.kwad.sdk.pngencrypt.n.g(this.aKs, 0);
        if (value != g) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.agT, Long.valueOf(this.aKr), Integer.valueOf(g), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException(format));
            } else {
                com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", format);
            }
        }
    }

    public final void f(byte[] bArr, int i, int i2) {
        if (this.aKt == null) {
            this.aKt = new CRC32();
        }
        this.aKt.update(bArr, i, i2);
    }
}
