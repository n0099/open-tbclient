package io.flutter.embedding.engine.renderer;
/* loaded from: classes9.dex */
public interface RenderSurface {
    void attachToRenderer(FlutterRenderer flutterRenderer);

    void detachFromRenderer();

    FlutterRenderer getAttachedRenderer();
}
