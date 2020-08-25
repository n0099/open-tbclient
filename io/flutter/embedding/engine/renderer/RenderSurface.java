package io.flutter.embedding.engine.renderer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes19.dex */
public interface RenderSurface {
    void attachToRenderer(@NonNull FlutterRenderer flutterRenderer);

    void detachFromRenderer();

    @Nullable
    FlutterRenderer getAttachedRenderer();
}
