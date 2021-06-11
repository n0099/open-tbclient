package org.webrtc;
/* loaded from: classes8.dex */
public class VideoSource extends MediaSource {
    public final NativeCapturerObserver capturerObserver;

    public VideoSource(long j) {
        super(j);
        this.capturerObserver = new NativeCapturerObserver(nativeGetInternalSource(j));
    }

    public static native void nativeAdaptOutputFormat(long j, int i2, int i3, int i4, int i5, int i6);

    public static native long nativeGetInternalSource(long j);

    public void adaptOutputFormat(int i2, int i3, int i4) {
        int max = Math.max(i2, i3);
        int min = Math.min(i2, i3);
        adaptOutputFormat(max, min, min, max, i4);
    }

    public void adaptOutputFormat(int i2, int i3, int i4, int i5, int i6) {
        nativeAdaptOutputFormat(getNativeVideoTrackSource(), i2, i3, i4, i5, i6);
    }

    public CapturerObserver getCapturerObserver() {
        return this.capturerObserver;
    }

    public long getNativeVideoTrackSource() {
        return getNativeMediaSource();
    }
}
