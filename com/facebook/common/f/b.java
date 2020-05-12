package com.facebook.common.f;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes13.dex */
public class b extends FilterInputStream {
    private final byte[] lSl;
    private int lSm;
    private int lSn;

    public b(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (inputStream == null) {
            throw new NullPointerException();
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.lSl = bArr;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = this.in.read();
        return read != -1 ? read : dnr();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read == -1) {
            if (i2 == 0) {
                return 0;
            }
            int i3 = 0;
            while (i3 < i2) {
                int dnr = dnr();
                if (dnr == -1) {
                    break;
                }
                bArr[i + i3] = (byte) dnr;
                i3++;
            }
            if (i3 <= 0) {
                return -1;
            }
            return i3;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (this.in.markSupported()) {
            this.in.reset();
            this.lSm = this.lSn;
            return;
        }
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (this.in.markSupported()) {
            super.mark(i);
            this.lSn = this.lSm;
        }
    }

    private int dnr() {
        if (this.lSm >= this.lSl.length) {
            return -1;
        }
        byte[] bArr = this.lSl;
        int i = this.lSm;
        this.lSm = i + 1;
        return bArr[i] & 255;
    }
}
