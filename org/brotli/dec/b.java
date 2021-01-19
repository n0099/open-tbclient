package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class b extends InputStream {
    private byte[] buffer;
    private int qkZ;
    private int qla;
    private final j qlb;

    public b(InputStream inputStream) throws IOException {
        this(inputStream, 16384, null);
    }

    public b(InputStream inputStream, int i, byte[] bArr) throws IOException {
        this.qlb = new j();
        if (i <= 0) {
            throw new IllegalArgumentException("Bad buffer size:" + i);
        }
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.buffer = new byte[i];
        this.qkZ = 0;
        this.qla = 0;
        try {
            j.a(this.qlb, inputStream);
            if (bArr != null) {
                d.a(this.qlb, bArr);
            }
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli decoder initialization failed", e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        j.j(this.qlb);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.qla >= this.qkZ) {
            this.qkZ = read(this.buffer, 0, this.buffer.length);
            this.qla = 0;
            if (this.qkZ == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.qla;
        this.qla = i + 1;
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
        int max = Math.max(this.qkZ - this.qla, 0);
        if (max != 0) {
            max = Math.min(max, i2);
            System.arraycopy(this.buffer, this.qla, bArr, i, max);
            this.qla += max;
            i += max;
            i2 -= max;
            if (i2 == 0) {
                return max;
            }
        }
        try {
            this.qlb.output = bArr;
            this.qlb.qmm = i;
            this.qlb.qmn = i2;
            this.qlb.qmo = 0;
            d.i(this.qlb);
            if (this.qlb.qmo == 0) {
                return -1;
            }
            return max + this.qlb.qmo;
        } catch (BrotliRuntimeException e) {
            throw new IOException("Brotli stream decoding failed", e);
        }
    }
}
