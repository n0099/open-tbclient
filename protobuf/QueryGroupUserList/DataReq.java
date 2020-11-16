package protobuf.QueryGroupUserList;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes22.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer offset;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer orderType;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer rn;
    public static final Long DEFAULT_GROUPID = 0L;
    public static final Integer DEFAULT_OFFSET = 0;
    public static final Integer DEFAULT_RN = 0;
    public static final Integer DEFAULT_ORDERTYPE = 0;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
            } else {
                this.groupId = builder.groupId;
            }
            if (builder.offset == null) {
                this.offset = DEFAULT_OFFSET;
            } else {
                this.offset = builder.offset;
            }
            if (builder.rn == null) {
                this.rn = DEFAULT_RN;
            } else {
                this.rn = builder.rn;
            }
            if (builder.orderType == null) {
                this.orderType = DEFAULT_ORDERTYPE;
                return;
            } else {
                this.orderType = builder.orderType;
                return;
            }
        }
        this.groupId = builder.groupId;
        this.offset = builder.offset;
        this.rn = builder.rn;
        this.orderType = builder.orderType;
    }

    /* loaded from: classes22.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long groupId;
        public Integer offset;
        public Integer orderType;
        public Integer rn;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.groupId = dataReq.groupId;
                this.offset = dataReq.offset;
                this.rn = dataReq.rn;
                this.orderType = dataReq.orderType;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
