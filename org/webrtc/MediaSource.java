package org.webrtc;
/* loaded from: classes10.dex */
public class MediaSource {
    private long nativeSource;

    /* loaded from: classes10.dex */
    public enum State {
        INITIALIZING,
        LIVE,
        ENDED,
        MUTED;

        @CalledByNative("State")
        static State fromNativeIndex(int i) {
            return values()[i];
        }
    }

    public MediaSource(long j) {
        this.nativeSource = j;
    }

    private void checkMediaSourceExists() {
        if (this.nativeSource == 0) {
            throw new IllegalStateException("MediaSource has been disposed.");
        }
    }

    private static native State nativeGetState(long j);

    public void dispose() {
        checkMediaSourceExists();
        JniCommon.nativeReleaseRef(this.nativeSource);
        this.nativeSource = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getNativeMediaSource() {
        checkMediaSourceExists();
        return this.nativeSource;
    }

    public State state() {
        checkMediaSourceExists();
        return nativeGetState(this.nativeSource);
    }
}
