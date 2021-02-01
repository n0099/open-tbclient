package com.thunder.livesdk;

import android.media.projection.MediaProjection;
/* loaded from: classes4.dex */
public class ScreenRecordSource implements ThunderCustomVideoSource {
    public ThunderScreenCapture mScreenCapture;

    public ScreenRecordSource(MediaProjection mediaProjection) {
        this.mScreenCapture = new ThunderScreenCapture(mediaProjection, false);
    }

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
}
