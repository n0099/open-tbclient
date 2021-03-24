package org.webrtc;

import org.webrtc.VideoDecoder;
/* loaded from: classes7.dex */
public class VideoDecoderWrapper {
    @CalledByNative
    public static VideoDecoder.Callback createDecoderCallback(final long j) {
        return new VideoDecoder.Callback() { // from class: org.webrtc._$$Lambda$VideoDecoderWrapper$m_PB1aePENdovsbFJCs5jSyVCEo
            @Override // org.webrtc.VideoDecoder.Callback
            public final void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2) {
                VideoDecoderWrapper.nativeOnDecodedFrame(j, videoFrame, num, num2);
            }
        };
    }

    public static native void nativeOnDecodedFrame(long j, VideoFrame videoFrame, Integer num, Integer num2);
}
