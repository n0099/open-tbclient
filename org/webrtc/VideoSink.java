package org.webrtc;
/* loaded from: classes2.dex */
public interface VideoSink {
    @CalledByNative
    void onFrame(VideoFrame videoFrame);
}
