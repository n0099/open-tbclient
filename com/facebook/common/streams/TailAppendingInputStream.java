package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class TailAppendingInputStream extends FilterInputStream {
    public int mMarkedTailOffset;
    public final byte[] mTail;
    public int mTailOffset;

    public TailAppendingInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (inputStream == null) {
            throw null;
        }
        if (bArr != null) {
            this.mTail = bArr;
            return;
        }
        throw null;
    }

    private int readNextTailByte() {
        int i2 = this.mTailOffset;
        byte[] bArr = this.mTail;
        if (i2 >= bArr.length) {
            return -1;
        }
        this.mTailOffset = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        if (((FilterInputStream) this).in.markSupported()) {
            super.mark(i2);
            this.mMarkedTailOffset = this.mTailOffset;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        return read != -1 ? read : readNextTailByte();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (((FilterInputStream) this).in.markSupported()) {
            ((FilterInputStream) this).in.reset();
            this.mTailOffset = this.mMarkedTailOffset;
            return;
        }
        throw new IOException("mark is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i2, i3);
        if (read != -1) {
            return read;
        }
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        while (i4 < i3) {
            int readNextTailByte = readNextTailByte();
            if (readNextTailByte == -1) {
                break;
            }
            bArr[i2 + i4] = (byte) readNextTailByte;
            i4++;
        }
        if (i4 > 0) {
            return i4;
        }
        return -1;
    }
}
