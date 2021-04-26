package com.googlecode.mp4parser.h264.write;

import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public class BitstreamWriter {
    public int curBit;
    public int[] curByte = new int[8];
    public final OutputStream os;

    public BitstreamWriter(OutputStream outputStream) {
        this.os = outputStream;
    }

    private void writeCurByte() throws IOException {
        int[] iArr = this.curByte;
        this.os.write(iArr[7] | (iArr[0] << 7) | (iArr[1] << 6) | (iArr[2] << 5) | (iArr[3] << 4) | (iArr[4] << 3) | (iArr[5] << 2) | (iArr[6] << 1));
    }

    public void flush() throws IOException {
        for (int i2 = this.curBit; i2 < 8; i2++) {
            this.curByte[i2] = 0;
        }
        this.curBit = 0;
        writeCurByte();
    }

    public void write1Bit(int i2) throws IOException {
        Debug.print(i2);
        if (this.curBit == 8) {
            this.curBit = 0;
            writeCurByte();
        }
        int[] iArr = this.curByte;
        int i3 = this.curBit;
        this.curBit = i3 + 1;
        iArr[i3] = i2;
    }

    public void writeByte(int i2) throws IOException {
        this.os.write(i2);
    }

    public void writeNBit(long j, int i2) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            write1Bit(((int) (j >> ((i2 - i3) - 1))) & 1);
        }
    }

    public void writeRemainingZero() throws IOException {
        writeNBit(0L, 8 - this.curBit);
    }
}
