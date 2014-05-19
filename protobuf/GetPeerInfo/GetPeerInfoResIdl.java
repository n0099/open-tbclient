package protobuf.GetPeerInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes.dex */
public final class GetPeerInfoResIdl extends Message {
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;

    /* synthetic */ GetPeerInfoResIdl(Builder builder, boolean z, GetPeerInfoResIdl getPeerInfoResIdl) {
        this(builder, z);
    }

    private GetPeerInfoResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GetPeerInfoResIdl> {
        public DataRes data;
        public Error error;

        public Builder(GetPeerInfoResIdl getPeerInfoResIdl) {
            super(getPeerInfoResIdl);
            if (getPeerInfoResIdl != null) {
                this.error = getPeerInfoResIdl.error;
                this.data = getPeerInfoResIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetPeerInfoResIdl build(boolean z) {
            return new GetPeerInfoResIdl(this, z, null);
        }
    }
}
