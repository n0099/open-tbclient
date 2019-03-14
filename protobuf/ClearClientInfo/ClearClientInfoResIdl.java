package protobuf.ClearClientInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes3.dex */
public final class ClearClientInfoResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    private ClearClientInfoResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<ClearClientInfoResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(ClearClientInfoResIdl clearClientInfoResIdl) {
            super(clearClientInfoResIdl);
            if (clearClientInfoResIdl != null) {
                this.error = clearClientInfoResIdl.error;
                this.data = clearClientInfoResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public ClearClientInfoResIdl build(boolean z) {
            return new ClearClientInfoResIdl(this, z);
        }
    }
}
