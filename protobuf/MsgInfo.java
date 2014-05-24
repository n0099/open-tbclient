package protobuf;

import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class MsgInfo extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_LINK = "";
    public static final String DEFAULT_STAT = "";
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer createTime;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer duration;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String link;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long msgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer msgType;
    @ProtoField(tag = 9, type = Message.Datatype.INT64)
    public final Long recordId;
    @ProtoField(tag = DealIntentService.CLASS_TYPE_GROUP_EVENT, type = Message.Datatype.STRING)
    public final String stat;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 15, type = Message.Datatype.INT64)
    public final Long taskId;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long toUid;
    @ProtoField(tag = 12)
    public final UserInfo toUserInfo;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 10)
    public final UserInfo userInfo;
    public static final Long DEFAULT_MSGID = 0L;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_MSGTYPE = 0;
    public static final Long DEFAULT_USERID = 0L;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_DURATION = 0;
    public static final Integer DEFAULT_CREATETIME = 0;
    public static final Long DEFAULT_RECORDID = 0L;
    public static final Long DEFAULT_TOUID = 0L;
    public static final Long DEFAULT_TASKID = 0L;

    /* synthetic */ MsgInfo(Builder builder, boolean z, MsgInfo msgInfo) {
        this(builder, z);
    }

    private MsgInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.msgId == null) {
                this.msgId = DEFAULT_MSGID;
            } else {
                this.msgId = builder.msgId;
            }
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.msgType == null) {
                this.msgType = DEFAULT_MSGTYPE;
            } else {
                this.msgType = builder.msgType;
            }
            if (builder.userId == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = builder.userId;
            }
            if (builder.content == null) {
                this.content = "";
            } else {
                this.content = builder.content;
            }
            if (builder.status == null) {
                this.status = DEFAULT_STATUS;
            } else {
                this.status = builder.status;
            }
            if (builder.duration == null) {
                this.duration = DEFAULT_DURATION;
            } else {
                this.duration = builder.duration;
            }
            if (builder.createTime == null) {
                this.createTime = DEFAULT_CREATETIME;
            } else {
                this.createTime = builder.createTime;
            }
            if (builder.recordId == null) {
                this.recordId = DEFAULT_RECORDID;
            } else {
                this.recordId = builder.recordId;
            }
            this.userInfo = builder.userInfo;
            if (builder.toUid == null) {
                this.toUid = DEFAULT_TOUID;
            } else {
                this.toUid = builder.toUid;
            }
            this.toUserInfo = builder.toUserInfo;
            if (builder.link == null) {
                this.link = "";
            } else {
                this.link = builder.link;
            }
            if (builder.stat == null) {
                this.stat = "";
            } else {
                this.stat = builder.stat;
            }
            if (builder.taskId == null) {
                this.taskId = DEFAULT_TASKID;
                return;
            } else {
                this.taskId = builder.taskId;
                return;
            }
        }
        this.msgId = builder.msgId;
        this.groupId = builder.groupId;
        this.msgType = builder.msgType;
        this.userId = builder.userId;
        this.content = builder.content;
        this.status = builder.status;
        this.duration = builder.duration;
        this.createTime = builder.createTime;
        this.recordId = builder.recordId;
        this.userInfo = builder.userInfo;
        this.toUid = builder.toUid;
        this.toUserInfo = builder.toUserInfo;
        this.link = builder.link;
        this.stat = builder.stat;
        this.taskId = builder.taskId;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<MsgInfo> {
        public String content;
        public Integer createTime;
        public Integer duration;
        public Integer groupId;
        public String link;
        public Long msgId;
        public Integer msgType;
        public Long recordId;
        public String stat;
        public Integer status;
        public Long taskId;
        public Long toUid;
        public UserInfo toUserInfo;
        public Long userId;
        public UserInfo userInfo;

        public Builder(MsgInfo msgInfo) {
            super(msgInfo);
            if (msgInfo != null) {
                this.msgId = msgInfo.msgId;
                this.groupId = msgInfo.groupId;
                this.msgType = msgInfo.msgType;
                this.userId = msgInfo.userId;
                this.content = msgInfo.content;
                this.status = msgInfo.status;
                this.duration = msgInfo.duration;
                this.createTime = msgInfo.createTime;
                this.recordId = msgInfo.recordId;
                this.userInfo = msgInfo.userInfo;
                this.toUid = msgInfo.toUid;
                this.toUserInfo = msgInfo.toUserInfo;
                this.link = msgInfo.link;
                this.stat = msgInfo.stat;
                this.taskId = msgInfo.taskId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public MsgInfo build(boolean z) {
            return new MsgInfo(this, z, null);
        }
    }
}
