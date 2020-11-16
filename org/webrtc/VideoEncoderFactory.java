package org.webrtc;

import android.support.annotation.Nullable;
/* loaded from: classes16.dex */
public interface VideoEncoderFactory {
    @CalledByNative
    @Nullable
    VideoEncoder createEncoder(VideoCodecInfo videoCodecInfo);

    @CalledByNative
    VideoCodecInfo[] getSupportedCodecs();
}
