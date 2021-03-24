package org.webrtc;
/* loaded from: classes7.dex */
public class AudioTrack extends MediaStreamTrack {
    public AudioTrack(long j) {
        super(j);
    }

    public static native void nativeSetVolume(long j, double d2);

    public long getNativeAudioTrack() {
        return getNativeMediaStreamTrack();
    }

    public void setVolume(double d2) {
        nativeSetVolume(getNativeAudioTrack(), d2);
    }
}
