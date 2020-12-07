package org.webrtc;
/* loaded from: classes12.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
