package com.coremedia.iso;

import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class IsoTypeReaderVariable {
    public static long read(ByteBuffer byteBuffer, int i) {
        int readUInt8;
        if (i == 1) {
            readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        } else if (i == 2) {
            readUInt8 = IsoTypeReader.readUInt16(byteBuffer);
        } else if (i != 3) {
            if (i != 4) {
                if (i == 8) {
                    return IsoTypeReader.readUInt64(byteBuffer);
                }
                throw new RuntimeException("I don't know how to read " + i + " bytes");
            }
            return IsoTypeReader.readUInt32(byteBuffer);
        } else {
            readUInt8 = IsoTypeReader.readUInt24(byteBuffer);
        }
        return readUInt8;
    }
}
