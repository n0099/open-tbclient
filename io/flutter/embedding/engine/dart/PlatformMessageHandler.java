package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public interface PlatformMessageHandler {
    void handleMessageFromDart(@NonNull String str, @Nullable byte[] bArr, int i);

    void handlePlatformMessageResponse(int i, @Nullable byte[] bArr);
}
