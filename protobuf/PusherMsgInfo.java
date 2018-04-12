package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class PusherMsgInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_ET = "";
    public static final String DEFAULT_FOLLOW_ID = "";
    public static final String DEFAULT_FOLLOW_TYPE = "";
    public static final String DEFAULT_TASK_ID = "";
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String et;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String follow_id;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String follow_type;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer groupType;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long pushTime;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String task_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Long DEFAULT_PUSHTIME = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_GROUPTYPE = 0;

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
            } else {
                this.groupType = builder.groupType;
            }
            if (builder.task_id == null) {
                this.task_id = "";
            } else {
                this.task_id = builder.task_id;
            }
            if (builder.follow_id == null) {
                this.follow_id = "";
            } else {
                this.follow_id = builder.follow_id;
            }
            if (builder.follow_type == null) {
                this.follow_type = "";
                return;
            } else {
                this.follow_type = builder.follow_type;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.msgId = builder.msgId;
        this.pushTime = builder.pushTime;
        this.type = builder.type;
        this.content = builder.content;
        this.et = builder.et;
        this.groupType = builder.groupType;
        this.task_id = builder.task_id;
        this.follow_id = builder.follow_id;
        this.follow_type = builder.follow_type;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<PusherMsgInfo> {
        public String content;
        public String et;
        public String follow_id;
        public String follow_type;
        public Long groupId;
        public Integer groupType;
        public Long msgId;
        public Long pushTime;
        public String task_id;
        public Integer type;

        public Builder() {
        }

        public Builder(PusherMsgInfo pusherMsgInfo) {
            super(pusherMsgInfo);
            if (pusherMsgInfo != null) {
                this.groupId = pusherMsgInfo.groupId;
                this.msgId = pusherMsgInfo.msgId;
                this.pushTime = pusherMsgInfo.pushTime;
                this.type = pusherMsgInfo.type;
                this.content = pusherMsgInfo.content;
                this.et = pusherMsgInfo.et;
                this.groupType = pusherMsgInfo.groupType;
                this.task_id = pusherMsgInfo.task_id;
                this.follow_id = pusherMsgInfo.follow_id;
                this.follow_type = pusherMsgInfo.follow_type;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PusherMsgInfo build(boolean z) {
            return new PusherMsgInfo(this, z);
        }
    }
}
