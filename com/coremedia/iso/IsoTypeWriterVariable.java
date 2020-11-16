package com.coremedia.iso;

import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public final class IsoTypeWriterVariable {
    public static void write(long j, ByteBuffer byteBuffer, int i) {
        switch (i) {
            case 1:
                IsoTypeWriter.writeUInt8(byteBuffer, (int) (255 & j));
                return;
            case 2:
                IsoTypeWriter.writeUInt16(byteBuffer, (int) (65535 & j));
                return;
            case 3:
                IsoTypeWriter.writeUInt24(byteBuffer, (int) (16777215 & j));
                return;
            case 4:
                IsoTypeWriter.writeUInt32(byteBuffer, j);
                return;
            case 5:
            case 6:
            case 7:
            default:
                throw new RuntimeException("I don't know how to read " + i + " bytes");
            case 8:
                IsoTypeWriter.writeUInt64(byteBuffer, j);
                return;
        }
    }
}
