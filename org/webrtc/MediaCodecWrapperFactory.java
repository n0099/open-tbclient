package org.webrtc;

import java.io.IOException;
/* loaded from: classes9.dex */
public interface MediaCodecWrapperFactory {
    MediaCodecWrapper createByCodecName(String str) throws IOException;
}
