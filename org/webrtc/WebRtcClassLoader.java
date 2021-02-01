package org.webrtc;
/* loaded from: classes10.dex */
class WebRtcClassLoader {
    WebRtcClassLoader() {
    }

    @CalledByNative
    static Object getClassLoader() {
        return WebRtcClassLoader.class.getClassLoader();
    }
}
