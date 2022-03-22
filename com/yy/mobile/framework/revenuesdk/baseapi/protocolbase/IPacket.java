package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public interface IPacket {
    void marshall(ByteBuffer byteBuffer);

    byte[] marshall();

    void unmarshall(ByteBuffer byteBuffer);

    void unmarshall(byte[] bArr);
}
