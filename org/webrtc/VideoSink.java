package org.webrtc;
/* loaded from: classes10.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
