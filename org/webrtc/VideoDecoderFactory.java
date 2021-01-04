package org.webrtc;

import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
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
