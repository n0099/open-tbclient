package com.googlecode.mp4parser.h264.write;

import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes11.dex */
public class BitstreamWriter {
    private int curBit;
    private int[] curByte = new int[8];
    private final OutputStream os;

    public BitstreamWriter(OutputStream outputStream) {
        this.os = outputStream;
    }

    public void flush() throws IOException {
        for (int i = this.curBit; i < 8; i++) {
            this.curByte[i] = 0;
        }
        this.curBit = 0;
        writeCurByte();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [57=6] */
    private void writeCurByte() throws IOException {
        this.os.write((this.curByte[0] << 7) | (this.curByte[1] << 6) | (this.curByte[2] << 5) | (this.curByte[3] << 4) | (this.curByte[4] << 3) | (this.curByte[5] << 2) | (this.curByte[6] << 1) | this.curByte[7]);
    }

    public void write1Bit(int i) throws IOException {
        Debug.print(i);
        if (this.curBit == 8) {
            this.curBit = 0;
            writeCurByte();
        }
        int[] iArr = this.curByte;
        int i2 = this.curBit;
        this.curBit = i2 + 1;
        iArr[i2] = i;
    }

    public void writeNBit(long j, int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            write1Bit(((int) (j >> ((i - i2) - 1))) & 1);
        }
    }

    public void writeRemainingZero() throws IOException {
        writeNBit(0L, 8 - this.curBit);
    }

    public void writeByte(int i) throws IOException {
        this.os.write(i);
    }
}
