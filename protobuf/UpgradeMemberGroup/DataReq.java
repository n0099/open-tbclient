package protobuf.UpgradeMemberGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer flag;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_FLAG = 0;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Integer flag;
        public Long groupId;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq == null) {
                return;
            }
            this.groupId = dataReq.groupId;
            this.flag = dataReq.flag;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }

    public DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Long l = builder.groupId;
            if (l == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = l;
            }
            Integer num = builder.flag;
            if (num == null) {
                this.flag = DEFAULT_FLAG;
                return;
            } else {
                this.flag = num;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.flag = builder.flag;
    }
}
