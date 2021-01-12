package org.webrtc;
/* loaded from: classes9.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
