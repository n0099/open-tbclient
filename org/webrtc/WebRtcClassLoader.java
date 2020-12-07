package org.webrtc;
/* loaded from: classes12.dex */
class WebRtcClassLoader {
    WebRtcClassLoader() {
    }

    @CalledByNative
    static Object getClassLoader() {
        return WebRtcClassLoader.class.getClassLoader();
    }
}
