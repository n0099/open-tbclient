package org.webrtc;
/* loaded from: classes10.dex */
public class VideoSource extends MediaSource {
    private final NativeCapturerObserver capturerObserver;

    public VideoSource(long j) {
        super(j);
        this.capturerObserver = new NativeCapturerObserver(nativeGetInternalSource(j));
    }

    private static native void nativeAdaptOutputFormat(long j, int i, int i2, int i3, int i4, int i5);

    private static native long nativeGetInternalSource(long j);

    public void adaptOutputFormat(int i, int i2, int i3) {
        int max = Math.max(i, i2);
        int min = Math.min(i, i2);
        adaptOutputFormat(max, min, min, max, i3);
    }

    public void adaptOutputFormat(int i, int i2, int i3, int i4, int i5) {
        nativeAdaptOutputFormat(getNativeVideoTrackSource(), i, i2, i3, i4, i5);
    }

    public CapturerObserver getCapturerObserver() {
        return this.capturerObserver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeVideoTrackSource() {
        return getNativeMediaSource();
    }
}
