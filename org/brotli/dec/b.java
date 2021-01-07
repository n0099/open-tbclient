package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int qpA;
    private int qpB;
    private final j qpC;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.qpC = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.qpA = 0;
        this.qpB = 0;
        try {
            j.a(this.qpC, inputStream);
            if (bArr != null) {
                d.a(this.qpC, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.qpC);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.qpB >= this.qpA) {
            this.qpA = read(this.buffer, 0, this.buffer.length);
            this.qpB = 0;
            if (this.qpA == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.qpB;
        this.qpB = i + 1;
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
        int max = Math.max(this.qpA - this.qpB, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.qpB, bArr, i, max);
            this.qpB += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.qpC.output = bArr;
            this.qpC.qqN = i;
            this.qpC.qqO = i2;
            this.qpC.qqP = 0;
            d.i(this.qpC);
            if (this.qpC.qqP == 0) {
                return -1;
            }
            return max + this.qpC.qqP;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
