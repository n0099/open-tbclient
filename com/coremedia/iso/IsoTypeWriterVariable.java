package com.coremedia.iso;

import java.nio.ByteBuffer;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes5.dex */
public final class IsoTypeWriterVariable {
    public static void write(long j, ByteBuffer byteBuffer, int i) {
        if (i == 1) {
            IsoTypeWriter.writeUInt8(byteBuffer, (int) (j & 255));
        } else if (i == 2) {
            IsoTypeWriter.writeUInt16(byteBuffer, (int) (j & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        } else if (i == 3) {
            IsoTypeWriter.writeUInt24(byteBuffer, (int) (j & 16777215));
        } else if (i == 4) {
            IsoTypeWriter.writeUInt32(byteBuffer, j);
        } else if (i == 8) {
            IsoTypeWriter.writeUInt64(byteBuffer, j);
        } else {
            throw new RuntimeException("I don't know how to read " + i + " bytes");
        }
    }
}
