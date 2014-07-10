package protobuf.AddGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_GACTIVITYAREA = "";
    public static final String DEFAULT_GACTIVITYTITLE = "";
    public static final String DEFAULT_GROUPNAME = "";
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long activityId;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String gActivityArea;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long gActivityTime;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String gActivityTitle;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer groupId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String groupName;
    public static final Integer DEFAULT_GROUPID = 0;
    public static final Long DEFAULT_GACTIVITYTIME = 0L;
    public static final Long DEFAULT_ACTIVITYID = 0L;

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
            if (builder.groupName == null) {
                this.groupName = "";
            } else {
                this.groupName = builder.groupName;
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
            if (builder.activityId == null) {
                this.activityId = DEFAULT_ACTIVITYID;
            } else {
                this.activityId = builder.activityId;
            }
            if (builder.gActivityArea == null) {
                this.gActivityArea = "";
                return;
            } else {
                this.gActivityArea = builder.gActivityArea;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.groupName = builder.groupName;
        this.gActivityTitle = builder.gActivityTitle;
        this.gActivityTime = builder.gActivityTime;
        this.activityId = builder.activityId;
        this.gActivityArea = builder.gActivityArea;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<DataRes> {
        public Long activityId;
        public String gActivityArea;
        public Long gActivityTime;
        public String gActivityTitle;
        public Integer groupId;
        public String groupName;

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groupId = dataRes.groupId;
                this.groupName = dataRes.groupName;
                this.gActivityTitle = dataRes.gActivityTitle;
                this.gActivityTime = dataRes.gActivityTime;
                this.activityId = dataRes.activityId;
                this.gActivityArea = dataRes.gActivityArea;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z, null);
        }
    }
}
