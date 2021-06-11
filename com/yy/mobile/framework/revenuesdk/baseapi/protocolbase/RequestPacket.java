package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public abstract class RequestPacket extends Marshallable {
    public abstract int getPacketSize();

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PacketBase, com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public byte[] marshall() {
        ByteBuffer allocate = ByteBuffer.allocate(getPacketSize());
        this.buffer = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        marshall(this.buffer);
        pushPacketData();
        return this.buffer.array();
    }

    public abstract void pushPacketData();
}
