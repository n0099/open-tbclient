package protobuf.GetOnlineInfo;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes.dex */
public final class GetOnlineInfoReqIdl extends Message {
    @ProtoField(tag = 1)
    public final DataReq data;

    /* synthetic */ GetOnlineInfoReqIdl(Builder builder, boolean z, GetOnlineInfoReqIdl getOnlineInfoReqIdl) {
        this(builder, z);
    }

    private GetOnlineInfoReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.data = builder.data;
        } else {
            this.data = builder.data;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<GetOnlineInfoReqIdl> {
        public DataReq data;

        public Builder() {
        }

        public Builder(GetOnlineInfoReqIdl getOnlineInfoReqIdl) {
            super(getOnlineInfoReqIdl);
            if (getOnlineInfoReqIdl != null) {
                this.data = getOnlineInfoReqIdl.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GetOnlineInfoReqIdl build(boolean z) {
            return new GetOnlineInfoReqIdl(this, z, null);
        }
    }
}
