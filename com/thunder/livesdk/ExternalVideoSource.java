package com.thunder.livesdk;

import com.thunder.livesdk.ThunderPublisher;
import com.thunder.livesdk.log.ThunderLog;
/* loaded from: classes4.dex */
public class ExternalVideoSource extends ThunderVideoCapture {
    ThunderPublisher.IVideoPublisher mPublisher = null;
    private int mVideoBuffType = 1;
    ThunderCustomVideoSource mVideoSource;

    public ExternalVideoSource(ThunderCustomVideoSource thunderCustomVideoSource) {
        this.mVideoSource = null;
        this.mVideoSource = thunderCustomVideoSource;
    }

    public void setVideoBufferType(int i) {
        this.mVideoBuffType = i;
    }

    @Override // com.thunder.livesdk.ThunderVideoCapture
    public void startCapture(ThunderPublisher.IVideoPublisher iVideoPublisher) {
        this.mPublisher = iVideoPublisher;
        if (this.mVideoSource != null) {
            this.mVideoSource.onInitialize(new ThunderVideoFrameConsumer() { // from class: com.thunder.livesdk.ExternalVideoSource.1
                @Override // com.thunder.livesdk.ThunderVideoFrameConsumer
                public void consumeByteArrayFrame(byte[] bArr, int i, int i2, int i3, int i4, long j) {
                    if (ExternalVideoSource.this.mPublisher != null) {
                        ExternalVideoSource.this.mPublisher.pushVideoData(bArr, i, i2, i3, i4, j);
                    }
                }

                @Override // com.thunder.livesdk.ThunderVideoFrameConsumer
                public void consumeTextureFrame(int i, int i2, int i3, int i4, int i5, long j, float[] fArr) {
                    if (ExternalVideoSource.this.mPublisher != null) {
                        ExternalVideoSource.this.mPublisher.pushVideoTexture(i, i2, i3, i4, i5, j, fArr);
                    }
                }

                @Override // com.thunder.livesdk.ThunderVideoFrameConsumer
                public void consumeVideoFrame(ThunderExternalVideoFrame thunderExternalVideoFrame) {
                    if (ExternalVideoSource.this.mPublisher != null) {
                        ExternalVideoSource.this.mPublisher.pushVideoFrame(thunderExternalVideoFrame);
                    }
                }
            });
            this.mVideoSource.onStart();
        } else if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "warning,  need set videoSource...");
        }
    }

    @Override // com.thunder.livesdk.ThunderVideoCapture
    public void stopCapture() {
        if (this.mVideoSource != null) {
            this.mVideoSource.onStop();
            this.mVideoSource.onDispose();
        } else if (ThunderLog.isInfoValid()) {
            ThunderLog.info(ThunderLog.kLogTagRtcEngine, "warning,  need set videoSource...");
        }
    }

    @Override // com.thunder.livesdk.ThunderVideoCapture
    public ThunderVideoCaptureConfig getCaptureConfig() {
        return null;
    }

    public int getExternalVideoBuffType() {
        return this.mVideoBuffType;
    }
}
