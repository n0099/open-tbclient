package org.webrtc;
/* loaded from: classes4.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
