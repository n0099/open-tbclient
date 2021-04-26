package org.webrtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes7.dex */
public class RtpTransceiver {
    public RtpReceiver cachedReceiver;
    public RtpSender cachedSender;
    public long nativeRtpTransceiver;

    /* loaded from: classes7.dex */
    public enum RtpTransceiverDirection {
        SEND_RECV(0),
        SEND_ONLY(1),
        RECV_ONLY(2),
        INACTIVE(3);
        
        public final int nativeIndex;

        RtpTransceiverDirection(int i2) {
            this.nativeIndex = i2;
        }

        @CalledByNative("RtpTransceiverDirection")
        public static RtpTransceiverDirection fromNativeIndex(int i2) {
            RtpTransceiverDirection[] values;
            for (RtpTransceiverDirection rtpTransceiverDirection : values()) {
                if (rtpTransceiverDirection.getNativeIndex() == i2) {
                    return rtpTransceiverDirection;
                }
            }
            throw new IllegalArgumentException("Uknown native RtpTransceiverDirection type" + i2);
        }

        @CalledByNative("RtpTransceiverDirection")
        public int getNativeIndex() {
            return this.nativeIndex;
        }
    }

    /* loaded from: classes7.dex */
    public static final class RtpTransceiverInit {
        public final RtpTransceiverDirection direction;
        public final List<String> streamIds;

        public RtpTransceiverInit() {
            this(RtpTransceiverDirection.SEND_RECV);
        }

        public RtpTransceiverInit(RtpTransceiverDirection rtpTransceiverDirection) {
            this(rtpTransceiverDirection, Collections.emptyList());
        }

        public RtpTransceiverInit(RtpTransceiverDirection rtpTransceiverDirection, List<String> list) {
            this.direction = rtpTransceiverDirection;
            this.streamIds = new ArrayList(list);
        }

        @CalledByNative("RtpTransceiverInit")
        public int getDirectionNativeIndex() {
            return this.direction.getNativeIndex();
        }

        @CalledByNative("RtpTransceiverInit")
        public List<String> getStreamIds() {
            return new ArrayList(this.streamIds);
        }
    }

    @CalledByNative
    public RtpTransceiver(long j) {
        this.nativeRtpTransceiver = j;
        this.cachedSender = nativeGetSender(j);
        this.cachedReceiver = nativeGetReceiver(j);
    }

    private void checkRtpTransceiverExists() {
        if (this.nativeRtpTransceiver == 0) {
            throw new IllegalStateException("RtpTransceiver has been disposed.");
        }
    }

    public static native RtpTransceiverDirection nativeCurrentDirection(long j);

    public static native RtpTransceiverDirection nativeDirection(long j);

    public static native MediaStreamTrack.MediaType nativeGetMediaType(long j);

    public static native String nativeGetMid(long j);

    public static native RtpReceiver nativeGetReceiver(long j);

    public static native RtpSender nativeGetSender(long j);

    public static native void nativeSetDirection(long j, RtpTransceiverDirection rtpTransceiverDirection);

    public static native void nativeStop(long j);

    public static native boolean nativeStopped(long j);

    @CalledByNative
    public void dispose() {
        checkRtpTransceiverExists();
        this.cachedSender.dispose();
        this.cachedReceiver.dispose();
        JniCommon.nativeReleaseRef(this.nativeRtpTransceiver);
        this.nativeRtpTransceiver = 0L;
    }

    public RtpTransceiverDirection getCurrentDirection() {
        checkRtpTransceiverExists();
        return nativeCurrentDirection(this.nativeRtpTransceiver);
    }

    public RtpTransceiverDirection getDirection() {
        checkRtpTransceiverExists();
        return nativeDirection(this.nativeRtpTransceiver);
    }

    public MediaStreamTrack.MediaType getMediaType() {
        checkRtpTransceiverExists();
        return nativeGetMediaType(this.nativeRtpTransceiver);
    }

    public String getMid() {
        checkRtpTransceiverExists();
        return nativeGetMid(this.nativeRtpTransceiver);
    }

    public RtpReceiver getReceiver() {
        return this.cachedReceiver;
    }

    public RtpSender getSender() {
        return this.cachedSender;
    }

    public boolean isStopped() {
        checkRtpTransceiverExists();
        return nativeStopped(this.nativeRtpTransceiver);
    }

    public void setDirection(RtpTransceiverDirection rtpTransceiverDirection) {
        checkRtpTransceiverExists();
        nativeSetDirection(this.nativeRtpTransceiver, rtpTransceiverDirection);
    }

    public void stop() {
        checkRtpTransceiverExists();
        nativeStop(this.nativeRtpTransceiver);
    }
}
