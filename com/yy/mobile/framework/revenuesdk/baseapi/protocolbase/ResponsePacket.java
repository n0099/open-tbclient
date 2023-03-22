package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;
/* loaded from: classes9.dex */
public abstract class ResponsePacket extends Marshallable {
    public abstract void popPacketData();

    public ResponsePacket() {
    }

    public ResponsePacket(byte[] bArr) {
        unmarshall(bArr);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PacketBase, com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void unmarshall(byte[] bArr) {
        super.unmarshall(bArr);
        popPacketData();
    }
}
