package protobuf.GetAccessToken;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GetAccessTokenReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ GetAccessTokenReqIdl(Builder builder, boolean z, GetAccessTokenReqIdl getAccessTokenReqIdl) {
        this(builder, z);
    }

    private GetAccessTokenReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GetAccessTokenReqIdl> {
        public DataReq data;

        public Builder(GetAccessTokenReqIdl getAccessTokenReqIdl) {
            super(getAccessTokenReqIdl);
            if (getAccessTokenReqIdl != null) {
                this.data = getAccessTokenReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetAccessTokenReqIdl build(boolean z) {
            return new GetAccessTokenReqIdl(this, z, null);
        }
    }
}
