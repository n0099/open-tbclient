package org.webrtc.audioengine;
/* loaded from: classes6.dex */
public interface AudioRoutingListener {
    void onAudioRoutingChanged(int i);

    void onBluetoothScoState(int i);

    void onBluetoothState(int i);

    void onHeadsetState(int i);

    void onPhoneCallState(int i);
}
