package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public interface MessageCodec<T> {
    @Nullable
    T decodeMessage(@Nullable ByteBuffer byteBuffer);

    @Nullable
    ByteBuffer encodeMessage(@Nullable T t);
}
