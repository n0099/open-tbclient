package io.flutter.plugin.common;

import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public interface BinaryMessenger {

    /* loaded from: classes9.dex */
    public interface BinaryMessageHandler {
        void onMessage(ByteBuffer byteBuffer, BinaryReply binaryReply);
    }

    /* loaded from: classes9.dex */
    public interface BinaryReply {
        void reply(ByteBuffer byteBuffer);
    }

    void send(String str, ByteBuffer byteBuffer);

    void send(String str, ByteBuffer byteBuffer, BinaryReply binaryReply);

    void setMessageHandler(String str, BinaryMessageHandler binaryMessageHandler);
}
