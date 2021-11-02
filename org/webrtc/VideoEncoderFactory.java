package org.webrtc;

import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public interface VideoEncoderFactory {
    @Nullable
    @CalledByNative
    VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo);

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();
}
