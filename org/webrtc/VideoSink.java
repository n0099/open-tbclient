package org.webrtc;
/* loaded from: classes7.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
