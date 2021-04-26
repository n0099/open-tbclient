package org.webrtc;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes7.dex */
public class RtpParameters {
    public final List<Codec> codecs;
    public final List<Encoding> encodings;
    public final List<HeaderExtension> headerExtensions;
    public final Rtcp rtcp;
    public final String transactionId;

    /* loaded from: classes7.dex */
    public static class Codec {
        public Integer clockRate;
        public MediaStreamTrack.MediaType kind;
        public String name;
        public Integer numChannels;
        public Map<String, String> parameters;
        public int payloadType;

        @CalledByNative("Codec")
        public Codec(int i2, String str, MediaStreamTrack.MediaType mediaType, Integer num, Integer num2, Map<String, String> map) {
            this.payloadType = i2;
            this.name = str;
            this.kind = mediaType;
            this.clockRate = num;
            this.numChannels = num2;
            this.parameters = map;
        }

        @CalledByNative("Codec")
        public Integer getClockRate() {
            return this.clockRate;
        }

        @CalledByNative("Codec")
        public MediaStreamTrack.MediaType getKind() {
            return this.kind;
        }

        @CalledByNative("Codec")
        public String getName() {
            return this.name;
        }

        @CalledByNative("Codec")
        public Integer getNumChannels() {
            return this.numChannels;
        }

        @CalledByNative("Codec")
        public Map getParameters() {
            return this.parameters;
        }

        @CalledByNative("Codec")
        public int getPayloadType() {
            return this.payloadType;
        }
    }

    /* loaded from: classes7.dex */
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
        public Encoding(boolean z, Integer num, Integer num2, Integer num3, Integer num4, Long l) {
            this.active = true;
            this.active = z;
            this.maxBitrateBps = num;
            this.minBitrateBps = num2;
            this.maxFramerate = num3;
            this.numTemporalLayers = num4;
            this.ssrc = l;
        }

        @CalledByNative("Encoding")
        public boolean getActive() {
            return this.active;
        }

        @Nullable
        @CalledByNative("Encoding")
        public Integer getMaxBitrateBps() {
            return this.maxBitrateBps;
        }

        @Nullable
        @CalledByNative("Encoding")
        public Integer getMaxFramerate() {
            return this.maxFramerate;
        }

        @Nullable
        @CalledByNative("Encoding")
        public Integer getMinBitrateBps() {
            return this.minBitrateBps;
        }

        @Nullable
        @CalledByNative("Encoding")
        public Integer getNumTemporalLayers() {
            return this.numTemporalLayers;
        }

        @CalledByNative("Encoding")
        public Long getSsrc() {
            return this.ssrc;
        }
    }

    /* loaded from: classes7.dex */
    public static class HeaderExtension {
        public final boolean encrypted;
        public final int id;
        public final String uri;

        @CalledByNative("HeaderExtension")
        public HeaderExtension(String str, int i2, boolean z) {
            this.uri = str;
            this.id = i2;
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

    /* loaded from: classes7.dex */
    public static class Rtcp {
        public final String cname;
        public final boolean reducedSize;

        @CalledByNative("Rtcp")
        public Rtcp(String str, boolean z) {
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
    public RtpParameters(String str, Rtcp rtcp, List<HeaderExtension> list, List<Encoding> list2, List<Codec> list3) {
        this.transactionId = str;
        this.rtcp = rtcp;
        this.headerExtensions = list;
        this.encodings = list2;
        this.codecs = list3;
    }

    @CalledByNative
    public List<Codec> getCodecs() {
        return this.codecs;
    }

    @CalledByNative
    public List<Encoding> getEncodings() {
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
    public String getTransactionId() {
        return this.transactionId;
    }
}
