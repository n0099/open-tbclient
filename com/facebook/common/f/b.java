package com.facebook.common.f;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes12.dex */
public class b extends FilterInputStream {
    private final byte[] mRv;
    private int mRw;
    private int mRx;

    public b(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (inputStream == null) {
            throw new NullPointerException();
        }
        if (bArr == null) {
            throw new NullPointerException();
        }
        this.mRv = bArr;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = this.in.read();
        return read != -1 ? read : dCS();
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
                int dCS = dCS();
                if (dCS == -1) {
                    break;
                }
                bArr[i + i3] = (byte) dCS;
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
            this.mRw = this.mRx;
            return;
        }
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        if (this.in.markSupported()) {
            super.mark(i);
            this.mRx = this.mRw;
        }
    }

    private int dCS() {
        if (this.mRw >= this.mRv.length) {
            return -1;
        }
        byte[] bArr = this.mRv;
        int i = this.mRw;
        this.mRw = i + 1;
        return bArr[i] & 255;
    }
}
