package com.thunder.livesdk;

import android.media.projection.MediaProjection;
import com.thunder.livesdk.ThunderPublisher;
import com.thunder.livesdk.helper.ThunderNative;
import com.thunder.livesdk.log.ThunderLog;
/* loaded from: classes6.dex */
public class ThunderScreenCapture extends ThunderDefaultCamera {
    private boolean islandScape;
    private MediaProjection mediaProjection;

    public ThunderScreenCapture(MediaProjection mediaProjection, boolean z) {
        this.mediaProjection = mediaProjection;
        this.islandScape = z;
    }

    public MediaProjection getMediaProjection() {
        return this.mediaProjection;
    }

    public boolean isLandscap() {
        return this.islandScape;
    }

    public void setIslandScape(boolean z) {
        this.islandScape = z;
    }

    public void changeScreenLiveMode(boolean z, Object obj) {
        if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagCall, "changeScreenLiveMode %b", Boolean.valueOf(z));
        }
        ThunderNative.changeScreenLiveMode(z, obj);
    }

    @Override // com.thunder.livesdk.ThunderDefaultCamera, com.thunder.livesdk.ThunderVideoCapture
    public void startCapture(ThunderPublisher.IVideoPublisher iVideoPublisher) {
        super.startCapture(iVideoPublisher);
    }

    @Override // com.thunder.livesdk.ThunderDefaultCamera, com.thunder.livesdk.ThunderVideoCapture
    public void stopCapture() {
        super.stopCapture();
    }

    @Override // com.thunder.livesdk.ThunderDefaultCamera, com.thunder.livesdk.ThunderVideoCapture
    public ThunderVideoCaptureConfig getCaptureConfig() {
        return super.getCaptureConfig();
    }
}
