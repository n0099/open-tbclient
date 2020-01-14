package com.facebook.common.f;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class b extends FilterInputStream {
    private final byte[] lIn;
    private int lIo;
    private int lIp;

    public b(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (inputStream == null) {
            throw new NullPointerException();
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.lIn = bArr;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = this.in.read();
        return read != -1 ? read : djN();
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
                int djN = djN();
                if (djN == -1) {
                    break;
                }
                bArr[i + i3] = (byte) djN;
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
            this.lIo = this.lIp;
            return;
        }
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (this.in.markSupported()) {
            super.mark(i);
            this.lIp = this.lIo;
        }
    }

    private int djN() {
        if (this.lIo >= this.lIn.length) {
            return -1;
        }
        byte[] bArr = this.lIn;
        int i = this.lIo;
        this.lIo = i + 1;
        return bArr[i] & 255;
    }
}
