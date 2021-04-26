package com.coremedia.iso;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class IsoTypeReaderVariable {
    public static long read(ByteBuffer byteBuffer, int i2) {
        int readUInt8;
        if (i2 == 1) {
            readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        } else if (i2 == 2) {
            readUInt8 = IsoTypeReader.readUInt16(byteBuffer);
        } else if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 8) {
                    return IsoTypeReader.readUInt64(byteBuffer);
                }
                throw new RuntimeException("I don't know how to read " + i2 + " bytes");
            }
            return IsoTypeReader.readUInt32(byteBuffer);
        } else {
            readUInt8 = IsoTypeReader.readUInt24(byteBuffer);
        }
        return readUInt8;
    }
}
