package org.webrtc;
/* loaded from: classes5.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
