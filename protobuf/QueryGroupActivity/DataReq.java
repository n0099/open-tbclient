package protobuf.QueryGroupActivity;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes17.dex */
public final class DataReq extends Message {
    public static final Integer DEFAULT_ACTIVITYID = 0;
    public static final Integer DEFAULT_FROM = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer activityId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer from;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.activityId == null) {
                this.activityId = DEFAULT_ACTIVITYID;
            } else {
                this.activityId = builder.activityId;
            }
            if (builder.from == null) {
                this.from = DEFAULT_FROM;
                return;
            } else {
                this.from = builder.from;
                return;
            }
        }
        this.activityId = builder.activityId;
        this.from = builder.from;
    }

    /* loaded from: classes17.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer activityId;
        public Integer from;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.activityId = dataReq.activityId;
                this.from = dataReq.from;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
