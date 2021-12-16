package org.webrtc;

import java.io.IOException;
/* loaded from: classes4.dex */
public interface MediaCodecWrapperFactory {
    MediaCodecWrapper createByCodecName(String str) throws IOException;
}
