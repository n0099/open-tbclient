package org.webrtc;

import java.io.IOException;
/* loaded from: classes8.dex */
public interface MediaCodecWrapperFactory {
    MediaCodecWrapper createByCodecName(String str) throws IOException;
}
