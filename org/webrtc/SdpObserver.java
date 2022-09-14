package org.webrtc;
/* loaded from: classes9.dex */
public interface SdpObserver {
    @CalledByNative
    void onCreateFailure(String str);

    @CalledByNative
    void onCreateSuccess(SessionDescription sessionDescription);

    @CalledByNative
    void onSetFailure(String str);

    @CalledByNative
    void onSetSuccess();
}
