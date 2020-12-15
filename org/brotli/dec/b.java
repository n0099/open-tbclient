package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes11.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int pMp;
    private int pMq;
    private final j pMr;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.pMr = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.pMp = 0;
        this.pMq = 0;
        try {
            j.a(this.pMr, inputStream);
            if (bArr != null) {
                d.a(this.pMr, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.pMr);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.pMq >= this.pMp) {
            this.pMp = read(this.buffer, 0, this.buffer.length);
            this.pMq = 0;
            if (this.pMp == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.pMq;
        this.pMq = i + 1;
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
        int max = Math.max(this.pMp - this.pMq, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.pMq, bArr, i, max);
            this.pMq += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.pMr.output = bArr;
            this.pMr.pNC = i;
            this.pMr.pND = i2;
            this.pMr.pNE = 0;
            d.i(this.pMr);
            if (this.pMr.pNE == 0) {
                return -1;
            }
            return max + this.pMr.pNE;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
