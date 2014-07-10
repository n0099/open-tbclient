package protobuf.QueryChatroomInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(tag = 8, type = Message.Datatype.INT64)
    public final Long lastMsgId;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer leftTime;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer maxUserNum;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<UserInfo> userList;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer userNum;
    public static final Integer DEFAULT_USERNUM = 0;
    public static final List<UserInfo> DEFAULT_USERLIST = Collections.emptyList();
    public static final Integer DEFAULT_MAXUSERNUM = 0;
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_LEFTTIME = 0;
    public static final Long DEFAULT_LASTMSGID = 0L;

    /* synthetic */ DataRes(Builder builder, boolean z, DataRes dataRes) {
        this(builder, z);
    }

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.userNum == null) {
                this.userNum = DEFAULT_USERNUM;
            } else {
                this.userNum = builder.userNum;
            }
            if (builder.userList == null) {
                this.userList = DEFAULT_USERLIST;
            } else {
                this.userList = immutableCopyOf(builder.userList);
            }
            if (builder.maxUserNum == null) {
                this.maxUserNum = DEFAULT_MAXUSERNUM;
            } else {
                this.maxUserNum = builder.maxUserNum;
            }
            if (builder.status == null) {
                this.status = DEFAULT_STATUS;
            } else {
                this.status = builder.status;
            }
            if (builder.leftTime == null) {
                this.leftTime = DEFAULT_LEFTTIME;
            } else {
                this.leftTime = builder.leftTime;
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
            if (builder.lastMsgId == null) {
                this.lastMsgId = DEFAULT_LASTMSGID;
                return;
            } else {
                this.lastMsgId = builder.lastMsgId;
                return;
            }
        }
        this.userNum = builder.userNum;
        this.userList = immutableCopyOf(builder.userList);
        this.maxUserNum = builder.maxUserNum;
        this.status = builder.status;
        this.leftTime = builder.leftTime;
        this.title = builder.title;
        this.content = builder.content;
        this.lastMsgId = builder.lastMsgId;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public String content;
        public Long lastMsgId;
        public Integer leftTime;
        public Integer maxUserNum;
        public Integer status;
        public String title;
        public List<UserInfo> userList;
        public Integer userNum;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.userNum = dataRes.userNum;
                this.userList = DataRes.copyOf(dataRes.userList);
                this.maxUserNum = dataRes.maxUserNum;
                this.status = dataRes.status;
                this.leftTime = dataRes.leftTime;
                this.title = dataRes.title;
                this.content = dataRes.content;
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
