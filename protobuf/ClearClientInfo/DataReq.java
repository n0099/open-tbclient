package protobuf.ClearClientInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes11.dex */
public final class DataReq extends Message {
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long groupId;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer unread_msg;
    public static final Integer DEFAULT_UNREAD_MSG = 0;
    public static final Long DEFAULT_GROUPID = 0L;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.unread_msg == null) {
                this.unread_msg = DEFAULT_UNREAD_MSG;
            } else {
                this.unread_msg = builder.unread_msg;
            }
            if (builder.groupId == null) {
                this.groupId = DEFAULT_GROUPID;
                return;
            } else {
                this.groupId = builder.groupId;
                return;
            }
        }
        this.unread_msg = builder.unread_msg;
        this.groupId = builder.groupId;
    }

    /* loaded from: classes11.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long groupId;
        public Integer unread_msg;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.unread_msg = dataReq.unread_msg;
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
