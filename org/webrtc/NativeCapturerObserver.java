package org.webrtc;

import org.webrtc.VideoFrame;
/* loaded from: classes10.dex */
public class NativeCapturerObserver implements CapturerObserver {
    private static VideoSink myHookSink;
    private final long nativeSource;
    private final SurfaceTextureHelper surfaceTextureHelper;

    @CalledByNative
    public NativeCapturerObserver(long j) {
        this.nativeSource = j;
        this.surfaceTextureHelper = null;
    }

    public NativeCapturerObserver(long j, SurfaceTextureHelper surfaceTextureHelper) {
        this.nativeSource = j;
        this.surfaceTextureHelper = surfaceTextureHelper;
    }

    private static native void nativeCapturerStarted(long j, boolean z);

    private static native void nativeCapturerStopped(long j);

    private static native void nativeOnFrameCaptured(long j, int i, int i2, int i3, long j2, VideoFrame.Buffer buffer);

    public static void setMyHookSink(VideoSink videoSink) {
        myHookSink = videoSink;
    }

    public void dispose() {
        if (this.surfaceTextureHelper != null) {
            this.surfaceTextureHelper.dispose();
        }
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean z) {
        nativeCapturerStarted(this.nativeSource, z);
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStopped() {
        nativeCapturerStopped(this.nativeSource);
    }

    @Override // org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        if (myHookSink != null) {
            myHookSink.onFrame(videoFrame);
        }
        nativeOnFrameCaptured(this.nativeSource, videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getBuffer());
    }
}
