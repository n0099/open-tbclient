package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class GodInfo extends Message {
    public static final String DEFAULT_FORUMNAME = "";
    public static final String DEFAULT_INTRO = "";
    public static final String DEFAULT_PREFIX = "";
    public static final String DEFAULT_RECOMMENDREASON = "";
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer canSendMsg;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long fid;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer followed;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long id;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String intro;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String prefix;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String recommendReason;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer type;
    public static final Long DEFAULT_ID = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Long DEFAULT_FID = 0L;
    public static final Integer DEFAULT_FOLLOWED = 0;
    public static final Integer DEFAULT_CANSENDMSG = 0;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<GodInfo> {
        public Integer canSendMsg;
        public Long fid;
        public Integer followed;
        public String forumName;
        public Long id;
        public String intro;
        public String prefix;
        public String recommendReason;
        public Integer type;

        public Builder() {
        }

        public Builder(GodInfo godInfo) {
            super(godInfo);
            if (godInfo == null) {
                return;
            }
            this.id = godInfo.id;
            this.intro = godInfo.intro;
            this.type = godInfo.type;
            this.fid = godInfo.fid;
            this.followed = godInfo.followed;
            this.recommendReason = godInfo.recommendReason;
            this.forumName = godInfo.forumName;
            this.canSendMsg = godInfo.canSendMsg;
            this.prefix = godInfo.prefix;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GodInfo build(boolean z) {
            return new GodInfo(this, z);
        }
    }

    public GodInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.id;
            if (l == null) {
                this.id = DEFAULT_ID;
            } else {
                this.id = l;
            }
            String str = builder.intro;
            if (str == null) {
                this.intro = "";
            } else {
                this.intro = str;
            }
            Integer num = builder.type;
            if (num == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num;
            }
            Long l2 = builder.fid;
            if (l2 == null) {
                this.fid = DEFAULT_FID;
            } else {
                this.fid = l2;
            }
            Integer num2 = builder.followed;
            if (num2 == null) {
                this.followed = DEFAULT_FOLLOWED;
            } else {
                this.followed = num2;
            }
            String str2 = builder.recommendReason;
            if (str2 == null) {
                this.recommendReason = "";
            } else {
                this.recommendReason = str2;
            }
            String str3 = builder.forumName;
            if (str3 == null) {
                this.forumName = "";
            } else {
                this.forumName = str3;
            }
            Integer num3 = builder.canSendMsg;
            if (num3 == null) {
                this.canSendMsg = DEFAULT_CANSENDMSG;
            } else {
                this.canSendMsg = num3;
            }
            String str4 = builder.prefix;
            if (str4 == null) {
                this.prefix = "";
                return;
            } else {
                this.prefix = str4;
                return;
            }
        }
        this.id = builder.id;
        this.intro = builder.intro;
        this.type = builder.type;
        this.fid = builder.fid;
        this.followed = builder.followed;
        this.recommendReason = builder.recommendReason;
        this.forumName = builder.forumName;
        this.canSendMsg = builder.canSendMsg;
        this.prefix = builder.prefix;
    }
}
