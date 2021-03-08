package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int qwe;
    private int qwf;
    private final j qwg;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.qwg = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.qwe = 0;
        this.qwf = 0;
        try {
            j.a(this.qwg, inputStream);
            if (bArr != null) {
                d.a(this.qwg, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.qwg);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.qwf >= this.qwe) {
            this.qwe = read(this.buffer, 0, this.buffer.length);
            this.qwf = 0;
            if (this.qwe == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.qwf;
        this.qwf = i + 1;
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
        int max = Math.max(this.qwe - this.qwf, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.qwf, bArr, i, max);
            this.qwf += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.qwg.output = bArr;
            this.qwg.qxr = i;
            this.qwg.qxs = i2;
            this.qwg.qxt = 0;
            d.i(this.qwg);
            if (this.qwg.qxt == 0) {
                return -1;
            }
            return max + this.qwg.qxt;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
