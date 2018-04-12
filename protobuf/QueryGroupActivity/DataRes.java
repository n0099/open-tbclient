package protobuf.QueryGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes3.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_ACTIVITYPORTRAIT = "";
    public static final String DEFAULT_GACTIVITYAREA = "";
    public static final String DEFAULT_GACTIVITYCONTENT = "";
    public static final String DEFAULT_GACTIVITYTITLE = "";
    public static final String DEFAULT_USERNAME = "";
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer activityId;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String activityPortrait;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String gActivityArea;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String gActivityContent;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long gActivityTime;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String gActivityTitle;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer isEnd;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long userId;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String userName;
    public static final Integer DEFAULT_ACTIVITYID = 0;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Long DEFAULT_USERID = 0L;
    public static final Long DEFAULT_GACTIVITYTIME = 0L;
    public static final Integer DEFAULT_ISEND = 0;

    private DataRes(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.activityId == null) {
                this.activityId = DEFAULT_ACTIVITYID;
            } else {
                this.activityId = builder.activityId;
            }
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.userId == null) {
                this.userId = DEFAULT_USERID;
            } else {
                this.userId = builder.userId;
            }
            if (builder.gActivityTitle == null) {
                this.gActivityTitle = "";
            } else {
                this.gActivityTitle = builder.gActivityTitle;
            }
            if (builder.gActivityTime == null) {
                this.gActivityTime = DEFAULT_GACTIVITYTIME;
            } else {
                this.gActivityTime = builder.gActivityTime;
            }
            if (builder.gActivityContent == null) {
                this.gActivityContent = "";
            } else {
                this.gActivityContent = builder.gActivityContent;
            }
            if (builder.gActivityArea == null) {
                this.gActivityArea = "";
            } else {
                this.gActivityArea = builder.gActivityArea;
            }
            if (builder.isEnd == null) {
                this.isEnd = DEFAULT_ISEND;
            } else {
                this.isEnd = builder.isEnd;
            }
            if (builder.activityPortrait == null) {
                this.activityPortrait = "";
            } else {
                this.activityPortrait = builder.activityPortrait;
            }
            if (builder.userName == null) {
                this.userName = "";
                return;
            } else {
                this.userName = builder.userName;
                return;
            }
        }
        this.activityId = builder.activityId;
        this.groupId = builder.groupId;
        this.userId = builder.userId;
        this.gActivityTitle = builder.gActivityTitle;
        this.gActivityTime = builder.gActivityTime;
        this.gActivityContent = builder.gActivityContent;
        this.gActivityArea = builder.gActivityArea;
        this.isEnd = builder.isEnd;
        this.activityPortrait = builder.activityPortrait;
        this.userName = builder.userName;
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer activityId;
        public String activityPortrait;
        public String gActivityArea;
        public String gActivityContent;
        public Long gActivityTime;
        public String gActivityTitle;
        public Long groupId;
        public Integer isEnd;
        public Long userId;
        public String userName;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.activityId = dataRes.activityId;
                this.groupId = dataRes.groupId;
                this.userId = dataRes.userId;
                this.gActivityTitle = dataRes.gActivityTitle;
                this.gActivityTime = dataRes.gActivityTime;
                this.gActivityContent = dataRes.gActivityContent;
                this.gActivityArea = dataRes.gActivityArea;
                this.isEnd = dataRes.isEnd;
                this.activityPortrait = dataRes.activityPortrait;
                this.userName = dataRes.userName;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
