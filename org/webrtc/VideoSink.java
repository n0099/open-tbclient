package org.webrtc;
/* loaded from: classes16.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
