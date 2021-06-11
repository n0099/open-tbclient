package org.webrtc;

import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class RtpSender {
    @Nullable
    public MediaStreamTrack cachedTrack;
    @Nullable
    public final DtmfSender dtmfSender;
    public long nativeRtpSender;
    public boolean ownsTrack = true;

    @CalledByNative
    public RtpSender(long j) {
        this.nativeRtpSender = j;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j));
        long nativeGetDtmfSender = nativeGetDtmfSender(j);
        this.dtmfSender = nativeGetDtmfSender != 0 ? new DtmfSender(nativeGetDtmfSender) : null;
    }

    private void checkRtpSenderExists() {
        if (this.nativeRtpSender == 0) {
            throw new IllegalStateException("RtpSender has been disposed.");
        }
    }

    public static native long nativeGetDtmfSender(long j);

    public static native String nativeGetId(long j);

    public static native RtpParameters nativeGetParameters(long j);

    public static native long nativeGetTrack(long j);

    public static native void nativeSetFrameEncryptor(long j, long j2);

    public static native boolean nativeSetParameters(long j, RtpParameters rtpParameters);

    public static native boolean nativeSetTrack(long j, long j2);

    public void dispose() {
        checkRtpSenderExists();
        DtmfSender dtmfSender = this.dtmfSender;
        if (dtmfSender != null) {
            dtmfSender.dispose();
        }
        MediaStreamTrack mediaStreamTrack = this.cachedTrack;
        if (mediaStreamTrack != null && this.ownsTrack) {
            mediaStreamTrack.dispose();
        }
        JniCommon.nativeReleaseRef(this.nativeRtpSender);
        this.nativeRtpSender = 0L;
    }

    @Nullable
    public DtmfSender dtmf() {
        return this.dtmfSender;
    }

    public long getNativeRtpSender() {
        checkRtpSenderExists();
        return this.nativeRtpSender;
    }

    public RtpParameters getParameters() {
        checkRtpSenderExists();
        return nativeGetParameters(this.nativeRtpSender);
    }

    public String id() {
        checkRtpSenderExists();
        return nativeGetId(this.nativeRtpSender);
    }

    public void setFrameEncryptor(FrameEncryptor frameEncryptor) {
        checkRtpSenderExists();
        nativeSetFrameEncryptor(this.nativeRtpSender, frameEncryptor.getNativeFrameEncryptor());
    }

    public boolean setParameters(RtpParameters rtpParameters) {
        checkRtpSenderExists();
        return nativeSetParameters(this.nativeRtpSender, rtpParameters);
    }

    public boolean setTrack(@Nullable MediaStreamTrack mediaStreamTrack, boolean z) {
        checkRtpSenderExists();
        if (nativeSetTrack(this.nativeRtpSender, mediaStreamTrack == null ? 0L : mediaStreamTrack.getNativeMediaStreamTrack())) {
            MediaStreamTrack mediaStreamTrack2 = this.cachedTrack;
            if (mediaStreamTrack2 != null && this.ownsTrack) {
                mediaStreamTrack2.dispose();
            }
            this.cachedTrack = mediaStreamTrack;
            this.ownsTrack = z;
            return true;
        }
        return false;
    }

    @Nullable
    public MediaStreamTrack track() {
        return this.cachedTrack;
    }
}
