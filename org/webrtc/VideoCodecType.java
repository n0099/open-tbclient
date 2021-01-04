package org.webrtc;

import com.baidu.fsg.face.liveness.video.f;
/* loaded from: classes10.dex */
enum VideoCodecType {
    VP8("video/x-vnd.on2.vp8"),
    VP9("video/x-vnd.on2.vp9"),
    H264(f.f2362b);
    
    private final String mimeType;

    VideoCodecType(String str) {
        this.mimeType = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String mimeType() {
        return this.mimeType;
    }
}
