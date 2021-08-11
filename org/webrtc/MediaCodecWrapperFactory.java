package org.webrtc;

import java.io.IOException;
/* loaded from: classes2.dex */
public interface MediaCodecWrapperFactory {
    MediaCodecWrapper createByCodecName(String str) throws IOException;
}
