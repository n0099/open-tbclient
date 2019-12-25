package protobuf.DelGroup;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes5.dex */
public final class DelGroupReqIdl extends Message {
    @ProtoField(tag = 2)
    public final DataReq data;

    private DelGroupReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.Builder<DelGroupReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(DelGroupReqIdl delGroupReqIdl) {
            super(delGroupReqIdl);
            if (delGroupReqIdl != null) {
                this.data = delGroupReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public DelGroupReqIdl build(boolean z) {
            return new DelGroupReqIdl(this, z);
        }
    }
}
