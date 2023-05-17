package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes10.dex */
public final class PusherMsgInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_ET = "";
    public static final String DEFAULT_TASK_ID = "";
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String et;
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

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.Builder<PusherMsgInfo> {
        public String content;
        public String et;
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
            if (pusherMsgInfo == null) {
                return;
            }
            this.groupId = pusherMsgInfo.groupId;
            this.msgId = pusherMsgInfo.msgId;
            this.pushTime = pusherMsgInfo.pushTime;
            this.type = pusherMsgInfo.type;
            this.content = pusherMsgInfo.content;
            this.et = pusherMsgInfo.et;
            this.groupType = pusherMsgInfo.groupType;
            this.task_id = pusherMsgInfo.task_id;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PusherMsgInfo build(boolean z) {
            return new PusherMsgInfo(this, z);
        }
    }

    public PusherMsgInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            Long l2 = builder.msgId;
            if (l2 == null) {
                this.msgId = DEFAULT_MSGID;
            } else {
                this.msgId = l2;
            }
            Long l3 = builder.pushTime;
            if (l3 == null) {
                this.pushTime = DEFAULT_PUSHTIME;
            } else {
                this.pushTime = l3;
            }
            Integer num = builder.type;
            if (num == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num;
            }
            String str = builder.content;
            if (str == null) {
                this.content = "";
            } else {
                this.content = str;
            }
            String str2 = builder.et;
            if (str2 == null) {
                this.et = "";
            } else {
                this.et = str2;
            }
            Integer num2 = builder.groupType;
            if (num2 == null) {
                this.groupType = DEFAULT_GROUPTYPE;
            } else {
                this.groupType = num2;
            }
            String str3 = builder.task_id;
            if (str3 == null) {
                this.task_id = "";
                return;
            } else {
                this.task_id = str3;
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
    }
}
