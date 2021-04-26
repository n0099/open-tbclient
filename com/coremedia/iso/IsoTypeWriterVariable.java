package com.coremedia.iso;

import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes6.dex */
public final class IsoTypeWriterVariable {
    public static void write(long j, ByteBuffer byteBuffer, int i2) {
        if (i2 == 1) {
            IsoTypeWriter.writeUInt8(byteBuffer, (int) (j & 255));
        } else if (i2 == 2) {
            IsoTypeWriter.writeUInt16(byteBuffer, (int) (j & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        } else if (i2 == 3) {
            IsoTypeWriter.writeUInt24(byteBuffer, (int) (j & 16777215));
        } else if (i2 == 4) {
            IsoTypeWriter.writeUInt32(byteBuffer, j);
        } else if (i2 == 8) {
            IsoTypeWriter.writeUInt64(byteBuffer, j);
        } else {
            throw new RuntimeException("I don't know how to read " + i2 + " bytes");
        }
    }
}
