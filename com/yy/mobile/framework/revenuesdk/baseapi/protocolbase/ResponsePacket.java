package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;
/* loaded from: classes7.dex */
public abstract class ResponsePacket extends Marshallable {
    public ResponsePacket() {
    }

    public abstract void popPacketData();

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PacketBase, com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void unmarshall(byte[] bArr) {
        super.unmarshall(bArr);
        popPacketData();
    }

    public ResponsePacket(byte[] bArr) {
        unmarshall(bArr);
    }
}
