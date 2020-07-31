package protobuf.CheckMaskUser;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes16.dex */
public final class DataReq extends Message {
    public static final Long DEFAULT_UID = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long uid;

    private DataReq(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.uid == null) {
                this.uid = DEFAULT_UID;
                return;
            } else {
                this.uid = builder.uid;
                return;
            }
        }
        this.uid = builder.uid;
    }

    /* loaded from: classes16.dex */
    public static final class Builder extends Message.Builder<DataReq> {
        public Long uid;

        public Builder() {
        }

        public Builder(DataReq dataReq) {
            super(dataReq);
            if (dataReq != null) {
                this.uid = dataReq.uid;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DataReq build(boolean z) {
            return new DataReq(this, z);
        }
    }
}
