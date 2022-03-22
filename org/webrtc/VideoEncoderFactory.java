package org.webrtc;

import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public interface VideoEncoderFactory {
    @Nullable
    @CalledByNative
    VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo);

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();
}
