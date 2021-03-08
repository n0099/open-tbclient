package io.flutter.plugin.common;

import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
public interface MethodCodec {
    Object decodeEnvelope(ByteBuffer byteBuffer);

    MethodCall decodeMethodCall(ByteBuffer byteBuffer);

    ByteBuffer encodeErrorEnvelope(String str, String str2, Object obj);

    ByteBuffer encodeMethodCall(MethodCall methodCall);

    ByteBuffer encodeSuccessEnvelope(Object obj);
}
