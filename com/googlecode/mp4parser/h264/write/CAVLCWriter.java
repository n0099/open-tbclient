package com.googlecode.mp4parser.h264.write;

import com.baidu.searchbox.track.ui.TrackUI;
import com.googlecode.mp4parser.h264.Debug;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public class CAVLCWriter extends BitstreamWriter {
    public CAVLCWriter(OutputStream outputStream) {
        super(outputStream);
    }

    public void writeBool(boolean z, String str) throws IOException {
        Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
        write1Bit(z ? 1 : 0);
        Debug.println(TrackUI.SEPERATOR + z);
    }

    public void writeNBit(long j, int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
        for (int i2 = 0; i2 < i; i2++) {
            write1Bit(((int) (j >> ((i - i2) - 1))) & 1);
        }
        Debug.println(TrackUI.SEPERATOR + j);
    }

    public void writeSE(int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
        writeUE(((i << 1) * (i < 0 ? -1 : 1)) + (i <= 0 ? 0 : 1));
        Debug.println(TrackUI.SEPERATOR + i);
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
        Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
        writeNBit((long) i, i2);
        Debug.println(TrackUI.SEPERATOR + i);
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

    public void writeU(int i, int i2) throws IOException {
        writeNBit(i, i2);
    }

    public void writeUE(int i, String str) throws IOException {
        Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
        writeUE(i);
        Debug.println(TrackUI.SEPERATOR + i);
    }
}
