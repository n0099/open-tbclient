package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes9.dex */
public class PacketBase implements IPacket {
    public ByteBuffer buffer;

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void marshall(ByteBuffer byteBuffer) {
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void unmarshall(ByteBuffer byteBuffer) {
    }

    public PacketBase() {
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

    public PacketBase(byte[] bArr) {
        unmarshall(bArr);
    }

    public void checkPacket(int i) throws Exception {
        ByteBuffer byteBuffer = this.buffer;
        if (byteBuffer != null) {
            if (byteBuffer.capacity() - this.buffer.position() >= i) {
                return;
            }
            throw new Exception("cause stack overflow exception when unmarshall the pack");
        }
        throw new Exception("call supper unmarshall before pop data");
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void unmarshall(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.buffer = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        unmarshall(this.buffer);
    }
}
