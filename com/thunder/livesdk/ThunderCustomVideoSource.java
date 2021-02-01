package com.thunder.livesdk;
/* loaded from: classes4.dex */
public interface ThunderCustomVideoSource {
    boolean onDispose();

    boolean onInitialize(ThunderVideoFrameConsumer thunderVideoFrameConsumer);

    boolean onStart();

    boolean onStop();
}
