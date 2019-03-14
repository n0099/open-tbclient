package protobuf.QueryGroupGrade;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes5.dex */
public final class DataReq extends Message {
    public static final Long DEFAULT_GROUPID = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
                return;
            } else {
                this.groupId = builder.groupId;
                return;
            }
        }
        this.groupId = builder.groupId;
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long groupId;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
