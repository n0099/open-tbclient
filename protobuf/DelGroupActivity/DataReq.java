package protobuf.DelGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer activityId;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_ACTIVITYID = 0;

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
                return;
            } else {
                this.activityId = builder.activityId;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.activityId = builder.activityId;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer activityId;
        public Long groupId;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.activityId = dataReq.activityId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
