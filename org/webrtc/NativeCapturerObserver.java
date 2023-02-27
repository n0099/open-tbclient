package org.webrtc;

import org.webrtc.VideoFrame;
/* loaded from: classes9.dex */
public class NativeCapturerObserver implements CapturerObserver {
    public static VideoSink myHookSink;
    public final long nativeSource;
    public final SurfaceTextureHelper surfaceTextureHelper;

    public static native void nativeCapturerStarted(long j, boolean z);

    public static native void nativeCapturerStopped(long j);

    public static native void nativeOnFrameCaptured(long j, int i, int i2, int i3, long j2, VideoFrame.Buffer buffer);

    @CalledByNative
    public NativeCapturerObserver(long j) {
        this.nativeSource = j;
        this.surfaceTextureHelper = null;
    }

    public static void setMyHookSink(VideoSink videoSink) {
        myHookSink = videoSink;
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean z) {
        nativeCapturerStarted(this.nativeSource, z);
    }

    @Override // org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        VideoSink videoSink = myHookSink;
        if (videoSink != null) {
            videoSink.onFrame(videoFrame);
        }
        nativeOnFrameCaptured(this.nativeSource, videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getBuffer());
    }

    public NativeCapturerObserver(long j, SurfaceTextureHelper surfaceTextureHelper) {
        this.nativeSource = j;
        this.surfaceTextureHelper = surfaceTextureHelper;
    }

    public void dispose() {
        SurfaceTextureHelper surfaceTextureHelper = this.surfaceTextureHelper;
        if (surfaceTextureHelper != null) {
            surfaceTextureHelper.dispose();
        }
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStopped() {
        nativeCapturerStopped(this.nativeSource);
    }
}
