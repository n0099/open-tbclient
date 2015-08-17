package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class PushMsgInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_ET = "";
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String et;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer groupType;
    @ProtoField(tag = 2)
    public final MsgInfo msginfo;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long pushTime;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Long DEFAULT_PUSHTIME = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_GROUPTYPE = 0;

    /* synthetic */ PushMsgInfo(Builder builder, boolean z, PushMsgInfo pushMsgInfo) {
        this(builder, z);
    }

    private PushMsgInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            this.msginfo = builder.msginfo;
            if (builder.pushTime == null) {
                this.pushTime = DEFAULT_PUSHTIME;
            } else {
                this.pushTime = builder.pushTime;
            }
            if (builder.type == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = builder.type;
            }
            if (builder.content == null) {
                this.content = "";
            } else {
                this.content = builder.content;
            }
            if (builder.et == null) {
                this.et = "";
            } else {
                this.et = builder.et;
            }
            if (builder.groupType == null) {
                this.groupType = DEFAULT_GROUPTYPE;
                return;
            } else {
                this.groupType = builder.groupType;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.msginfo = builder.msginfo;
        this.pushTime = builder.pushTime;
        this.type = builder.type;
        this.content = builder.content;
        this.et = builder.et;
        this.groupType = builder.groupType;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<PushMsgInfo> {
        public String content;
        public String et;
        public Integer groupId;
        public Integer groupType;
        public MsgInfo msginfo;
        public Long pushTime;
        public Integer type;

        public Builder() {
        }

        public Builder(PushMsgInfo pushMsgInfo) {
            super(pushMsgInfo);
            if (pushMsgInfo != null) {
                this.groupId = pushMsgInfo.groupId;
                this.msginfo = pushMsgInfo.msginfo;
                this.pushTime = pushMsgInfo.pushTime;
                this.type = pushMsgInfo.type;
                this.content = pushMsgInfo.content;
                this.et = pushMsgInfo.et;
                this.groupType = pushMsgInfo.groupType;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushMsgInfo build(boolean z) {
            return new PushMsgInfo(this, z, null);
        }
    }
}
