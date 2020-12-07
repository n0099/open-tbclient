package org.webrtc;

import android.support.annotation.Nullable;
import java.util.List;
import java.util.Map;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes12.dex */
public class RtpParameters {
    public final List<Codec> codecs;
    public final List<Encoding> encodings;
    private final List<HeaderExtension> headerExtensions;
    private final Rtcp rtcp;
    public final String transactionId;

    /* loaded from: classes12.dex */
    public static class Codec {
        public Integer clockRate;
        MediaStreamTrack.MediaType kind;
        public String name;
        public Integer numChannels;
        public Map<String, String> parameters;
        public int payloadType;

        @CalledByNative("Codec")
        Codec(int i, String str, MediaStreamTrack.MediaType mediaType, Integer num, Integer num2, Map<String, String> map) {
            this.payloadType = i;
            this.name = str;
            this.kind = mediaType;
            this.clockRate = num;
            this.numChannels = num2;
            this.parameters = map;
        }

        @CalledByNative("Codec")
        Integer getClockRate() {
            return this.clockRate;
        }

        @CalledByNative("Codec")
        MediaStreamTrack.MediaType getKind() {
            return this.kind;
        }

        @CalledByNative("Codec")
        String getName() {
            return this.name;
        }

        @CalledByNative("Codec")
        Integer getNumChannels() {
            return this.numChannels;
        }

        @CalledByNative("Codec")
        Map getParameters() {
            return this.parameters;
        }

        @CalledByNative("Codec")
        int getPayloadType() {
            return this.payloadType;
        }
    }

    /* loaded from: classes12.dex */
    public static class Encoding {
        public boolean active;
        @Nullable
        public Integer maxBitrateBps;
        @Nullable
        public Integer maxFramerate;
        @Nullable
        public Integer minBitrateBps;
        @Nullable
        public Integer numTemporalLayers;
        public Long ssrc;

        @CalledByNative("Encoding")
        Encoding(boolean z, Integer num, Integer num2, Integer num3, Integer num4, Long l) {
            this.active = true;
            this.active = z;
            this.maxBitrateBps = num;
            this.minBitrateBps = num2;
            this.maxFramerate = num3;
            this.numTemporalLayers = num4;
            this.ssrc = l;
        }

        @CalledByNative("Encoding")
        boolean getActive() {
            return this.active;
        }

        @CalledByNative("Encoding")
        @Nullable
        Integer getMaxBitrateBps() {
            return this.maxBitrateBps;
        }

        @CalledByNative("Encoding")
        @Nullable
        Integer getMaxFramerate() {
            return this.maxFramerate;
        }

        @CalledByNative("Encoding")
        @Nullable
        Integer getMinBitrateBps() {
            return this.minBitrateBps;
        }

        @CalledByNative("Encoding")
        @Nullable
        Integer getNumTemporalLayers() {
            return this.numTemporalLayers;
        }

        @CalledByNative("Encoding")
        Long getSsrc() {
            return this.ssrc;
        }
    }

    /* loaded from: classes12.dex */
    public static class HeaderExtension {
        private final boolean encrypted;
        private final int id;
        private final String uri;

        @CalledByNative("HeaderExtension")
        HeaderExtension(String str, int i, boolean z) {
            this.uri = str;
            this.id = i;
            this.encrypted = z;
        }

        @CalledByNative("HeaderExtension")
        public boolean getEncrypted() {
            return this.encrypted;
        }

        @CalledByNative("HeaderExtension")
        public int getId() {
            return this.id;
        }

        @CalledByNative("HeaderExtension")
        public String getUri() {
            return this.uri;
        }
    }

    /* loaded from: classes12.dex */
    public static class Rtcp {
        private final String cname;
        private final boolean reducedSize;

        @CalledByNative("Rtcp")
        Rtcp(String str, boolean z) {
            this.cname = str;
            this.reducedSize = z;
        }

        @CalledByNative("Rtcp")
        public String getCname() {
            return this.cname;
        }

        @CalledByNative("Rtcp")
        public boolean getReducedSize() {
            return this.reducedSize;
        }
    }

    @CalledByNative
    RtpParameters(String str, Rtcp rtcp, List<HeaderExtension> list, List<Encoding> list2, List<Codec> list3) {
        this.transactionId = str;
        this.rtcp = rtcp;
        this.headerExtensions = list;
        this.encodings = list2;
        this.codecs = list3;
    }

    @CalledByNative
    List<Codec> getCodecs() {
        return this.codecs;
    }

    @CalledByNative
    List<Encoding> getEncodings() {
        return this.encodings;
    }

    @CalledByNative
    public List<HeaderExtension> getHeaderExtensions() {
        return this.headerExtensions;
    }

    @CalledByNative
    public Rtcp getRtcp() {
        return this.rtcp;
    }

    @CalledByNative
    String getTransactionId() {
        return this.transactionId;
    }
}
