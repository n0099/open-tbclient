package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class AlaChallengeInfo extends Message {
    public static final String DEFAULT_EXT = "";
    public static final String DEFAULT_RIVALHLSURL = "";
    public static final String DEFAULT_RIVALRTMPURL = "";
    public static final String DEFAULT_RIVALSESSION = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long challengeId;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String ext;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String rivalHlsUrl;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String rivalRtmpUrl;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String rivalSession;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long winningNum;
    public static final Long DEFAULT_CHALLENGEID = 0L;
    public static final Long DEFAULT_WINNINGNUM = 0L;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<AlaChallengeInfo> {
        public Long challengeId;
        public String ext;
        public String rivalHlsUrl;
        public String rivalRtmpUrl;
        public String rivalSession;
        public Long winningNum;

        public Builder() {
        }

        public Builder(AlaChallengeInfo alaChallengeInfo) {
            super(alaChallengeInfo);
            if (alaChallengeInfo == null) {
                return;
            }
            this.challengeId = alaChallengeInfo.challengeId;
            this.winningNum = alaChallengeInfo.winningNum;
            this.rivalSession = alaChallengeInfo.rivalSession;
            this.rivalRtmpUrl = alaChallengeInfo.rivalRtmpUrl;
            this.rivalHlsUrl = alaChallengeInfo.rivalHlsUrl;
            this.ext = alaChallengeInfo.ext;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public AlaChallengeInfo build(boolean z) {
            return new AlaChallengeInfo(this, z);
        }
    }

    public AlaChallengeInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.challengeId;
            if (l == null) {
                this.challengeId = DEFAULT_CHALLENGEID;
            } else {
                this.challengeId = l;
            }
            Long l2 = builder.winningNum;
            if (l2 == null) {
                this.winningNum = DEFAULT_WINNINGNUM;
            } else {
                this.winningNum = l2;
            }
            String str = builder.rivalSession;
            if (str == null) {
                this.rivalSession = "";
            } else {
                this.rivalSession = str;
            }
            String str2 = builder.rivalRtmpUrl;
            if (str2 == null) {
                this.rivalRtmpUrl = "";
            } else {
                this.rivalRtmpUrl = str2;
            }
            String str3 = builder.rivalHlsUrl;
            if (str3 == null) {
                this.rivalHlsUrl = "";
            } else {
                this.rivalHlsUrl = str3;
            }
            String str4 = builder.ext;
            if (str4 == null) {
                this.ext = "";
                return;
            } else {
                this.ext = str4;
                return;
            }
        }
        this.challengeId = builder.challengeId;
        this.winningNum = builder.winningNum;
        this.rivalSession = builder.rivalSession;
        this.rivalRtmpUrl = builder.rivalRtmpUrl;
        this.rivalHlsUrl = builder.rivalHlsUrl;
        this.ext = builder.ext;
    }
}
