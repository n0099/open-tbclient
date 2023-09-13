package com.googlecode.mp4parser.h264.write;

import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes10.dex */
public class CAVLCWriter extends BitstreamWriter {
    public CAVLCWriter(OutputStream outputStream) {
        super(outputStream);
    }

    public void writeUE(int i) throws IOException {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= 15) {
                break;
            }
            int i5 = (1 << i3) + i4;
            if (i < i5) {
                i2 = i3;
                break;
            } else {
                i3++;
                i4 = i5;
            }
        }
        writeNBit(0L, i2);
        write1Bit(1);
        writeNBit(i - i4, i2);
    }

    public void writeBool(boolean z, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        write1Bit(z ? 1 : 0);
        Debug.println("\t" + z);
    }

    public void writeU(int i, int i2) throws IOException {
        writeNBit(i, i2);
    }

    public void writeUE(int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        writeUE(i);
        Debug.println("\t" + i);
    }

    public void writeNBit(long j, int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        for (int i2 = 0; i2 < i; i2++) {
            write1Bit(((int) (j >> ((i - i2) - 1))) & 1);
        }
        Debug.println("\t" + j);
    }

    public void writeSE(int i, String str) throws IOException {
        int i2;
        Debug.print(String.valueOf(str) + "\t");
        int i3 = i << 1;
        int i4 = 1;
        if (i < 0) {
            i2 = -1;
        } else {
            i2 = 1;
        }
        int i5 = i3 * i2;
        if (i <= 0) {
            i4 = 0;
        }
        writeUE(i5 + i4);
        Debug.println("\t" + i);
    }

    public void writeSliceTrailingBits() {
        throw new IllegalStateException("todo");
    }

    public void writeTrailingBits() throws IOException {
        write1Bit(1);
        writeRemainingZero();
        flush();
    }

    public void writeU(int i, int i2, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        writeNBit((long) i, i2);
        Debug.println("\t" + i);
    }
}
