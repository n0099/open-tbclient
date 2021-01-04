package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int qnS;
    private int qnT;
    private final j qnU;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.qnU = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.qnS = 0;
        this.qnT = 0;
        try {
            j.a(this.qnU, inputStream);
            if (bArr != null) {
                d.a(this.qnU, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.qnU);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.qnT >= this.qnS) {
            this.qnS = read(this.buffer, 0, this.buffer.length);
            this.qnT = 0;
            if (this.qnS == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.qnT;
        this.qnT = i + 1;
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
        int max = Math.max(this.qnS - this.qnT, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.qnT, bArr, i, max);
            this.qnT += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.qnU.output = bArr;
            this.qnU.qpf = i;
            this.qnU.qpg = i2;
            this.qnU.qph = 0;
            d.i(this.qnU);
            if (this.qnU.qph == 0) {
                return -1;
            }
            return max + this.qnU.qph;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
