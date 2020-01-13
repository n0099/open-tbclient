package protobuf.QueryUserInfos;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes7.dex */
public final class DataReq extends Message {
    public static final Long DEFAULT_REQUSERID = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long reqUserId;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.reqUserId == null) {
                this.reqUserId = DEFAULT_REQUSERID;
                return;
            } else {
                this.reqUserId = builder.reqUserId;
                return;
            }
        }
        this.reqUserId = builder.reqUserId;
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long reqUserId;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.reqUserId = dataReq.reqUserId;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
