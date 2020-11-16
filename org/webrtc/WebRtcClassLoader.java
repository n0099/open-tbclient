package org.webrtc;
/* loaded from: classes16.dex */
class WebRtcClassLoader {
    WebRtcClassLoader() {
    }

    @CalledByNative
    static Object getClassLoader() {
        return WebRtcClassLoader.class.getClassLoader();
    }
}
