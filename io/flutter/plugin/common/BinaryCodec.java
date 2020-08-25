package io.flutter.plugin.common;

import java.nio.ByteBuffer;
/* loaded from: classes19.dex */
public final class BinaryCodec implements MessageCodec<ByteBuffer> {
    public static final BinaryCodec INSTANCE = new BinaryCodec();

    private BinaryCodec() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer encodeMessage(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer decodeMessage(ByteBuffer byteBuffer) {
        return byteBuffer;
    }
}
