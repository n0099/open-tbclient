package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public interface PlatformMessageHandler {
    void handleMessageFromDart(@NonNull String str, @Nullable byte[] bArr, int i2);

    void handlePlatformMessageResponse(int i2, @Nullable byte[] bArr);
}
