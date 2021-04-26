package com.googlecode.mp4parser.h264.read;

import com.googlecode.mp4parser.h264.CharCache;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class BitstreamReader {
    public static int bitsRead;
    public int curByte;
    public CharCache debugBits = new CharCache(50);
    public InputStream is;
    public int nBit;
    public int nextByte;

    public BitstreamReader(InputStream inputStream) throws IOException {
        this.is = inputStream;
        this.curByte = inputStream.read();
        this.nextByte = inputStream.read();
    }

    private void advance() throws IOException {
        this.curByte = this.nextByte;
        this.nextByte = this.is.read();
        this.nBit = 0;
    }

    public void close() throws IOException {
    }

    public long getBitPosition() {
        return (bitsRead * 8) + (this.nBit % 8);
    }

    public int getCurBit() {
        return this.nBit;
    }

    public boolean isByteAligned() {
        return this.nBit % 8 == 0;
    }

    public boolean moreRBSPData() throws IOException {
        if (this.nBit == 8) {
            advance();
        }
        int i2 = 1 << ((8 - this.nBit) - 1);
        return (this.curByte == -1 || (this.nextByte == -1 && ((((i2 << 1) - 1) & this.curByte) == i2))) ? false : true;
    }

    public int peakNextBits(int i2) throws IOException {
        if (i2 <= 8) {
            if (this.nBit == 8) {
                advance();
                if (this.curByte == -1) {
                    return -1;
                }
            }
            int i3 = this.nBit;
            int[] iArr = new int[16 - i3];
            int i4 = 0;
            while (i3 < 8) {
                iArr[i4] = (this.curByte >> (7 - i3)) & 1;
                i3++;
                i4++;
            }
            int i5 = 0;
            while (i5 < 8) {
                iArr[i4] = (this.nextByte >> (7 - i5)) & 1;
                i5++;
                i4++;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                i6 = (i6 << 1) | iArr[i7];
            }
            return i6;
        }
        throw new IllegalArgumentException("N should be less then 8");
    }

    public int read1Bit() throws IOException {
        if (this.nBit == 8) {
            advance();
            if (this.curByte == -1) {
                return -1;
            }
        }
        int i2 = this.curByte;
        int i3 = this.nBit;
        int i4 = (i2 >> (7 - i3)) & 1;
        this.nBit = i3 + 1;
        this.debugBits.append(i4 == 0 ? '0' : '1');
        bitsRead++;
        return i4;
    }

    public int readByte() throws IOException {
        if (this.nBit > 0) {
            advance();
        }
        int i2 = this.curByte;
        advance();
        return i2;
    }

    public long readNBit(int i2) throws IOException {
        if (i2 <= 64) {
            long j = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j = (j << 1) | read1Bit();
            }
            return j;
        }
        throw new IllegalArgumentException("Can not readByte more then 64 bit");
    }

    public long readRemainingByte() throws IOException {
        return readNBit(8 - this.nBit);
    }
}
