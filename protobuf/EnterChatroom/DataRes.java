package protobuf.EnterChatroom;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer averageWaitTime;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer durationTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 11, type = Message.Datatype.INT64)
    public final Long lastMsgId;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer maxUserNum;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer silenceTime;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(label = Message.Label.REPEATED, tag = 10)
    public final List<ChatroomTopic> topicList;
    @ProtoField(label = Message.Label.REPEATED, tag = 4)
    public final List<UserInfo> userList;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer userNum;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Integer DEFAULT_USERNUM = 0;
    public static final Integer DEFAULT_MAXUSERNUM = 0;
    public static final List<UserInfo> DEFAULT_USERLIST = Collections.emptyList();
    public static final Integer DEFAULT_DURATIONTIME = 0;
    public static final Integer DEFAULT_SILENCETIME = 0;
    public static final Integer DEFAULT_AVERAGEWAITTIME = 0;
    public static final List<ChatroomTopic> DEFAULT_TOPICLIST = Collections.emptyList();
    public static final Long DEFAULT_LASTMSGID = 0L;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.userNum == null) {
                this.userNum = DEFAULT_USERNUM;
            } else {
                this.userNum = builder.userNum;
            }
            if (builder.maxUserNum == null) {
                this.maxUserNum = DEFAULT_MAXUSERNUM;
            } else {
                this.maxUserNum = builder.maxUserNum;
            }
            if (builder.userList == null) {
                this.userList = DEFAULT_USERLIST;
            } else {
                this.userList = immutableCopyOf(builder.userList);
            }
            if (builder.durationTime == null) {
                this.durationTime = DEFAULT_DURATIONTIME;
            } else {
                this.durationTime = builder.durationTime;
            }
            if (builder.silenceTime == null) {
                this.silenceTime = DEFAULT_SILENCETIME;
            } else {
                this.silenceTime = builder.silenceTime;
            }
            if (builder.averageWaitTime == null) {
                this.averageWaitTime = DEFAULT_AVERAGEWAITTIME;
            } else {
                this.averageWaitTime = builder.averageWaitTime;
            }
            if (builder.title == null) {
                this.title = "";
            } else {
                this.title = builder.title;
            }
            if (builder.content == null) {
                this.content = "";
            } else {
                this.content = builder.content;
            }
            if (builder.topicList == null) {
                this.topicList = DEFAULT_TOPICLIST;
            } else {
                this.topicList = immutableCopyOf(builder.topicList);
            }
            if (builder.lastMsgId == null) {
                this.lastMsgId = DEFAULT_LASTMSGID;
                return;
            } else {
                this.lastMsgId = builder.lastMsgId;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.userNum = builder.userNum;
        this.maxUserNum = builder.maxUserNum;
        this.userList = immutableCopyOf(builder.userList);
        this.durationTime = builder.durationTime;
        this.silenceTime = builder.silenceTime;
        this.averageWaitTime = builder.averageWaitTime;
        this.title = builder.title;
        this.content = builder.content;
        this.topicList = immutableCopyOf(builder.topicList);
        this.lastMsgId = builder.lastMsgId;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public Integer averageWaitTime;
        public String content;
        public Integer durationTime;
        public Integer groupId;
        public Long lastMsgId;
        public Integer maxUserNum;
        public Integer silenceTime;
        public String title;
        public List<ChatroomTopic> topicList;
        public List<UserInfo> userList;
        public Integer userNum;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groupId = dataRes.groupId;
                this.userNum = dataRes.userNum;
                this.maxUserNum = dataRes.maxUserNum;
                this.userList = DataRes.copyOf(dataRes.userList);
                this.durationTime = dataRes.durationTime;
                this.silenceTime = dataRes.silenceTime;
                this.averageWaitTime = dataRes.averageWaitTime;
                this.title = dataRes.title;
                this.content = dataRes.content;
                this.topicList = DataRes.copyOf(dataRes.topicList);
                this.lastMsgId = dataRes.lastMsgId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
