package org.webrtc;

import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public interface VideoDecoderFactory {
    @Nullable
    @Deprecated
    VideoDecoder createDecoder(String str);

    @Nullable
    @CalledByNative
    VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo);

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();
}
