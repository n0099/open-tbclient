package protobuf.DelGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class DataRes extends Message {
    public static final String DEFAULT_GROUPNAME = "";
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer activityId;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String groupName;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer isEnd;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_ACTIVITYID = 0;
    public static final Integer DEFAULT_ISEND = 0;

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
            if (builder.activityId == null) {
                this.activityId = DEFAULT_ACTIVITYID;
            } else {
                this.activityId = builder.activityId;
            }
            if (builder.isEnd == null) {
                this.isEnd = DEFAULT_ISEND;
                return;
            } else {
                this.isEnd = builder.isEnd;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.groupName = builder.groupName;
        this.activityId = builder.activityId;
        this.isEnd = builder.isEnd;
    }

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DataRes> {
        public Integer activityId;
        public Long groupId;
        public String groupName;
        public Integer isEnd;

        public Builder() {
        }

        public Builder(DataRes dataRes) {
            super(dataRes);
            if (dataRes != null) {
                this.groupId = dataRes.groupId;
                this.groupName = dataRes.groupName;
                this.activityId = dataRes.activityId;
                this.isEnd = dataRes.isEnd;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataRes build(boolean z) {
            return new DataRes(this, z);
        }
    }
}
