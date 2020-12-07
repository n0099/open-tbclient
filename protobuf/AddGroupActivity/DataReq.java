package protobuf.AddGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes23.dex */
public final class DataReq extends Message {
    public static final String DEFAULT_GACTIVITYAREA = "";
    public static final String DEFAULT_GACTIVITYCONTENT = "";
    public static final String DEFAULT_GACTIVITYTITLE = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer activityId;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer commitType;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String gActivityArea;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String gActivityContent;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long gActivityTime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String gActivityTitle;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_ACTIVITYID = 0;
    public static final Long DEFAULT_GACTIVITYTIME = 0L;
    public static final Integer DEFAULT_COMMITTYPE = 0;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.activityId == null) {
                this.activityId = DEFAULT_ACTIVITYID;
            } else {
                this.activityId = builder.activityId;
            }
            if (builder.gActivityTitle == null) {
                this.gActivityTitle = "";
            } else {
                this.gActivityTitle = builder.gActivityTitle;
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
            if (builder.gActivityTime == null) {
                this.gActivityTime = DEFAULT_GACTIVITYTIME;
            } else {
                this.gActivityTime = builder.gActivityTime;
            }
            if (builder.commitType == null) {
                this.commitType = DEFAULT_COMMITTYPE;
                return;
            } else {
                this.commitType = builder.commitType;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.activityId = builder.activityId;
        this.gActivityTitle = builder.gActivityTitle;
        this.gActivityContent = builder.gActivityContent;
        this.gActivityArea = builder.gActivityArea;
        this.gActivityTime = builder.gActivityTime;
        this.commitType = builder.commitType;
    }

    /* loaded from: classes23.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer activityId;
        public Integer commitType;
        public String gActivityArea;
        public String gActivityContent;
        public Long gActivityTime;
        public String gActivityTitle;
        public Long groupId;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.activityId = dataReq.activityId;
                this.gActivityTitle = dataReq.gActivityTitle;
                this.gActivityContent = dataReq.gActivityContent;
                this.gActivityArea = dataReq.gActivityArea;
                this.gActivityTime = dataReq.gActivityTime;
                this.commitType = dataReq.commitType;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
