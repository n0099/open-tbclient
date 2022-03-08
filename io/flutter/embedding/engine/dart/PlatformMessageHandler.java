package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public interface PlatformMessageHandler {
    void handleMessageFromDart(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i2);

    void handlePlatformMessageResponse(int i2, @Nullable ByteBuffer byteBuffer);
}
