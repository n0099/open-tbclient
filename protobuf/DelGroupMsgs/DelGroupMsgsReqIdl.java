package protobuf.DelGroupMsgs;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes8.dex */
public final class DelGroupMsgsReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<DelGroupMsgsReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(DelGroupMsgsReqIdl delGroupMsgsReqIdl) {
            super(delGroupMsgsReqIdl);
            if (delGroupMsgsReqIdl == null) {
                return;
            }
            this.data = delGroupMsgsReqIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DelGroupMsgsReqIdl build(boolean z) {
            return new DelGroupMsgsReqIdl(this, z);
        }
    }

    public DelGroupMsgsReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }
}
