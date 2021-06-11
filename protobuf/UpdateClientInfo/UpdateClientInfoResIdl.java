package protobuf.UpdateClientInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes8.dex */
public final class UpdateClientInfoResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<UpdateClientInfoResIdl> {
        public DataRes data;
        public Error error;

        public Builder() {
        }

        public Builder(UpdateClientInfoResIdl updateClientInfoResIdl) {
            super(updateClientInfoResIdl);
            if (updateClientInfoResIdl == null) {
                return;
            }
            this.error = updateClientInfoResIdl.error;
            this.data = updateClientInfoResIdl.data;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UpdateClientInfoResIdl build(boolean z) {
            return new UpdateClientInfoResIdl(this, z);
        }
    }

    public UpdateClientInfoResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }
}
