package org.webrtc;

import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public interface VideoEncoderFactory {
    @Nullable
    VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo);

    VideoCodecInfo[] getSupportedCodecs();
}
