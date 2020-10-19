package com.coremedia.iso;

import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public final class IsoTypeReaderVariable {
    public static long read(ByteBuffer byteBuffer, int i) {
        switch (i) {
            case 1:
                return IsoTypeReader.readUInt8(byteBuffer);
            case 2:
                return IsoTypeReader.readUInt16(byteBuffer);
            case 3:
                return IsoTypeReader.readUInt24(byteBuffer);
            case 4:
                return IsoTypeReader.readUInt32(byteBuffer);
            case 5:
            case 6:
            case 7:
            default:
                throw new RuntimeException("I don't know how to read " + i + " bytes");
            case 8:
                return IsoTypeReader.readUInt64(byteBuffer);
        }
    }
}
