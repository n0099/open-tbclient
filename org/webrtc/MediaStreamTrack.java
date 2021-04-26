package org.webrtc;

import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class MediaStreamTrack {
    public static final String AUDIO_TRACK_KIND = "audio";
    public static final String VIDEO_TRACK_KIND = "video";
    public long nativeTrack;

    /* loaded from: classes7.dex */
    public enum MediaType {
        MEDIA_TYPE_AUDIO(0),
        MEDIA_TYPE_VIDEO(1);
        
        public final int nativeIndex;

        MediaType(int i2) {
            this.nativeIndex = i2;
        }

        @CalledByNative("MediaType")
        public static MediaType fromNativeIndex(int i2) {
            MediaType[] values;
            for (MediaType mediaType : values()) {
                if (mediaType.getNative() == i2) {
                    return mediaType;
                }
            }
            throw new IllegalArgumentException("Unknown native media type: " + i2);
        }

        @CalledByNative("MediaType")
        public int getNative() {
            return this.nativeIndex;
        }
    }

    /* loaded from: classes7.dex */
    public enum State {
        LIVE,
        ENDED;

        @CalledByNative("State")
        public static State fromNativeIndex(int i2) {
            return values()[i2];
        }
    }

    public MediaStreamTrack(long j) {
        if (j == 0) {
            throw new IllegalArgumentException("nativeTrack may not be null");
        }
        this.nativeTrack = j;
    }

    private void checkMediaStreamTrackExists() {
        if (this.nativeTrack == 0) {
            throw new IllegalStateException("MediaStreamTrack has been disposed.");
        }
    }

    @Nullable
    public static MediaStreamTrack createMediaStreamTrack(long j) {
        if (j == 0) {
            return null;
        }
        String nativeGetKind = nativeGetKind(j);
        if (nativeGetKind.equals(AUDIO_TRACK_KIND)) {
            return new AudioTrack(j);
        }
        if (nativeGetKind.equals("video")) {
            return new VideoTrack(j);
        }
        return null;
    }

    public static native boolean nativeGetEnabled(long j);

    public static native String nativeGetId(long j);

    public static native String nativeGetKind(long j);

    public static native State nativeGetState(long j);

    public static native boolean nativeSetEnabled(long j, boolean z);

    public void dispose() {
        checkMediaStreamTrackExists();
        JniCommon.nativeReleaseRef(this.nativeTrack);
        this.nativeTrack = 0L;
    }

    public boolean enabled() {
        checkMediaStreamTrackExists();
        return nativeGetEnabled(this.nativeTrack);
    }

    public long getNativeMediaStreamTrack() {
        checkMediaStreamTrackExists();
        return this.nativeTrack;
    }

    public String id() {
        checkMediaStreamTrackExists();
        return nativeGetId(this.nativeTrack);
    }

    public String kind() {
        checkMediaStreamTrackExists();
        return nativeGetKind(this.nativeTrack);
    }

    public boolean setEnabled(boolean z) {
        checkMediaStreamTrackExists();
        return nativeSetEnabled(this.nativeTrack, z);
    }

    public State state() {
        checkMediaStreamTrackExists();
        return nativeGetState(this.nativeTrack);
    }
}
