package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int qvC;
    private int qvD;
    private final j qvE;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.qvE = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.qvC = 0;
        this.qvD = 0;
        try {
            j.a(this.qvE, inputStream);
            if (bArr != null) {
                d.a(this.qvE, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.qvE);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.qvD >= this.qvC) {
            this.qvC = read(this.buffer, 0, this.buffer.length);
            this.qvD = 0;
            if (this.qvC == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.qvD;
        this.qvD = i + 1;
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
        int max = Math.max(this.qvC - this.qvD, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.qvD, bArr, i, max);
            this.qvD += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.qvE.output = bArr;
            this.qvE.qwP = i;
            this.qvE.qwQ = i2;
            this.qvE.qwR = 0;
            d.i(this.qvE);
            if (this.qvE.qwR == 0) {
                return -1;
            }
            return max + this.qvE.qwR;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
