package com.googlecode.mp4parser.h264.read;

import com.googlecode.mp4parser.h264.CharCache;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes20.dex */
public class BitstreamReader {
    protected static int bitsRead;
    private int curByte;
    protected CharCache debugBits = new CharCache(50);
    private InputStream is;
    int nBit;
    private int nextByte;

    public BitstreamReader(InputStream inputStream) throws IOException {
        this.is = inputStream;
        this.curByte = inputStream.read();
        this.nextByte = inputStream.read();
    }

    public int read1Bit() throws IOException {
        if (this.nBit == 8) {
            advance();
            if (this.curByte == -1) {
                return -1;
            }
        }
        int i = (this.curByte >> (7 - this.nBit)) & 1;
        this.nBit++;
        this.debugBits.append(i == 0 ? '0' : '1');
        bitsRead++;
        return i;
    }

    public long readNBit(int i) throws IOException {
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) | read1Bit();
        }
        return j;
    }

    private void advance() throws IOException {
        this.curByte = this.nextByte;
        this.nextByte = this.is.read();
        this.nBit = 0;
    }

    public int readByte() throws IOException {
        if (this.nBit > 0) {
            advance();
        }
        int i = this.curByte;
        advance();
        return i;
    }

    public boolean moreRBSPData() throws IOException {
        if (this.nBit == 8) {
            advance();
        }
        int i = 1 << ((8 - this.nBit) - 1);
        return (this.curByte == -1 || (this.nextByte == -1 && ((((i << 1) + (-1)) & this.curByte) == i))) ? false : true;
    }

    public long getBitPosition() {
        return (bitsRead * 8) + (this.nBit % 8);
    }

    public long readRemainingByte() throws IOException {
        return readNBit(8 - this.nBit);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r8.curByte == (-1)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int peakNextBits(int i) throws IOException {
        int i2 = -1;
        int i3 = 0;
        if (i > 8) {
            throw new IllegalArgumentException("N should be less then 8");
        }
        if (this.nBit == 8) {
            advance();
        }
        int[] iArr = new int[16 - this.nBit];
        int i4 = this.nBit;
        int i5 = 0;
        while (i4 < 8) {
            iArr[i5] = (this.curByte >> (7 - i4)) & 1;
            i4++;
            i5++;
        }
        int i6 = i5;
        int i7 = 0;
        while (i7 < 8) {
            iArr[i6] = (this.nextByte >> (7 - i7)) & 1;
            i7++;
            i6++;
        }
        i2 = 0;
        while (i3 < i) {
            i3++;
            i2 = iArr[i3] | (i2 << 1);
        }
        return i2;
    }

    public boolean isByteAligned() {
        return this.nBit % 8 == 0;
    }

    public void close() throws IOException {
    }

    public int getCurBit() {
        return this.nBit;
    }
}
