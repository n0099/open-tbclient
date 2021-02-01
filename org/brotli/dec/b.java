package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int qvc;
    private int qvd;
    private final j qve;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.qve = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.qvc = 0;
        this.qvd = 0;
        try {
            j.a(this.qve, inputStream);
            if (bArr != null) {
                d.a(this.qve, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.qve);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.qvd >= this.qvc) {
            this.qvc = read(this.buffer, 0, this.buffer.length);
            this.qvd = 0;
            if (this.qvc == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.qvd;
        this.qvd = i + 1;
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
        int max = Math.max(this.qvc - this.qvd, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.qvd, bArr, i, max);
            this.qvd += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.qve.output = bArr;
            this.qve.qwp = i;
            this.qve.qwq = i2;
            this.qve.qwr = 0;
            d.i(this.qve);
            if (this.qve.qwr == 0) {
                return -1;
            }
            return max + this.qve.qwr;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
