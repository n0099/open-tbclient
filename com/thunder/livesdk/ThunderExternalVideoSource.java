package com.thunder.livesdk;
/* loaded from: classes6.dex */
public abstract class ThunderExternalVideoSource implements ThunderCustomVideoSource {
    public static final int THUNDER_EXTERNAL_VIDEO_TYPE_BUFFER = 1;
    public static final int THUNDER_EXTERNAL_VIDEO_TYPE_TEXTURE = 2;

    @Override // com.thunder.livesdk.ThunderCustomVideoSource
    public boolean onInitialize(ThunderVideoFrameConsumer thunderVideoFrameConsumer) {
        return false;
    }

    @Override // com.thunder.livesdk.ThunderCustomVideoSource
    public boolean onStart() {
        return false;
    }

    @Override // com.thunder.livesdk.ThunderCustomVideoSource
    public boolean onStop() {
        return false;
    }

    @Override // com.thunder.livesdk.ThunderCustomVideoSource
    public boolean onDispose() {
        return false;
    }

    public int getThunderVideoBufferType() {
        return 1;
    }
}
