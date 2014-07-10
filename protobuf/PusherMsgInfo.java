package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class PusherMsgInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Long DEFAULT_PUSHTIME = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long pushTime;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;

    /* synthetic */ PusherMsgInfo(Builder builder, boolean z, PusherMsgInfo pusherMsgInfo) {
        this(builder, z);
    }

    private PusherMsgInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.msgId == null) {
                this.msgId = DEFAULT_MSGID;
            } else {
                this.msgId = builder.msgId;
            }
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
                return;
            } else {
                this.content = builder.content;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.msgId = builder.msgId;
        this.pushTime = builder.pushTime;
        this.type = builder.type;
        this.content = builder.content;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<PusherMsgInfo> {
        public String content;
        public Integer groupId;
        public Long msgId;
        public Long pushTime;
        public Integer type;

        public Builder(PusherMsgInfo pusherMsgInfo) {
            super(pusherMsgInfo);
            if (pusherMsgInfo != null) {
                this.groupId = pusherMsgInfo.groupId;
                this.msgId = pusherMsgInfo.msgId;
                this.pushTime = pusherMsgInfo.pushTime;
                this.type = pusherMsgInfo.type;
                this.content = pusherMsgInfo.content;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PusherMsgInfo build(boolean z) {
            return new PusherMsgInfo(this, z, null);
        }
    }
}
