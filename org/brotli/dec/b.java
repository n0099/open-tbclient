package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int qkY;
    private int qkZ;
    private final j qla;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.qla = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.qkY = 0;
        this.qkZ = 0;
        try {
            j.a(this.qla, inputStream);
            if (bArr != null) {
                d.a(this.qla, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.qla);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.qkZ >= this.qkY) {
            this.qkY = read(this.buffer, 0, this.buffer.length);
            this.qkZ = 0;
            if (this.qkY == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.qkZ;
        this.qkZ = i + 1;
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
        int max = Math.max(this.qkY - this.qkZ, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.qkZ, bArr, i, max);
            this.qkZ += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.qla.output = bArr;
            this.qla.qml = i;
            this.qla.qmm = i2;
            this.qla.qmn = 0;
            d.i(this.qla);
            if (this.qla.qmn == 0) {
                return -1;
            }
            return max + this.qla.qmn;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
