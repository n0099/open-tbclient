package protobuf.GetPeerInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GetPeerInfoReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ GetPeerInfoReqIdl(Builder builder, boolean z, GetPeerInfoReqIdl getPeerInfoReqIdl) {
        this(builder, z);
    }

    private GetPeerInfoReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GetPeerInfoReqIdl> {
        public DataReq data;

        public Builder(GetPeerInfoReqIdl getPeerInfoReqIdl) {
            super(getPeerInfoReqIdl);
            if (getPeerInfoReqIdl != null) {
                this.data = getPeerInfoReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetPeerInfoReqIdl build(boolean z) {
            return new GetPeerInfoReqIdl(this, z, null);
        }
    }
}
