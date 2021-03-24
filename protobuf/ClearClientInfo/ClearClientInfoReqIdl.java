package protobuf.ClearClientInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class ClearClientInfoReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<ClearClientInfoReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(ClearClientInfoReqIdl clearClientInfoReqIdl) {
            super(clearClientInfoReqIdl);
            if (clearClientInfoReqIdl == null) {
                return;
            }
            this.data = clearClientInfoReqIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ClearClientInfoReqIdl build(boolean z) {
            return new ClearClientInfoReqIdl(this, z);
        }
    }

    public ClearClientInfoReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }
}
