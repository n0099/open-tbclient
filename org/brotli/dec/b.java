package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int bufferOffset;
    private int nBe;
    private final j nBf;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.nBf = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.nBe = 0;
        this.bufferOffset = 0;
        try {
            j.a(this.nBf, inputStream);
            if (bArr != null) {
                d.a(this.nBf, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.nBf);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bufferOffset >= this.nBe) {
            this.nBe = read(this.buffer, 0, this.buffer.length);
            this.bufferOffset = 0;
            if (this.nBe == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.bufferOffset;
        this.bufferOffset = i + 1;
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
        int max = Math.max(this.nBe - this.bufferOffset, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.bufferOffset, bArr, i, max);
            this.bufferOffset += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.nBf.output = bArr;
            this.nBf.nCq = i;
            this.nBf.nCr = i2;
            this.nBf.nCs = 0;
            d.i(this.nBf);
            if (this.nBf.nCs == 0) {
                return -1;
            }
            return max + this.nBf.nCs;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
