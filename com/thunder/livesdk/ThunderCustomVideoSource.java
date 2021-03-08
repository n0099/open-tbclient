package com.thunder.livesdk;
/* loaded from: classes6.dex */
public interface ThunderCustomVideoSource {
    boolean onDispose();

    boolean onInitialize(ThunderVideoFrameConsumer thunderVideoFrameConsumer);

    boolean onStart();

    boolean onStop();
}
