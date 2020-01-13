package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int bufferOffset;
    private int nJC;
    private final j nJD;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.nJD = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.nJC = 0;
        this.bufferOffset = 0;
        try {
            j.a(this.nJD, inputStream);
            if (bArr != null) {
                d.a(this.nJD, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.nJD);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bufferOffset >= this.nJC) {
            this.nJC = read(this.buffer, 0, this.buffer.length);
            this.bufferOffset = 0;
            if (this.nJC == -1) {
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
        int max = Math.max(this.nJC - this.bufferOffset, 0);
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
            this.nJD.output = bArr;
            this.nJD.nKO = i;
            this.nJD.nKP = i2;
            this.nJD.nKQ = 0;
            d.i(this.nJD);
            if (this.nJD.nKQ == 0) {
                return -1;
            }
            return max + this.nJD.nKQ;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
