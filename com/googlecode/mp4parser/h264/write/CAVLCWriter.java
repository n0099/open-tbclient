package com.googlecode.mp4parser.h264.write;

import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes4.dex */
public class CAVLCWriter extends BitstreamWriter {
    public CAVLCWriter(OutputStream outputStream) {
        super(outputStream);
    }

    public void writeU(int i, int i2, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        writeNBit(i, i2);
        Debug.println("\t" + i);
    }

    public void writeUE(int i) throws IOException {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 < 15) {
                if (i < (1 << i2) + i3) {
                    break;
                }
                i3 += 1 << i2;
                i2++;
            } else {
                i2 = 0;
                break;
            }
        }
        writeNBit(0L, i2);
        write1Bit(1);
        writeNBit(i - i3, i2);
    }

    public void writeUE(int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        writeUE(i);
        Debug.println("\t" + i);
    }

    public void writeSE(int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        writeUE((i <= 0 ? 0 : 1) + ((i < 0 ? -1 : 1) * (i << 1)));
        Debug.println("\t" + i);
    }

    public void writeBool(boolean z, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        write1Bit(z ? 1 : 0);
        Debug.println("\t" + z);
    }

    public void writeU(int i, int i2) throws IOException {
        writeNBit(i, i2);
    }

    public void writeNBit(long j, int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + "\t");
        for (int i2 = 0; i2 < i; i2++) {
            write1Bit(((int) (j >> ((i - i2) - 1))) & 1);
        }
        Debug.println("\t" + j);
    }

    public void writeTrailingBits() throws IOException {
        write1Bit(1);
        writeRemainingZero();
        flush();
    }

    public void writeSliceTrailingBits() {
        throw new IllegalStateException("todo");
    }
}
