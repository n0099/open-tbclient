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

    public void writeNBit(long j, int i2, String str) throws IOException {
        Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
        for (int i3 = 0; i3 < i2; i3++) {
            write1Bit(((int) (j >> ((i2 - i3) - 1))) & 1);
        }
        Debug.println(TrackUI.SEPERATOR + j);
    }

    public void writeSE(int i2, String str) throws IOException {
        Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
        writeUE(((i2 << 1) * (i2 < 0 ? -1 : 1)) + (i2 <= 0 ? 0 : 1));
        Debug.println(TrackUI.SEPERATOR + i2);
    }

    public void writeSliceTrailingBits() {
        throw new IllegalStateException("todo");
    }

    public void writeTrailingBits() throws IOException {
        write1Bit(1);
        writeRemainingZero();
        flush();
    }

    public void writeU(int i2, int i3, String str) throws IOException {
        Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
        writeNBit((long) i2, i3);
        Debug.println(TrackUI.SEPERATOR + i2);
    }

    public void writeUE(int i2) throws IOException {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= 15) {
                break;
            }
            int i6 = (1 << i4) + i5;
            if (i2 < i6) {
                i3 = i4;
                break;
            } else {
                i4++;
                i5 = i6;
            }
        }
        writeNBit(0L, i3);
        write1Bit(1);
        writeNBit(i2 - i5, i3);
    }

    public void writeU(int i2, int i3) throws IOException {
        writeNBit(i2, i3);
    }

    public void writeUE(int i2, String str) throws IOException {
        Debug.print(String.valueOf(str) + TrackUI.SEPERATOR);
        writeUE(i2);
        Debug.println(TrackUI.SEPERATOR + i2);
    }
}
