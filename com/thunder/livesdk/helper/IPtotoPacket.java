package com.thunder.livesdk.helper;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public interface IPtotoPacket {
    void marshall(ByteBuffer byteBuffer);

    byte[] marshall();

    void unmarshall(ByteBuffer byteBuffer);

    void unmarshall(byte[] bArr);
}
