package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public class PacketBase implements IPacket {
    public ByteBuffer buffer;

    public PacketBase() {
    }

    public void checkPacket(int i2) throws Exception {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null) {
            if (byteBuffer.capacity() - this.buffer.position() < i2) {
                throw new Exception("cause stack overflow exception when unmarshall the pack");
            }
            return;
        }
        throw new Exception("call supper unmarshall before pop data");
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void marshall(ByteBuffer byteBuffer) {
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public byte[] marshall() {
        if (this.buffer == null) {
            ByteBuffer allocate = ByteBuffer.allocate(1);
            this.buffer = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        marshall(this.buffer);
        return this.buffer.array();
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void unmarshall(ByteBuffer byteBuffer) {
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void unmarshall(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.buffer = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        unmarshall(this.buffer);
    }

    public PacketBase(byte[] bArr) {
        unmarshall(bArr);
    }
}
