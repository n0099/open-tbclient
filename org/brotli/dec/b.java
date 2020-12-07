package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int pMn;
    private int pMo;
    private final j pMp;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.pMp = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.pMn = 0;
        this.pMo = 0;
        try {
            j.a(this.pMp, inputStream);
            if (bArr != null) {
                d.a(this.pMp, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.pMp);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.pMo >= this.pMn) {
            this.pMn = read(this.buffer, 0, this.buffer.length);
            this.pMo = 0;
            if (this.pMn == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.pMo;
        this.pMo = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Bad offset: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Bad length: " + i2);
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException("Buffer overflow: " + (i + i2) + " > " + bArr.length);
        }
        if (i2 == 0) {
            return 0;
        }
        int max = Math.max(this.pMn - this.pMo, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.pMo, bArr, i, max);
            this.pMo += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.pMp.output = bArr;
            this.pMp.pNA = i;
            this.pMp.pNB = i2;
            this.pMp.pNC = 0;
            d.i(this.pMp);
            if (this.pMp.pNC == 0) {
                return -1;
            }
            return max + this.pMp.pNC;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
