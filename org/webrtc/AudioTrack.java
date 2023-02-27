package org.webrtc;
/* loaded from: classes9.dex */
public class AudioTrack extends MediaStreamTrack {
    public static native void nativeSetVolume(long j, double d);

    public AudioTrack(long j) {
        super(j);
    }

    public void setVolume(double d) {
        nativeSetVolume(getNativeAudioTrack(), d);
    }

    public long getNativeAudioTrack() {
        return getNativeMediaStreamTrack();
    }
}
